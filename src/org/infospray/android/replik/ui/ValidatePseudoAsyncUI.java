package org.infospray.android.replik.ui;

import org.infospray.android.replik.ClassementActivity;
import org.infospray.android.replik.LoginActivity;
import org.infospray.android.replik.R;
import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.utils.PseudoCredentials;
import org.infospray.android.replik.ws.beans.ConstantsError;
import org.infospray.android.replik.ws.beans.ValidateUserBean;
import org.infospray.android.replik.ws.call.CommonCallWs;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;



public class ValidatePseudoAsyncUI extends AsyncTask<PseudoCredentials, Integer, ValidateUserBean> {


	private LoginActivity		activity;
	
	
	public ValidatePseudoAsyncUI(LoginActivity activity) {
		super();
		this.activity = activity;
	}


	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		this.activity.getProgressBar().setVisibility(View.VISIBLE);
	
	}
	
	

	@Override
	protected void onPostExecute(ValidateUserBean  result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		this.activity.getProgressBar().setVisibility(View.GONE);
		if(result!= null && result.getCodeRetour().equals(ConstantsError.OK_CODE)){
			
			// sauvegarde du pseudo 
			this.activity.getEditor().putString(Constants.PSEUDO, result.getPseudo());
			this.activity.getEditor().putString(Constants.SECURITY_STRING, result.getSecurityString());
			this.activity.getEditor().commit();
		    
			Intent intent = new Intent(this.activity, ClassementActivity.class);
			intent.putExtra(Constants.PSEUDO,this.activity.getPseudo());
			intent.putExtra(Constants.SECURITY_STRING,result.getSecurityString());	
			this.activity.startActivity(intent);
		
		}else{
			if(result != null && result.getCodeRetour().equals(ConstantsError.USER_STILL_EXITS_CODE)){
				this.activity.getEdPseudo().setText("");
				this.activity.getEdPseudo().setHint(result.getLibelleRetour());
			}else{			
				Toast toast = Toast.makeText(this.activity, R.string.errorSrvLogin, Constants.TOAST_DURATION);
				toast.show();
			}
			
		}
	}


	@Override
	protected ValidateUserBean doInBackground(PseudoCredentials... params) {
		return CommonCallWs.callValidateUserWs(params[0]);
	}
	
	
	
}
