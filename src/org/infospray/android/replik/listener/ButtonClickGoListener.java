package org.infospray.android.replik.listener;

import org.infospray.android.replik.LoginActivity;
import org.infospray.android.replik.ui.UpdaterUI;
import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.utils.PseudoCredentials;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;

public class ButtonClickGoListener implements OnClickListener {


	LoginActivity loginActivityInstance = null;
	
	

	public ButtonClickGoListener(LoginActivity instance) {
		this.loginActivityInstance = instance;
	}

	@Override
	public void onClick(View v) {

		if(this.loginActivityInstance.getEdPseudo().getText() != null && !this.loginActivityInstance.getEdPseudo().getText().toString().equals("")){
			
			this.loginActivityInstance.setPseudo(this.loginActivityInstance.getEdPseudo().getText().toString());
			if(this.loginActivityInstance.getPseudo().length() > Integer.valueOf(Constants.PSEUDO_MAX_LENGTH).intValue()){
				this.loginActivityInstance.getEdPseudo().setText("");
				this.loginActivityInstance.getEdPseudo().setHint(Constants.PSEUDO_MAX_LENGTH_MESSAGE);
				return;
			}
			
			SharedPreferences settings = v.getContext().getSharedPreferences(Constants.REPLIK_USER_FILE,0);
			String pseudoStockInData = settings.getString(Constants.PSEUDO, "");
			String securityStringStockInData = "";
			if(pseudoStockInData.equals(this.loginActivityInstance.getPseudo())){
				securityStringStockInData = settings.getString(Constants.SECURITY_STRING, "");
			}
			
			PseudoCredentials pseudoCrendentials = new PseudoCredentials();
			if(pseudoStockInData.equals("")){
				pseudoCrendentials.setPseudo(this.loginActivityInstance.getPseudo());
			}
			else{
				pseudoCrendentials.setPseudo(this.loginActivityInstance.getPseudo());
				pseudoCrendentials.setSecurityString(securityStringStockInData);
			}
			
			
			UpdaterUI.validatePseudo(this.loginActivityInstance);
		//	ValidateUserBean validateUserBean =  new ValidateUserBean();
		//	validateUserBean = CommonCallWs.callValidateUserWs(pseudoCrendentials);

			
			/*if(!validateUserBean.getCodeRetour().equals(ConstantsError.OK_CODE)){
				this.loginActivityInstance.getEdPseudo().setText("");
				this.loginActivityInstance.getEdPseudo().setHint(validateUserBean.getLibelleRetour());
			    
			}else{

				SharedPreferences.Editor editor = settings.edit();
			    editor.putString(Constants.PSEUDO, validateUserBean.getPseudo());
			    editor.putString(Constants.SECURITY_STRING, validateUserBean.getSecurityString());
			    editor.commit();
				Intent intent = new Intent(this.loginActivityInstance, ClassementActivity.class);
				intent.putExtra(Constants.PSEUDO,this.loginActivityInstance.getEdPseudo().getText().toString());
				intent.putExtra(Constants.SECURITY_STRING,validateUserBean.getSecurityString());	
				this.loginActivityInstance.startActivity(intent);
			}*/
			
		
		}

	}

}
