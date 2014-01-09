package org.infospray.android.replik.rebourd;

import org.infospray.android.replik.ClassementActivity;
import org.infospray.android.replik.R;
import org.infospray.android.replik.utils.Constants;


import android.os.CountDownTimer;


public class RebourdClassement extends CountDownTimer {


	private long millisInFuture;
	private long countDownInterval;
	private ClassementActivity classementAcivity;
	private Boolean counterTimeBetweenReplikHaveStillRun;
	private Boolean counterTimeBetweenGameHaveStillRun;
	
	
	  public RebourdClassement(ClassementActivity classementAcivity, long millisInFuture, long countDownInterval, Boolean  counterTimeBetweenReplikHaveStillRun, Boolean counterTimeBetweenGameHaveStillRun) {
		  
		  
		  super(millisInFuture, countDownInterval);
		  
		  this.classementAcivity = classementAcivity;
          this.countDownInterval = countDownInterval;
          this.millisInFuture = millisInFuture;
          this.counterTimeBetweenReplikHaveStillRun = counterTimeBetweenReplikHaveStillRun;
          this.counterTimeBetweenGameHaveStillRun = counterTimeBetweenGameHaveStillRun;
          
           
          
     }

	
	@Override
	public void onFinish() {
		
		
		this.classementAcivity.getTvRebourd().setText("0 Sec");
		if(this.classementAcivity.getCurrentReplikNo().intValue() + 1 <= this.classementAcivity.getNbReplik().intValue()){
			this.classementAcivity.getBoutonJouer().setEnabled(true);
			this.classementAcivity.getBoutonJouer().setText(R.string.jouer);
			this.classementAcivity.setCurrentReplikNo(this.classementAcivity.getCurrentReplikNo() + 1);	
			this.classementAcivity.getTvNumeroReplik().setText(String.valueOf(this.classementAcivity.getCurrentReplikNo()));					

			if(!this.counterTimeBetweenReplikHaveStillRun){
				this.counterTimeBetweenReplikHaveStillRun = true;
				RebourdClassement rebourd = new RebourdClassement(this.classementAcivity,this.classementAcivity.getSecondeParReplik(), this.countDownInterval, this.counterTimeBetweenReplikHaveStillRun, this.counterTimeBetweenGameHaveStillRun);
				this.classementAcivity.setCounterTimeCompletReplikLeft(rebourd);
				this.classementAcivity.getCounterTimeCompletReplikLeft().start();
				
			}else{
				this.classementAcivity.getCounterTimeCompletReplikLeft().start();
			}
		}else{
			
			this.classementAcivity.getTvNumeroReplik().setText(R.string.zero);
			this.classementAcivity.setCurrentReplikNo(Integer.valueOf(0));			
			this.classementAcivity.getBoutonJouer().setEnabled(false);
			
			if(!this.counterTimeBetweenGameHaveStillRun){
				this.counterTimeBetweenGameHaveStillRun = true;
				RebourdClassement rebourd = new RebourdClassement(this.classementAcivity,this.classementAcivity.getSecondeEntreManche(), this.countDownInterval, this.counterTimeBetweenReplikHaveStillRun, this.counterTimeBetweenGameHaveStillRun);
				this.classementAcivity.setCounterTimeBetweenGameLeft(rebourd);
				this.classementAcivity.getCounterTimeBetweenGameLeft().start();							
			}else{
				this.classementAcivity.getCounterTimeBetweenGameLeft().start();
			}
			
		}

		
		
		//UpdaterUI.classement(this.rebourdClassementInputParameter.getClassementActivity());
		/*ValidateUserBean user = new ValidateUserBean();
		user.setPseudo(this.rebourdClassementInputParameter.getClassementActivity().getPseudo());
		user.setSecurityString(this.rebourdClassementInputParameter.getClassementActivity().getSecurityString());
		ClassementBean classement = CommonCallWs.callClassementWs(user);
		
		if(classement.getCodeRetour().equals(ConstantsError.OK_CODE)){
			
			this.rebourdClassementInputParameter.getClassementActivity().getTvNombrejoueurs().setText("Joueurs : " + classement.getNbJoueurs());
			UsersArrayAdapter userAdapter = new UsersArrayAdapter(this.rebourdClassementInputParameter.getClassementActivity(), classement.getListeUser());
			this.rebourdClassementInputParameter.getClassementActivity().getListUser().setAdapter(userAdapter);
			
			if(classement.getGameReady().equals(Constants.TRUE)){
				this.rebourdClassementInputParameter.getClassementActivity().getTvNumeroReplik().setText(classement.getCurrentReplik() + "/" + classement.getTotalReplik());
				RebourdClassement counter = new RebourdClassement(rebourdClassementInputParameter,Long.valueOf(classement.getSecondParReplik()) * Constants.SECOND, this.countDownInterval);
			    counter.start();
			}else{			
				this.rebourdClassementInputParameter.getClassementActivity().getTvNumeroReplik().setText("-");
				RebourdClassement counter = new RebourdClassement(rebourdClassementInputParameter,Long.valueOf(classement.getTempsRestantAvantDebutManche()), this.countDownInterval);
			    counter.start();
			}
		}else{
			//Toast toast = Toast.makeText(this.rebourdClassementInputParameter.getClassementActivity(), R.string.errorClassement, Constants.TOAST_DURATION);
			//toast.show();
		}*/
		
	}

	@Override
	public void onTick(long millisUntilFinished) {
		this.classementAcivity.getTvRebourd().setText(millisUntilFinished / Constants.SECOND + " Sec");
		if(!this.classementAcivity.getBoutonJouer().isEnabled()){
			this.classementAcivity.getBoutonJouer().setText("Nouvelle manche dans "+ String.valueOf(millisUntilFinished / Constants.SECOND)+" sec");
		}
	}

}
