package org.infospray.android.replik.ws.beans;


public class InfosUser implements Comparable<InfosUser> {


	private String pseudo;
	
	private String classement;
	
	private String point;


	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getClassement() {
		return classement;
	}

	public void setClassement(String classement) {
		this.classement = classement;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public int compareTo(InfosUser another) {
		
		if(Integer.valueOf(this.classement).intValue() < Integer.valueOf(another.getClassement()).intValue()){
			return -1;
		}
		if(Integer.valueOf(this.classement).intValue() == Integer.valueOf(another.getClassement()).intValue()){
			return 0;
		}
		if(Integer.valueOf(this.classement).intValue() > Integer.valueOf(another.getClassement()).intValue()){
			return 1;
		}
		
		return -1;
		
	}



	
	
	
}
