package org.infospray.android.replik.rebourd;


import org.infospray.android.replik.R;
import org.infospray.android.replik.ui.ButtonAnswerTagParam;
import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.ws.beans.Replik;
import android.os.CountDownTimer;
import android.view.View;



public class RebourdGame extends CountDownTimer {

	private RebourdGameInputParameter rebourdInputParameter;



	public RebourdGame(RebourdGameInputParameter rebourdInputParameter) {

		super(rebourdInputParameter.getMillisInFuture(),rebourdInputParameter.getCountDownInterval());
		this.rebourdInputParameter = rebourdInputParameter;

	}

	@Override
	public void onFinish() {
		this.rebourdInputParameter.setCurrentCpt(this.rebourdInputParameter.getCurrentCpt()+1);
		int currentIdReplik = Integer.valueOf(this.rebourdInputParameter.getPlay().getCurrentReplikId()) + this.rebourdInputParameter.getCurrentCpt();
		
		
		this.rebourdInputParameter.getActivityInstance().getImgMedailleReplik().setVisibility(View.GONE);
		this.rebourdInputParameter.getActivityInstance().getImgPodiumReplik().setVisibility(View.GONE);
		this.rebourdInputParameter.getActivityInstance().getTvLblGameReplik().setVisibility(View.GONE);
		this.rebourdInputParameter.getActivityInstance().getTvLblPtsReplik().setVisibility(View.GONE);
		this.rebourdInputParameter.getActivityInstance().getTvPointsReplik().setVisibility(View.GONE);
		this.rebourdInputParameter.getActivityInstance().getTvClassementReplik().setVisibility(View.GONE);
		
		
		boolean found = false;
		for (Replik currentReplik : this.rebourdInputParameter.getPlay().getReplik()) {
			String currentIdString = String.valueOf(currentIdReplik);
			if(currentReplik.getReplikIdInList().equals(currentIdString)){
				
				// initialisation du text de la replik
				this.rebourdInputParameter.getActivityInstance().getTvReplik().setText("\".. "+currentReplik.getReplikLbl()+" ..\"");
				
				for(int i = 0; i != this.rebourdInputParameter.getPlay().getReplik().get(0).getPropositions().size(); i++){
					buildButton(currentReplik, i);
				}
				
				//this.rebourdInputParameter.setButtonBuildTime(System.currentTimeMillis());
				
				found = true;
				break;
			}
			
		}
		if(found){
			this.rebourdInputParameter.getActivityInstance().getTvNumeroReplik().setText(String.valueOf(currentIdReplik));
			long tempsattente = Long.valueOf(this.rebourdInputParameter.getPlay().getSecondParReplik()) * 1000l;
			this.rebourdInputParameter.setMillisInFuture(tempsattente);
			RebourdGame rebourd = new RebourdGame(this.rebourdInputParameter);
			rebourd.start();
		}else{
			
			this.rebourdInputParameter.getActivityInstance().finish();
			
			/*Intent intent = new Intent(this.rebourdInputParameter.getActivityInstance(), LoadGameActivity.class);
			intent.putExtra(Constants.TEMPS_ATTENTE,String.valueOf(Long.valueOf(this.rebourdInputParameter.getPlay().getSecondEntreManche()) * 1000));	
			intent.putExtra(Constants.PSEUDO,this.rebourdInputParameter.getActivityInstance().getPseudo());
			intent.putExtra(Constants.SECURITY_STRING,this.rebourdInputParameter.getActivityInstance().getSecurityString());
			intent.putExtra(Constants.NUMERO_REPLIK,this.rebourdInputParameter.getActivityInstance().getTvNumeroReplik().getText());
			intent.putExtra(Constants.NOMBRE_REPLIK,this.rebourdInputParameter.getPlay().getNbTotalReplik());
			intent.putExtra(Constants.CLASSEMENT_GENERAL,this.rebourdInputParameter.getPlay().getClassementGeneral());
			intent.putExtra(Constants.TOTAL_NB_JOUEURS,this.rebourdInputParameter.getActivityInstance().getTvNombreTotalJoueurs().getText());
			intent.putExtra(Constants.TOTAL_POINTS,this.rebourdInputParameter.getActivityInstance().getTvNombreTotalPoints().getText());
			this.rebourdInputParameter.getActivityInstance().startActivity(intent);*/

		}


	}

	@Override
	public void onTick(long millisUntilFinished) {
		this.rebourdInputParameter.getActivityInstance().getTvCompteur().setText(millisUntilFinished / Constants.SECOND + " Sec");
	}
	
	
	private void buildButton(Replik currentReplik, int idx){
		this.rebourdInputParameter.getActivityInstance().getListBoutonProposition().get(idx).setVisibility(View.VISIBLE);
		this.rebourdInputParameter.getActivityInstance().getListBoutonProposition().get(idx).setText(currentReplik.getPropositions().get(idx).getLblProposition());
		this.rebourdInputParameter.getActivityInstance().getListBoutonProposition().get(idx).setBackgroundDrawable(this.rebourdInputParameter.getActivityInstance().getListBoutonProposition().get(idx).getContext().getResources().getDrawable(R.drawable.boutonnoir));
		this.rebourdInputParameter.getActivityInstance().getListBoutonProposition().get(idx).setClickable(true);
		ButtonAnswerTagParam btTag = new ButtonAnswerTagParam();
		btTag.setIdProposition(Integer.valueOf(currentReplik.getPropositions().get(idx).getIdPropostion()));
		btTag.setIdAnwser(Integer.valueOf(currentReplik.getReplikId()));
		this.rebourdInputParameter.getActivityInstance().getListBoutonProposition().get(idx).setTag(btTag);
	}

}
