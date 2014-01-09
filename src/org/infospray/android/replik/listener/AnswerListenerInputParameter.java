package org.infospray.android.replik.listener;


import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnswerListenerInputParameter {

	private TextView textClassementGeneral;
	
	private TextView textClassementReplik;
	
	private TextView textPoints;
	
	private TextView textPointsReplik;
	
	private TextView textNumeroReplik;
	
	private List<Button> listButtonProposition = new ArrayList<Button>();
	
	private Integer ignoreButtonIdx;
	
	private String pseudo;
	
	private String securityString;
	
	private ImageView imgPodiumReplik;
	
	private ImageView imgMedailleReplik;
	
	private TextView tvLblPtsReplik;
	
	private TextView tvLblGameReplik;
	
	private TextView tvNbJoueurs;
	
	

	public Integer getIgnoreButtonIdx() {
		return ignoreButtonIdx;
	}

	public void setIgnoreButtonIdx(Integer ignoreButtonIdx) {
		this.ignoreButtonIdx = ignoreButtonIdx;
	}

	public List<Button> getListButtonProposition() {
		return listButtonProposition;
	}

	public void setListButtonProposition(List<Button> listButtonProposition) {
		this.listButtonProposition = listButtonProposition;
	}

	public TextView getTextClassementGeneral() {
		return textClassementGeneral;
	}

	public void setTextClassementGeneral(TextView textClassementGeneral) {
		this.textClassementGeneral = textClassementGeneral;
	}

	public TextView getTextClassementReplik() {
		return textClassementReplik;
	}

	public void setTextClassementReplik(TextView textClassementReplik) {
		this.textClassementReplik = textClassementReplik;
	}

	public TextView getTextPoints() {
		return textPoints;
	}

	public void setTextPoints(TextView textPoints) {
		this.textPoints = textPoints;
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


	public TextView getTextNumeroReplik() {
		return textNumeroReplik;
	}

	public void setTextNumeroReplik(TextView textNumeroReplik) {
		this.textNumeroReplik = textNumeroReplik;
	}

	public TextView getTextPointsReplik() {
		return textPointsReplik;
	}

	public void setTextPointsReplik(TextView textPointsReplik) {
		this.textPointsReplik = textPointsReplik;
	}

	public ImageView getImgPodiumReplik() {
		return imgPodiumReplik;
	}

	public void setImgPodiumReplik(ImageView imgPodiumReplik) {
		this.imgPodiumReplik = imgPodiumReplik;
	}

	public ImageView getImgMedailleReplik() {
		return imgMedailleReplik;
	}

	public void setImgMedailleReplik(ImageView imgMedailleReplik) {
		this.imgMedailleReplik = imgMedailleReplik;
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

	public TextView getTvNbJoueurs() {
		return tvNbJoueurs;
	}

	public void setTvNbJoueurs(TextView tvNbJoueurs) {
		this.tvNbJoueurs = tvNbJoueurs;
	}

	
	
	
	
}
