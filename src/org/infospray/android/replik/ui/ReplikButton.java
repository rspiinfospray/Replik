package org.infospray.android.replik.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class ReplikButton extends Button {

	private int idAnswer;
	
	public ReplikButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private ReplikButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	private ReplikButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public int getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}

	
	
	
}
