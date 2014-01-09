package org.infospray.android.replik.adapter;

import java.util.List;

import org.infospray.android.replik.R;
import org.infospray.android.replik.ws.beans.InfosUser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UsersArrayAdapter extends ArrayAdapter<InfosUser> {
	
	
	private final Context context;
	private final List<InfosUser> listInfoUser;

	public UsersArrayAdapter(Context context,
			List<InfosUser> listUser) {
		
		super(context, R.layout.player, listUser);
		this.context = context;
		this.listInfoUser = listUser;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.player, parent, false);
			TextView tvClassement = (TextView) rowView.findViewById(R.id.classementVal);
			TextView tvPseudo = (TextView) rowView.findViewById(R.id.pseudoVal);
			TextView tvPoints = (TextView) rowView.findViewById(R.id.pointsVal);
			tvClassement.setText(this.listInfoUser.get(position).getClassement());
			tvPseudo.setText(this.listInfoUser.get(position).getPseudo());
			tvPoints.setText(this.listInfoUser.get(position).getPoint());

			return rowView;
	}
	
	

}
