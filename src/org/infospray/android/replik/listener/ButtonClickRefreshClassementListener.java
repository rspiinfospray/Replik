package org.infospray.android.replik.listener;


import org.infospray.android.replik.ClassementActivity;
import org.infospray.android.replik.ui.UpdaterUI;

import android.view.View;
import android.view.View.OnClickListener;


public class ButtonClickRefreshClassementListener implements OnClickListener {


	private ClassementActivity activity;

	public ButtonClickRefreshClassementListener(ClassementActivity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		
		if(activity.getCounterTimeBetweenGameLeft() != null){
			activity.getCounterTimeBetweenGameLeft().cancel();
		}
		
		if(activity.getCounterTimeCompletReplikLeft() != null){
			activity.getCounterTimeCompletReplikLeft().cancel();
		}

		if(activity.getCounterTimeLeft() != null){
			activity.getCounterTimeLeft().cancel();
		}
		UpdaterUI.classement(activity);
		
	}

	public ClassementActivity getActivity() {
		return activity;
	}

	public void setActivity(ClassementActivity activity) {
		this.activity = activity;
	}
	
	


}
