package org.infospray.android.replik;

import org.infospray.android.replik.listener.ButtonClickGoListener;
import org.infospray.android.replik.utils.Constants;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;



public class LoginActivity extends Activity {

	private ImageButton 				boutonGo;
	private	EditText 					edPseudo;
	private	ProgressBar 				progressBar;
	private String 						pseudo;
	private String 						securityString;
	private SharedPreferences.Editor 	editor;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		this.boutonGo = (ImageButton)findViewById(R.id.imageGo);
		this.edPseudo = (EditText)findViewById(R.id.editPseudo);		
		this.progressBar = (ProgressBar)findViewById(R.id.progressBarLogin);
		
		this.progressBar.setVisibility(View.GONE);
		this.progressBar.setIndeterminate(true);
		this.progressBar.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);
		
		// chargement du pseudo stocker dans le sytem archive android
		SharedPreferences settings = getSharedPreferences(Constants.REPLIK_USER_FILE,0);
		String pseudoStockInData = settings.getString(Constants.PSEUDO, "");
		this.editor = settings.edit();
		if(!pseudoStockInData.equals("")){
			this.edPseudo.setText(pseudoStockInData);
			this.pseudo = pseudoStockInData;
		}
		
		ButtonClickGoListener btListenner = new ButtonClickGoListener(LoginActivity.this);
		this.boutonGo.setOnClickListener(btListenner);

	}

	public ImageButton getBoutonGo() {
		return boutonGo;
	}

	public void setBoutonGo(ImageButton boutonGo) {
		this.boutonGo = boutonGo;
	}

	public EditText getEdPseudo() {
		return edPseudo;
	}

	public void setEdPseudo(EditText edPseudo) {
		this.edPseudo = edPseudo;
	}

	public ProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(ProgressBar progressBar) {
		this.progressBar = progressBar;
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

	public SharedPreferences.Editor getEditor() {
		return editor;
	}

	public void setEditor(SharedPreferences.Editor editor) {
		this.editor = editor;
	}

	
	
	

}
