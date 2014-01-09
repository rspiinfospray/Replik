package org.infospray.android.replik;


import org.infospray.android.replik.listener.ButtonClickRefreshClassementListener;
import org.infospray.android.replik.rebourd.RebourdClassement;
import org.infospray.android.replik.ui.UpdaterUI;
import org.infospray.android.replik.utils.Constants;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

public class ClassementActivity extends Activity {

	
	private ListView 			listUser;
	private String	 			pseudo;
	private String				securityString;
	private TextView 			tvNombrejoueurs;
	private TextView			tvNumeroReplik;
	private TextView 			tvRebourd;
	private TextView			tvNomSection;
	private TextView			tvNombreReplik;
	private	Button				boutonJouer;
	private long				secondeEntreManche;
	private long				secondeParReplik;
	private Integer				currentReplikNo;
	private Integer				nbReplik;
	private boolean				firstRun = true;
	private	RebourdClassement 	counterTimeLeft;
	private	RebourdClassement 	counterTimeBetweenGameLeft;
	private	RebourdClassement 	counterTimeCompletReplikLeft;
	private ImageButton			boutonRefresh;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classement);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		this.tvNomSection = (TextView)findViewById(R.id.topnomsection);
		this.listUser =  (ListView)findViewById(R.id.listUsers);
		this.tvNombrejoueurs = (TextView)findViewById(R.id.tvNbJoursLbl);
		this.tvNumeroReplik = (TextView)findViewById(R.id.tvNumeroReplikLbl);
		this.tvNombreReplik = (TextView)findViewById(R.id.tvNombreReplik);
		this.boutonJouer = (Button)findViewById(R.id.buttonjouer);
		this.tvRebourd = (TextView)findViewById(R.id.tvCompeurSecondeLbl);
		this.boutonRefresh = (ImageButton)findViewById(R.id.imageRefresh);
		
		this.boutonRefresh.setVisibility(View.VISIBLE);
		this.boutonRefresh.setBackgroundDrawable(null);
		this.boutonRefresh.setOnClickListener(new ButtonClickRefreshClassementListener(this));

		Intent intent = getIntent();                
		if (intent != null) {

			tvNomSection.setText(R.string.classement);
			this.pseudo =  intent.getStringExtra(Constants.PSEUDO);
			this.securityString =  intent.getStringExtra(Constants.SECURITY_STRING);
			UpdaterUI.classement(this);
		}	
	}
	
	

	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		if(!this.firstRun){		
			Intent intent = getIntent();                
			if (intent != null) {
				if(this.getCounterTimeBetweenGameLeft() != null){
					this.getCounterTimeBetweenGameLeft().cancel();
				}
				
				if(this.getCounterTimeCompletReplikLeft() != null){
					this.getCounterTimeCompletReplikLeft().cancel();
				}

				if(this.getCounterTimeLeft() != null){
					this.getCounterTimeLeft().cancel();
				}
				UpdaterUI.classement(this);
			}
		}
		this.firstRun = false;
	}



	public ListView getListUser() {
		return listUser;
	}



	public void setListUser(ListView listUser) {
		this.listUser = listUser;
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




	public TextView getTvNombrejoueurs() {
		return tvNombrejoueurs;
	}




	public void setTvNombrejoueurs(TextView tvNombrejoueurs) {
		this.tvNombrejoueurs = tvNombrejoueurs;
	}




	public TextView getTvNumeroReplik() {
		return tvNumeroReplik;
	}




	public void setTvNumeroReplik(TextView tvNumeroReplik) {
		this.tvNumeroReplik = tvNumeroReplik;
	}




	public TextView getTvRebourd() {
		return tvRebourd;
	}




	public void setTvRebourd(TextView tvRebourd) {
		this.tvRebourd = tvRebourd;
	}




	public TextView getTvNomSection() {
		return tvNomSection;
	}




	public void setTvNomSection(TextView tvNomSection) {
		this.tvNomSection = tvNomSection;
	}




	public Button getBoutonJouer() {
		return boutonJouer;
	}




	public void setBoutonJouer(Button boutonJouer) {
		this.boutonJouer = boutonJouer;
	}





	public long getSecondeEntreManche() {
		return secondeEntreManche;
	}





	public void setSecondeEntreManche(long secondeEntreManche) {
		this.secondeEntreManche = secondeEntreManche;
	}





	public long getSecondeParReplik() {
		return secondeParReplik;
	}





	public void setSecondeParReplik(long secondeParReplik) {
		this.secondeParReplik = secondeParReplik;
	}





	public Integer getNbReplik() {
		return nbReplik;
	}





	public void setNbReplik(Integer nbReplik) {
		this.nbReplik = nbReplik;
	}





	public ImageButton getBoutonRefresh() {
		return boutonRefresh;
	}





	public void setBoutonRefresh(ImageButton boutonRefresh) {
		this.boutonRefresh = boutonRefresh;
	}





	public Integer getCurrentReplikNo() {
		return currentReplikNo;
	}





	public void setCurrentReplikNo(Integer currentReplikNo) {
		this.currentReplikNo = currentReplikNo;
	}



	public RebourdClassement getCounterTimeLeft() {
		return counterTimeLeft;
	}





	public void setCounterTimeLeft(RebourdClassement counterTimeLeft) {
		this.counterTimeLeft = counterTimeLeft;
	}





	public RebourdClassement getCounterTimeBetweenGameLeft() {
		return counterTimeBetweenGameLeft;
	}





	public void setCounterTimeBetweenGameLeft(
			RebourdClassement counterTimeBetweenGameLeft) {
		this.counterTimeBetweenGameLeft = counterTimeBetweenGameLeft;
	}





	public RebourdClassement getCounterTimeCompletReplikLeft() {
		return counterTimeCompletReplikLeft;
	}





	public void setCounterTimeCompletReplikLeft(
			RebourdClassement counterTimeCompletReplikLeft) {
		this.counterTimeCompletReplikLeft = counterTimeCompletReplikLeft;
	}





	public TextView getTvNombreReplik() {
		return tvNombreReplik;
	}





	public void setTvNombreReplik(TextView tvNombreReplik) {
		this.tvNombreReplik = tvNombreReplik;
	}


	



	
	

}
