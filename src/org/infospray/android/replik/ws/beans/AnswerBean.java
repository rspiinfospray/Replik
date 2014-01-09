package org.infospray.android.replik.ws.beans;


public class AnswerBean extends ResponseContext {
		
	private String classementReplik;
	
	private String classementGeneral;
	
	private String points;

	private String	nbJoueurs;
	
	private String  pointsReplik;
	
	private String	tempsRestantAvantDebutManche;
	
	private String secondEntreManche;
	
	private String 	gameReady;


	public String getClassementReplik() {
		return classementReplik;
	}

	public void setClassementReplik(String classementReplik) {
		this.classementReplik = classementReplik;
	}

	public String getClassementGeneral() {
		return classementGeneral;
	}

	public void setClassementGeneral(String classementGeneral) {
		this.classementGeneral = classementGeneral;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(String nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public String getPointsReplik() {
		return pointsReplik;
	}

	public void setPointsReplik(String pointsReplik) {
		this.pointsReplik = pointsReplik;
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
