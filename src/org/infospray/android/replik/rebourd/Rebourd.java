package org.infospray.android.replik.rebourd;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Rebourd extends CountDownTimer {

	TextView tv = null;
	
	
	  public Rebourd(TextView tv, long millisInFuture, long countDownInterval) {
		  
           super(millisInFuture, countDownInterval);
           this.tv = tv;
     }

	
	@Override
	public void onFinish() {
		this.tv.setText("0");

		
	}

	@Override
	public void onTick(long millisUntilFinished) {
		this.tv.setText(millisUntilFinished / 1000 + " Sec");

		
	}

}
