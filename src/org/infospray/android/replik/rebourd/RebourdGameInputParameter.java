package org.infospray.android.replik.rebourd;


import org.infospray.android.replik.GameActivity;
import org.infospray.android.replik.ws.beans.PlayBean;


public class RebourdGameInputParameter {

	private long			millisInFuture;
	private long 			countDownInterval;
	private PlayBean		play;
	private int				currentCpt;
	private Boolean			reload = false;
	private GameActivity	activityInstance;
	

	
	public long getMillisInFuture() {
		return millisInFuture;
	}
	public void setMillisInFuture(long millisInFuture) {
		this.millisInFuture = millisInFuture;
	}
	public long getCountDownInterval() {
		return countDownInterval;
	}
	public void setCountDownInterval(long countDownInterval) {
		this.countDownInterval = countDownInterval;
	}

	public PlayBean getPlay() {
		return play;
	}
	public void setPlay(PlayBean play) {
		this.play = play;
	}


	public int getCurrentCpt() {
		return currentCpt;
	}
	public void setCurrentCpt(int currentCpt) {
		this.currentCpt = currentCpt;
	}

	public Boolean getReload() {
		return reload;
	}
	public void setReload(Boolean reload) {
		this.reload = reload;
	}
	public GameActivity getActivityInstance() {
		return activityInstance;
	}
	public void setActivityInstance(GameActivity activityInstance) {
		this.activityInstance = activityInstance;
	}

	
	
	
	
	
	
}
