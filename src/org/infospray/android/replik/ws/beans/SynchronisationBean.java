package org.infospray.android.replik.ws.beans;

public class SynchronisationBean extends ResponseContext {

	private String	tempsRestantAvantDebutManche;
	
	private String gameReady;

	public String getTempsRestantAvantDebutManche() {
		return tempsRestantAvantDebutManche;
	}

	public void setTempsRestantAvantDebutManche(String tempsRestantAvantDebutManche) {
		this.tempsRestantAvantDebutManche = tempsRestantAvantDebutManche;
	}

	public String getGameReady() {
		return gameReady;
	}

	public void setGameReady(String gameReady) {
		this.gameReady = gameReady;
	}
	
	
	
	
}
