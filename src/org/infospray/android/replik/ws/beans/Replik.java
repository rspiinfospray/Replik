package org.infospray.android.replik.ws.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Replik implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String replikId;
	
	private String replikLbl;
	
	private String replikIdInList;
	
	private List<Proposition> propositions = new ArrayList<Proposition>();


	public String getReplikLbl() {
		return replikLbl;
	}

	public void setReplikLbl(String replikLbl) {
		this.replikLbl = replikLbl;
	}

	public String getReplikId() {
		return replikId;
	}

	public void setReplikId(String replikId) {
		this.replikId = replikId;
	}

	public String getReplikIdInList() {
		return replikIdInList;
	}

	public void setReplikIdInList(String replikIdInList) {
		this.replikIdInList = replikIdInList;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	
	
}
