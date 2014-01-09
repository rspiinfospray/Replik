package org.infospray.android.replik.ui;


import java.util.List;

import org.infospray.android.replik.GameActivity;
import org.infospray.android.replik.R;
import org.infospray.android.replik.rebourd.RebourdGame;
import org.infospray.android.replik.rebourd.RebourdGameInputParameter;
import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.ws.beans.ConstantsError;
import org.infospray.android.replik.ws.beans.PlayBean;
import org.infospray.android.replik.ws.beans.Replik;
import org.infospray.android.replik.ws.beans.ValidateUserBean;
import org.infospray.android.replik.ws.call.CommonCallWs;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class GameAsyncUI extends AsyncTask<ValidateUserBean, Integer, PlayBean> {


	private GameActivity		activity;
	private ProgressDialog		pd;
	
	
	
	
	public GameAsyncUI(GameActivity activity) {
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
	protected void onPostExecute(PlayBean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		this.pd.dismiss();

		if(result!= null && result.getCodeRetour().equals(ConstantsError.OK_CODE)){
			if(result.getGameReady().equals(Constants.TRUE)){

				Replik currentReplik = null;
				List<Replik> listReplik = result.getReplik();
				for (Replik replik : listReplik) {
					if(replik.getReplikIdInList().equals(result.getCurrentReplikId())){
						currentReplik = replik;
					}
				}

				this.activity.getTvReplik().setText("\".. "+currentReplik.getReplikLbl()+" ..\"");
				this.activity.getTvNumeroReplik().setText(result.getCurrentReplikId());
				this.activity.getTvNbTotalReplik().setText(result.getNbTotalReplik());
				this.activity.getTvClassementGeneral().setText(result.getClassementGeneral());
				this.activity.getTvNombreTotalJoueurs().setText(result.getNbJoueurs());
				this.activity.getTvNombreTotalPoints().setText(result.getPoints());



				this.activity.getListBoutonProposition().clear();
				this.activity.getListBoutonProposition().add((Button)this.activity.buildBoutonProposition(currentReplik, 0, this.activity.getBoutonProposition1()));
				this.activity.getListBoutonProposition().add((Button)this.activity.buildBoutonProposition(currentReplik, 1,  this.activity.getBoutonProposition2()));
				this.activity.getListBoutonProposition().add((Button)this.activity.buildBoutonProposition(currentReplik, 2,  this.activity.getBoutonProposition3()));
				this.activity.getListBoutonProposition().add((Button)this.activity.buildBoutonProposition(currentReplik, 3, this.activity.getBoutonProposition4()));

				int i = 0;
				for (Button currentButton : this.activity.getListBoutonProposition()) {
					this.activity.buildBoutonPropositionListenner(currentButton, i);
					currentButton.setBackgroundDrawable(this.activity.getResources().getDrawable(R.drawable.boutonnoir));	
					currentButton.setVisibility(View.VISIBLE);				
					currentButton.setClickable(true);
					i++;
				}


				long tempsattente = Long.valueOf(result.getTempsRestantPourReplik());

				RebourdGameInputParameter rebourdInputParameter =  new RebourdGameInputParameter();
				rebourdInputParameter.setMillisInFuture(tempsattente);
				rebourdInputParameter.setCountDownInterval(Constants.SECOND);
				rebourdInputParameter.setPlay(result);
				rebourdInputParameter.setCurrentCpt(0);
				rebourdInputParameter.setActivityInstance(this.activity);


				RebourdGame counter = new RebourdGame(rebourdInputParameter);
				counter.start();

			}else{
				this.activity.finish();
			}
		}else{
			Toast toast = Toast.makeText(this.activity, R.string.errorJouer, Constants.TOAST_DURATION);
			toast.show();
			this.activity.finish();

		}
	}


	


	@Override
	protected PlayBean doInBackground(ValidateUserBean... params) {

		return CommonCallWs.callPlayWs(params[0]);
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(GameActivity activity) {
		this.activity = activity;
	}
	
	
	
}
