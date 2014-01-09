package org.infospray.android.replik.dao;

import java.io.IOException;

import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.ServiceConnection;

public class AndroidHttpTransport extends HttpTransportSE {

	public AndroidHttpTransport(String url, int timeout) {
		super(url, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ServiceConnection getServiceConnection() throws IOException {
		// TODO Auto-generated method stub
		return new AndroidServiceConnection(super.url);
	}


	
	

}
