package org.infospray.android.replik;

import java.util.ArrayList;
import java.util.List;

import org.infospray.android.replik.listener.AnswerListenerInputParameter;
import org.infospray.android.replik.listener.ButtonClickAnswerListener;
import org.infospray.android.replik.rebourd.RebourdGameInputParameter;
import org.infospray.android.replik.ui.ButtonAnswerTagParam;
import org.infospray.android.replik.ui.UpdaterUI;
import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.ws.beans.Replik;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

public class GameActivity extends Activity {
	
	private 	boolean firstRun = true;
	private		String pseudo;
	private		String securityString;
	private 	List<Button> listBoutonProposition = new ArrayList<Button>();
	private		TextView tvReplik;
	private		TextView textnomSection;
	private		TextView tvNumeroReplik;
	private		TextView tvNbTotalReplik;
	private		TextView tvClassementGeneral;
	private		TextView tvNombreTotalJoueurs;
	private		TextView tvNombreTotalPoints;
	private		TextView tvCompteur;
	private		RebourdGameInputParameter rebourdInputParameter =  new RebourdGameInputParameter();
	private		long buttonBuildTime;
	private		TextView tvClassementReplik;
	private		TextView tvPointsReplik;
	private		ImageView imgMedailleReplik;
	private		ImageView imgPodiumReplik;
	private		TextView tvLblPtsReplik;
	private		TextView tvLblGameReplik;
	private		Button	boutonProposition1;
	private		Button	boutonProposition2;
	private		Button	boutonProposition3;
	private		Button	boutonProposition4;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_game);
		
		Intent intent = getIntent();                
		if (intent != null) {
			this.pseudo =  intent.getStringExtra(Constants.PSEUDO);
			this.securityString =  intent.getStringExtra(Constants.SECURITY_STRING);	

			this.textnomSection = (TextView) findViewById(R.id.topnomsection);
			this.tvReplik = (TextView) findViewById(R.id.textViewReplik);
			this.tvNumeroReplik = (TextView) findViewById(R.id.textNumeroReplik);
			this.tvNbTotalReplik = (TextView) findViewById(R.id.textTotalReplik);
			this.tvClassementGeneral = (TextView) findViewById(R.id.textClassementGen);
			this.tvNombreTotalJoueurs = (TextView) findViewById(R.id.textTotaNbJoueurs);
			this.tvNombreTotalPoints =  (TextView) findViewById(R.id.textTTPoints);
			this.imgPodiumReplik =  (ImageView)findViewById(R.id.imagePodiumReplik);
			this.imgMedailleReplik =  (ImageView)findViewById(R.id.imageMedaille);
			this.tvClassementReplik = (TextView) findViewById(R.id.textClassementReplik);
			this.tvPointsReplik = (TextView) findViewById(R.id.textPtsReplik);
			this.tvLblPtsReplik = (TextView) findViewById(R.id.textLblPtsReplik);
			this.tvLblGameReplik = (TextView) findViewById(R.id.textLibelleGame);
			this.tvCompteur = (TextView)findViewById(R.id.textrebourdgame);
			this.boutonProposition1 = (Button)findViewById(R.id.buttonPropo1);
			this.boutonProposition2 = (Button)findViewById(R.id.buttonPropo2);
			this.boutonProposition3 = (Button)findViewById(R.id.buttonPropo3);
			this.boutonProposition4 = (Button)findViewById(R.id.buttonPropo4);

			this.textnomSection.setText("Trouvez le bon film ...");
			UpdaterUI.game(this);
		}
		
	}
	
	


	
	@Override
	protected void onResume() {
		super.onResume();
		if(!this.firstRun){			
			Intent intent = getIntent();                
			if (intent != null) {
				UpdaterUI.game(this);
			}
		}
		this.firstRun = false;
	}





	public View buildBoutonProposition(Replik currentReplik, int idxNumeroReplik, View button){
			
		((Button)button).setText(currentReplik.getPropositions().get(idxNumeroReplik).getLblProposition());
		ButtonAnswerTagParam btTag = new ButtonAnswerTagParam();
		btTag.setIdProposition(Integer.valueOf(currentReplik.getPropositions().get(idxNumeroReplik).getIdPropostion()));
		btTag.setIdAnwser(Integer.valueOf(currentReplik.getReplikId()));
		btTag.setTempsConstruction(this.buttonBuildTime);
		((Button)button).setTag(btTag);
		
		return button;
	}
	
	
	public void buildBoutonPropositionListenner(Button button, int numeroButton){
		
		ButtonClickAnswerListener listenerAnswer = new ButtonClickAnswerListener(this, numeroButton);
		button.setOnClickListener(listenerAnswer);
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}




	public boolean isFirstRun() {
		return firstRun;
	}




	public void setFirstRun(boolean firstRun) {
		this.firstRun = firstRun;
	}




	public String getPseudo() {
		return pseudo;
	}




	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}




	public String getSecurityString() {
		return securityString;
	}




	public void setSecurityString(String securityString) {
		this.securityString = securityString;
	}




	public List<Button> getListBoutonProposition() {
		return listBoutonProposition;
	}




	public void setListBoutonProposition(List<Button> listBoutonProposition) {
		this.listBoutonProposition = listBoutonProposition;
	}




	public TextView getTvReplik() {
		return tvReplik;
	}




	public void setTvReplik(TextView tvReplik) {
		this.tvReplik = tvReplik;
	}




	public TextView getTextnomSection() {
		return textnomSection;
	}




	public void setTextnomSection(TextView textnomSection) {
		this.textnomSection = textnomSection;
	}




	public TextView getTvNumeroReplik() {
		return tvNumeroReplik;
	}




	public void setTvNumeroReplik(TextView tvNumeroReplik) {
		this.tvNumeroReplik = tvNumeroReplik;
	}




	public TextView getTvNbTotalReplik() {
		return tvNbTotalReplik;
	}




	public void setTvNbTotalReplik(TextView tvNbTotalReplik) {
		this.tvNbTotalReplik = tvNbTotalReplik;
	}




	public TextView getTvClassementGeneral() {
		return tvClassementGeneral;
	}




	public void setTvClassementGeneral(TextView tvClassementGeneral) {
		this.tvClassementGeneral = tvClassementGeneral;
	}




	public TextView getTvNombreTotalJoueurs() {
		return tvNombreTotalJoueurs;
	}




	public void setTvNombreTotalJoueurs(TextView tvNombreTotalJoueurs) {
		this.tvNombreTotalJoueurs = tvNombreTotalJoueurs;
	}




	public TextView getTvNombreTotalPoints() {
		return tvNombreTotalPoints;
	}




	public void setTvNombreTotalPoints(TextView tvNombreTotalPoints) {
		this.tvNombreTotalPoints = tvNombreTotalPoints;
	}




	public TextView getTvCompteur() {
		return tvCompteur;
	}




	public void setTvCompteur(TextView tvCompteur) {
		this.tvCompteur = tvCompteur;
	}




	public RebourdGameInputParameter getRebourdInputParameter() {
		return rebourdInputParameter;
	}




	public void setRebourdInputParameter(
			RebourdGameInputParameter rebourdInputParameter) {
		this.rebourdInputParameter = rebourdInputParameter;
	}




	public long getButtonBuildTime() {
		return buttonBuildTime;
	}




	public void setButtonBuildTime(long buttonBuildTime) {
		this.buttonBuildTime = buttonBuildTime;
	}




	public TextView getTvClassementReplik() {
		return tvClassementReplik;
	}




	public void setTvClassementReplik(TextView tvClassementReplik) {
		this.tvClassementReplik = tvClassementReplik;
	}




	public TextView getTvPointsReplik() {
		return tvPointsReplik;
	}




	public void setTvPointsReplik(TextView tvPointsReplik) {
		this.tvPointsReplik = tvPointsReplik;
	}




	public ImageView getImgMedailleReplik() {
		return imgMedailleReplik;
	}




	public void setImgMedailleReplik(ImageView imgMedailleReplik) {
		this.imgMedailleReplik = imgMedailleReplik;
	}




	public ImageView getImgPodiumReplik() {
		return imgPodiumReplik;
	}




	public void setImgPodiumReplik(ImageView imgPodiumReplik) {
		this.imgPodiumReplik = imgPodiumReplik;
	}




	public TextView getTvLblPtsReplik() {
		return tvLblPtsReplik;
	}




	public void setTvLblPtsReplik(TextView tvLblPtsReplik) {
		this.tvLblPtsReplik = tvLblPtsReplik;
	}




	public TextView getTvLblGameReplik() {
		return tvLblGameReplik;
	}




	public void setTvLblGameReplik(TextView tvLblGameReplik) {
		this.tvLblGameReplik = tvLblGameReplik;
	}




	public Button getBoutonProposition1() {
		return boutonProposition1;
	}




	public void setBoutonProposition1(Button boutonProposition1) {
		this.boutonProposition1 = boutonProposition1;
	}




	public Button getBoutonProposition2() {
		return boutonProposition2;
	}




	public void setBoutonProposition2(Button boutonProposition2) {
		this.boutonProposition2 = boutonProposition2;
	}




	public Button getBoutonProposition3() {
		return boutonProposition3;
	}




	public void setBoutonProposition3(Button boutonProposition3) {
		this.boutonProposition3 = boutonProposition3;
	}




	public Button getBoutonProposition4() {
		return boutonProposition4;
	}




	public void setBoutonProposition4(Button boutonProposition4) {
		this.boutonProposition4 = boutonProposition4;
	}
	
	
	

}
