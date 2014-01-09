package org.infospray.android.replik.ws.beans;


public class ValidateUserBean extends ResponseContext {

	String securityString;
	
	String pseudo;

	public String getSecurityString() {
		return securityString;
	}

	public void setSecurityString(String securityString) {
		this.securityString = securityString;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
	
	
}
