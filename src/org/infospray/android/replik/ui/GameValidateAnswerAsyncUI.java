package org.infospray.android.replik.ui;


import java.util.zip.Inflater;

import org.infospray.android.replik.GameActivity;
import org.infospray.android.replik.R;

import org.infospray.android.replik.utils.Constants;
import org.infospray.android.replik.ws.ValidateAnswerInputParameter;
import org.infospray.android.replik.ws.beans.AnswerBean;
import org.infospray.android.replik.ws.beans.ConstantsError;
import org.infospray.android.replik.ws.call.CommonCallWs;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Toast;




public class GameValidateAnswerAsyncUI extends AsyncTask<ValidateAnswerInputParameter, Integer, AnswerBean> {


	private GameActivity		activity;

	
	
	public GameValidateAnswerAsyncUI(GameActivity activity) {
		super();
		this.activity = activity;
	}


	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}
	


	@Override
	protected AnswerBean doInBackground(ValidateAnswerInputParameter... params) {
		// TODO Auto-generated method stub
		return CommonCallWs.callAnswerWs(params[0]);
	}
	
	
	

	@Override
	protected void onPostExecute(AnswerBean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if(result != null && result.getCodeRetour().equals(ConstantsError.OK_CODE)){
			Toast toast = Toast.makeText(this.activity, "bonus de 40 pts", Constants.TOAST_BONUS_ANSWER);
			toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
			
		//	View layoutToast = activity.getLayoutInflater().inflate(R.layout.perso_toast_stats, (ViewGroup) activity.findViewById(id));
			
		//	toast.setView(layoutToast);
			toast.show();
		}
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(GameActivity activity) {
		this.activity = activity;
	}

	
	

	
}
