package org.infospray.android.replik.ui;




import org.infospray.android.replik.ClassementActivity;

import org.infospray.android.replik.R;
import org.infospray.android.replik.adapter.UsersArrayAdapter;
import org.infospray.android.replik.listener.ButtonClickPlayListener;
import org.infospray.android.replik.rebourd.RebourdClassement;
import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.ws.beans.ClassementBean;
import org.infospray.android.replik.ws.beans.ConstantsError;

import org.infospray.android.replik.ws.beans.ValidateUserBean;
import org.infospray.android.replik.ws.call.CommonCallWs;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;



public class ClassementAsyncUI extends AsyncTask<ValidateUserBean, Integer, ClassementBean> {


	private ClassementActivity		activity;
	private ProgressDialog		pd;
	
	
	
	
	public ClassementAsyncUI(ClassementActivity activity) {
		super();
		this.activity = activity;
	}


	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		this.activity.getBoutonRefresh().setEnabled(false);
		this.pd = new ProgressDialog(this.activity);
		this.pd.setIndeterminate(true);
		this.pd.setMessage("Chargement du classement ...");
		this.pd.show();
	}
	
	


	@Override
	protected void onPostExecute(ClassementBean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		this.pd.dismiss();

		if(result!= null && result.getCodeRetour().equals(ConstantsError.OK_CODE) ){
			UsersArrayAdapter userAdapter = new UsersArrayAdapter(this.activity, result.getListeUser());
			this.activity.getListUser().setAdapter(userAdapter);
			this.activity.getTvNombrejoueurs().setText("Joueurs : " + result.getNbJoueurs());
			this.activity.getTvNumeroReplik().setText(result.getCurrentReplik());
			this.activity.getTvNombreReplik().setText(result.getTotalReplik());

			ButtonClickPlayListener listenerPlay = new ButtonClickPlayListener(this.activity);
			this.activity.getBoutonJouer().setOnClickListener(listenerPlay);


			long tempsattente = 0;
			if(result.getGameReady().equals(Constants.TRUE)){
				tempsattente = Long.valueOf(result.getTimeBeforeReplikChange()) ;
				this.activity.getBoutonJouer().setText(R.string.jouer);
				this.activity.getBoutonJouer().setEnabled(true);
			}else{
				tempsattente = Long.valueOf(result.getTempsRestantAvantDebutManche());
				this.activity.getBoutonJouer().setEnabled(false);
			}

			this.activity.setSecondeEntreManche(Long.valueOf(result.getSecondEntreManche()) * Constants.SECOND);
			this.activity.setSecondeParReplik(Long.valueOf(result.getSecondParReplik()) * Constants.SECOND);
			this.activity.setNbReplik(Integer.valueOf(result.getTotalReplik()));
			this.activity.setCurrentReplikNo(Integer.valueOf(result.getCurrentReplik()));


			RebourdClassement rebourd = new RebourdClassement(this.activity,tempsattente, Constants.SECOND, Boolean.valueOf(false),Boolean.valueOf(false));
			this.activity.setCounterTimeLeft(rebourd);
			this.activity.getCounterTimeLeft().start();

		}else{

			Toast toast = Toast.makeText(this.activity, R.string.errorClassement, Constants.TOAST_DURATION);
			toast.show();

		}
		this.activity.getBoutonRefresh().setEnabled(true);
	}


	


	@Override
	protected ClassementBean doInBackground(ValidateUserBean... params) {

		return CommonCallWs.callClassementWs(params[0]);
	}


	public ClassementActivity getActivity() {
		return activity;
	}


	public void setActivity(ClassementActivity activity) {
		this.activity = activity;
	}
	
	
	
}
