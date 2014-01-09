package org.infospray.android.replik.listener;


import org.infospray.android.replik.GameActivity;
import org.infospray.android.replik.R;
import org.infospray.android.replik.ui.ButtonAnswerTagParam;
import org.infospray.android.replik.ui.UpdaterUI;
import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.utils.PseudoCredentials;
import org.infospray.android.replik.ws.ValidateAnswerInputParameter;
import org.infospray.android.replik.ws.beans.AnswerBean;
import org.infospray.android.replik.ws.beans.ConstantsError;
import org.infospray.android.replik.ws.call.CommonCallWs;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ButtonClickAnswerListener implements OnClickListener {

	/*private static String FIRST_POS = "1";
	
	private static String SECOND_POS = "2";
	
	private static String THIRD_POS = "3";*/
	
	//private AnswerListenerInputParameter inputParam;

	private GameActivity activity;
	private int boutonToIgnore;
	
	public ButtonClickAnswerListener(GameActivity activity, int boutonToIgnore) {
		this.activity = activity;
		this.boutonToIgnore = boutonToIgnore;
	}

	@Override
	public void onClick(View v) {

		long clickUserTime = System.currentTimeMillis();
		Button button  = (Button)v;
		ButtonAnswerTagParam answerTag = (ButtonAnswerTagParam)button.getTag();
		Integer idReplikGoodAnswer =  answerTag.getIdAnwser();
		Integer idReplikAnswer =  answerTag.getIdProposition();
		long constructionTime = answerTag.getTempsConstruction();
		
		// on rend inactive les bouton apres avoir donnée la réponse.
		// on cache les mauvaises réponse sauf eventuellement celle que l on a donnée de fausse.
		boolean goodAnswer =  false;
		for (Button currentButton : this.activity.getListBoutonProposition()) {
			currentButton.setClickable(false);
			if(currentButton.equals(button)){
				if(idReplikGoodAnswer.equals(idReplikAnswer)){
					button.setBackgroundDrawable(v.getContext().getResources().getDrawable(R.drawable.boutonvert));
					goodAnswer = true;
					this.activity.getTvLblGameReplik().setVisibility(View.VISIBLE);
					this.activity.getTvLblGameReplik().setText(R.string.bonneReponse);
					this.activity.getTvLblGameReplik().setShadowLayer(2.5f, 1f, 1f, v.getContext().getResources().getColor(R.color.vertbouton));
					this.activity.getTvPointsReplik().setText("10");
				
				}else{
					button.setBackgroundDrawable(v.getContext().getResources().getDrawable(R.drawable.boutonrouge));
					this.activity.getTvLblGameReplik().setVisibility(View.VISIBLE);
					this.activity.getTvLblGameReplik().setText(R.string.mauvaiseReponse);
					this.activity.getTvLblGameReplik().setShadowLayer(2.5f, 1f, 1f, v.getContext().getResources().getColor(R.color.rougebouton));
					this.activity.getTvPointsReplik().setText("0");
				}
			}
			else{
				ButtonAnswerTagParam currentAnswerTag = (ButtonAnswerTagParam)currentButton.getTag();
				Integer currentidReplikGoodAnswer =  currentAnswerTag.getIdAnwser();
				Integer currentidReplikAnswer =  currentAnswerTag.getIdProposition();
				if(currentidReplikGoodAnswer.equals(currentidReplikAnswer)){
					currentButton.setBackgroundDrawable(v.getContext().getResources().getDrawable(R.drawable.boutonvert));					
				}else{
					currentButton.setVisibility(View.GONE);
				}
			}

		}
		
		this.activity.getTvPointsReplik().setVisibility(View.VISIBLE);
		this.activity.getTvLblPtsReplik().setVisibility(View.VISIBLE);
		if(goodAnswer){
			this.activity.getTvPointsReplik().setShadowLayer(2.5f, 1f, 1f, v.getContext().getResources().getColor(R.color.vertbouton));
			this.activity.getTvLblPtsReplik().setShadowLayer(2.5f, 1f, 1f, v.getContext().getResources().getColor(R.color.vertbouton));
		}else{
			this.activity.getTvPointsReplik().setShadowLayer(2.5f, 1f, 1f, v.getContext().getResources().getColor(R.color.rougebouton));
			this.activity.getTvLblPtsReplik().setShadowLayer(2.5f, 1f, 1f, v.getContext().getResources().getColor(R.color.rougebouton));
		}
		
		// appel au webservice
		ValidateAnswerInputParameter inputParam = new ValidateAnswerInputParameter();
		inputParam.setGoodAnswer(goodAnswer);
		PseudoCredentials pseudoCrendetials = new PseudoCredentials();
		pseudoCrendetials.setPseudo(this.activity.getPseudo());
		pseudoCrendetials.setSecurityString(this.activity.getSecurityString());
		inputParam.setPseudoCredentials(pseudoCrendetials);
		inputParam.setCurrentReplikid(Integer.valueOf(this.activity.getTvNumeroReplik().getText().toString()));	
		inputParam.setTempsReaction(clickUserTime - constructionTime);
		UpdaterUI.gameValidateAnswer(inputParam , this.activity);
		//CommonCallWs.callAnswerWs(inputParam, false);		
		/*if(answerBean.getCodeRetour().equals(ConstantsError.OK_CODE)){
		
		
			//this.inputParam.getTextClassementGeneral().setText(answerBean.getClassementGeneral());
			//this.inputParam.getTextPoints().setText(answerBean.getPoints());
			
			//this.inputParam.getTvNbJoueurs().setText(answerBean.getNbJoueurs());
			
		}else{
			Toast toast = Toast.makeText(this.inputParam.getTextClassementReplik().getContext(), R.string.errorStatsPoints, Constants.TOAST_DURATION);
			toast.show();
		}*/

		
	}
	
	


}
