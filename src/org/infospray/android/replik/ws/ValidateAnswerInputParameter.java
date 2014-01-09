package org.infospray.android.replik.ws;

import org.infospray.android.replik.utils.PseudoCredentials;


public class ValidateAnswerInputParameter  {

	private PseudoCredentials pseudoCredentials;
	
	private boolean goodAnswer;
	
	private int currentReplikid;
	
	private long tempsReaction;


	public boolean isGoodAnswer() {
		return goodAnswer;
	}

	public void setGoodAnswer(boolean goodAnswer) {
		this.goodAnswer = goodAnswer;
	}

	public int getCurrentReplikid() {
		return currentReplikid;
	}

	public void setCurrentReplikid(int currentReplikid) {
		this.currentReplikid = currentReplikid;
	}

	public long getTempsReaction() {
		return tempsReaction;
	}

	public void setTempsReaction(long tempsReaction) {
		this.tempsReaction = tempsReaction;
	}

	public PseudoCredentials getPseudoCredentials() {
		return pseudoCredentials;
	}

	public void setPseudoCredentials(PseudoCredentials pseudoCredentials) {
		this.pseudoCredentials = pseudoCredentials;
	}
	
	
	
	
	
}
