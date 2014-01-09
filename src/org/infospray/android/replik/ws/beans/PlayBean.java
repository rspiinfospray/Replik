package org.infospray.android.replik.ws.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PlayBean extends ResponseContext implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String	tempsRestantPourReplik;
	
	private String	 currentReplikId;
	
	private String	secondParReplik;
	
	private	String	nbTotalReplik;
	
	private String 	classementGeneral;
	
	private String	nbJoueurs;
	
	private String points;
	
	private String	tempsRestantAvantDebutManche;
	
	private String secondEntreManche;
	
	private String 	gameReady;
	
	private List<Replik> replik = new ArrayList<Replik>();


	public String getTempsRestantPourReplik() {
		return tempsRestantPourReplik;
	}

	public void setTempsRestantPourReplik(String tempsRestantPourReplik) {
		this.tempsRestantPourReplik = tempsRestantPourReplik;
	}

	public List<Replik> getReplik() {
		return replik;
	}

	public void setReplik(List<Replik> replik) {
		this.replik = replik;
	}

	public String getCurrentReplikId() {
		return currentReplikId;
	}

	public void setCurrentReplikId(String currentReplikId) {
		this.currentReplikId = currentReplikId;
	}

	public String getSecondParReplik() {
		return secondParReplik;
	}

	public void setSecondParReplik(String secondParReplik) {
		this.secondParReplik = secondParReplik;
	}

	public String getNbTotalReplik() {
		return nbTotalReplik;
	}

	public void setNbTotalReplik(String nbTotalReplik) {
		this.nbTotalReplik = nbTotalReplik;
	}

	public String getClassementGeneral() {
		return classementGeneral;
	}

	public void setClassementGeneral(String classementGeneral) {
		this.classementGeneral = classementGeneral;
	}

	public String getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(String nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

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

	
	

}
