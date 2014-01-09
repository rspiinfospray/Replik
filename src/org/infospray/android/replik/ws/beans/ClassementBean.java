package org.infospray.android.replik.ws.beans;

import java.util.ArrayList;
import java.util.List;


public class ClassementBean extends ResponseContext  {

	
	private List<InfosUser> listeUser = new ArrayList<InfosUser>();
	
	private String totalReplik;
	
	private String currentReplik;
	
	private String	secondParReplik;
	
	private String timeBeforeReplikChange;
	
	private String securityString;
	
	private String	nbJoueurs;
	
	private String	tempsRestantAvantDebutManche;
	
	private String secondEntreManche;
	
	private String 	gameReady;

	public String getTempsRestantAvantDebutManche() {
		return tempsRestantAvantDebutManche;
	}

	public void setTempsRestantAvantDebutManche(String tempsRestantAvantDebutManche) {
		this.tempsRestantAvantDebutManche = tempsRestantAvantDebutManche;
	}

	public String getSecondEntreManche() {
		return secondEntreManche;
	}

	public void setSecondEntreManche(String secondEntreManche) {
		this.secondEntreManche = secondEntreManche;
	}

	public String getGameReady() {
		return gameReady;
	}

	public void setGameReady(String gameReady) {
		this.gameReady = gameReady;
	}

	public String getTotalReplik() {
		return totalReplik;
	}

	public void setTotalReplik(String totalReplik) {
		this.totalReplik = totalReplik;
	}

	public String getCurrentReplik() {
		return currentReplik;
	}

	public void setCurrentReplik(String currentReplik) {
		this.currentReplik = currentReplik;
	}

	public String getSecondParReplik() {
		return secondParReplik;
	}

	public void setSecondParReplik(String secondParReplik) {
		this.secondParReplik = secondParReplik;
	}

	public String getTimeBeforeReplikChange() {
		return timeBeforeReplikChange;
	}

	public void setTimeBeforeReplikChange(String timeBeforeReplikChange) {
		this.timeBeforeReplikChange = timeBeforeReplikChange;
	}

	public List<InfosUser> getListeUser() {
		return listeUser;
	}

	public void setListeUser(List<InfosUser> listeUser) {
		this.listeUser = listeUser;
	}

	public String getSecurityString() {
		return securityString;
	}

	public void setSecurityString(String securityString) {
		this.securityString = securityString;
	}

	public String getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(String nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	
	
	
	
	
}
