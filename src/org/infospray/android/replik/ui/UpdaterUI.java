package org.infospray.android.replik.ui;

import org.infospray.android.replik.ClassementActivity;
import org.infospray.android.replik.GameActivity;
import org.infospray.android.replik.LoginActivity;
import org.infospray.android.replik.utils.PseudoCredentials;
import org.infospray.android.replik.ws.ValidateAnswerInputParameter;
import org.infospray.android.replik.ws.beans.ValidateUserBean;

public class UpdaterUI {

	private UpdaterUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public static void game(GameActivity activity){
		
		GameAsyncUI asyncGame = new GameAsyncUI(activity);
		ValidateUserBean user = new ValidateUserBean();
		user.setPseudo(activity.getPseudo());
		user.setSecurityString(activity.getSecurityString());		
		asyncGame.execute(user);
		
	}
	
	
	public static void synchronisation(ClassementActivity activity){
		SynchronisationAsyncUI synchro = new SynchronisationAsyncUI(activity);
		PseudoCredentials pseudoCredentials = new PseudoCredentials();
		pseudoCredentials.setPseudo(activity.getPseudo());
		pseudoCredentials.setSecurityString(activity.getSecurityString());	
		synchro.execute(pseudoCredentials);		
	}
	
	public static void gameValidateAnswer(ValidateAnswerInputParameter validateAnswer, GameActivity activity){
		
		GameValidateAnswerAsyncUI asyncGameValidate = new GameValidateAnswerAsyncUI(activity);
		asyncGameValidate.execute(validateAnswer);
		
	}
	
	
	public static void classement(ClassementActivity activity){
		
		ClassementAsyncUI asyncClassement = new ClassementAsyncUI(activity);
		ValidateUserBean user = new ValidateUserBean();
		user.setPseudo(activity.getPseudo());
		user.setSecurityString(activity.getSecurityString());		
		asyncClassement.execute(user);
		
	}
	
	public static void validatePseudo(LoginActivity activity){
		
		ValidatePseudoAsyncUI asyncPseudo = new ValidatePseudoAsyncUI(activity);
		PseudoCredentials pseudoCredentials = new PseudoCredentials();
		pseudoCredentials.setPseudo(activity.getPseudo());
		pseudoCredentials.setSecurityString(activity.getSecurityString());		
		asyncPseudo.execute(pseudoCredentials);
		
	}
	
	
}
