package org.infospray.android.replik.listener;


import org.infospray.android.replik.ClassementActivity;
import org.infospray.android.replik.ui.UpdaterUI;

import android.view.View;
import android.view.View.OnClickListener;

public class ButtonClickPlayListener implements OnClickListener {

	ClassementActivity classementActivityInstance = null;

	public ButtonClickPlayListener(ClassementActivity instance) {
		this.classementActivityInstance = instance;
	}

	@Override
	public void onClick(View v) {
		
		UpdaterUI.synchronisation(this.classementActivityInstance);

		/*PseudoCredentials pseudoCredentials = new PseudoCredentials();
		pseudoCredentials.setPseudo(this.classementActivityInstance.getPseudo());
		pseudoCredentials.setSecurityString(this.classementActivityInstance.getSecurityString());
		SynchronisationBean synchronisationBean = CommonCallWs.callSynchronisationWs(pseudoCredentials);
		if(synchronisationBean.getCodeRetour().equals(ConstantsError.OK_CODE)){
			this.classementActivityInstance.getCounterTimeLeft().cancel();
			if(synchronisationBean.getGameReady().equals(Constants.TRUE)){
				Intent intent = new Intent(this.classementActivityInstance, GameActivity.class);
				intent.putExtra(Constants.PSEUDO,this.classementActivityInstance.getPseudo());
				intent.putExtra(Constants.SECURITY_STRING,this.classementActivityInstance.getSecurityString());	
				this.classementActivityInstance.startActivity(intent);
			}else{
				this.classementActivityInstance.getBoutonJouer().setText("Nouvelle manche dans x sec");
				this.classementActivityInstance.getBoutonJouer().setEnabled(false);
				
			}
		}else{
			Toast toast = Toast.makeText(this.classementActivityInstance, R.string.errorSync, Constants.TOAST_DURATION);
			toast.show();
		}
		 */
	}

}
