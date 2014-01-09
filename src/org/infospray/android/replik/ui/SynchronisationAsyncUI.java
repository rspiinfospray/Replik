package org.infospray.android.replik.ui;

import org.infospray.android.replik.ClassementActivity;
import org.infospray.android.replik.GameActivity;
import org.infospray.android.replik.R;
import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.utils.PseudoCredentials;
import org.infospray.android.replik.ws.beans.ConstantsError;
import org.infospray.android.replik.ws.beans.SynchronisationBean;
import org.infospray.android.replik.ws.call.CommonCallWs;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;




public class SynchronisationAsyncUI extends AsyncTask<PseudoCredentials, Integer, SynchronisationBean> {


	private ClassementActivity		activity;
	private ProgressDialog			pd;
	
	
	
	
	public SynchronisationAsyncUI(ClassementActivity activity) {
		super();
		this.activity = activity;
	}


	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		this.pd = new ProgressDialog(this.activity);
		this.pd.setIndeterminate(true);
		this.pd.setMessage("Chargement de la manche ...");
		this.pd.show();
	}
	
	


	@Override
	protected void onPostExecute(SynchronisationBean result) {
	
		super.onPostExecute(result);
		this.pd.dismiss();
		
		if(result!= null && result.getCodeRetour().equals(ConstantsError.OK_CODE)){
			this.activity.getCounterTimeLeft().cancel();
			if(result.getGameReady().equals(Constants.TRUE)){
				Intent intent = new Intent(this.activity, GameActivity.class);
				intent.putExtra(Constants.PSEUDO,this.activity.getPseudo());
				intent.putExtra(Constants.SECURITY_STRING,this.activity.getSecurityString());	
				this.activity.startActivity(intent);
			}else{
				this.activity.getBoutonJouer().setText("Nouvelle manche dans x sec");
				this.activity.getBoutonJouer().setEnabled(false);
				/*Intent intent = new Intent(this.classementActivityInstance, LoadGameActivity.class);
				intent.putExtra(Constants.PSEUDO,this.classementActivityInstance.getPseudo());
				intent.putExtra(Constants.SECURITY_STRING,this.classementActi*/
			}
		}else{
			Toast toast = Toast.makeText(this.activity, R.string.errorSync, Constants.TOAST_DURATION);
			toast.show();
		}
		
	}


	


	@Override
	protected SynchronisationBean doInBackground(PseudoCredentials ... params) {
		return CommonCallWs.callSynchronisationWs(params[0]);
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(ClassementActivity activity) {
		this.activity = activity;
	}
	
	
	
}
