package org.infospray.android.replik.ws;

import java.io.IOException;
import java.lang.reflect.Field;

import org.infospray.android.replik.dao.AndroidHttpTransport;
import org.infospray.android.replik.ws.beans.ConstantsError;
import org.infospray.android.replik.ws.beans.SynchronisationBean;
import org.infospray.android.replik.ws.beans.ValidateUserBean;
import org.infospray.android.replik.ws.utils.ConstantsWs;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;

public class Synchronisation extends AsyncTask<ValidateUserBean, Integer, SynchronisationBean> {

	private static final String SOAP_ACTION = "synchronisation";
	private static final String METHOD_NAME = "synchronisation";



	public SynchronisationBean callWs(ValidateUserBean user){

		SoapObject requete = new SoapObject(ConstantsWs.NAMESPACE, METHOD_NAME);
		requete.addProperty("arg0", user.getPseudo());
		requete.addProperty("arg1", user.getSecurityString());

		SoapSerializationEnvelope envelope=  new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(requete);		
		AndroidHttpTransport transport = new org.infospray.android.replik.dao.AndroidHttpTransport(ConstantsWs.URL_WEBSERVICE, ConstantsWs.TIMEOUT);


		SynchronisationBean sync = new SynchronisationBean();


		try {
			transport.call(SOAP_ACTION, envelope);
			SoapObject result = (SoapObject) envelope.getResponse();


			for(int cpt = 0; cpt != result.getPropertyCount(); cpt++){
				PropertyInfo pi = new PropertyInfo();
				result.getPropertyInfo(cpt, pi);

				// premier niveau avec prise en charge de l extend
				if(pi.getType().equals(SoapPrimitive.class)){

					String nomField = pi.getName();
					SoapPrimitive valueField = (SoapPrimitive)pi.getValue();
					String valueStrField = valueField.toString();
					Field field= null;
					try{
						field = sync.getClass().getDeclaredField(nomField);
					}
					catch (NoSuchFieldException e) {
						field =  sync.getClass().getSuperclass().getDeclaredField(nomField);
					}
					field.setAccessible(true);
					field.set(sync, valueStrField);
				}
			}


		} catch (IOException e) {
			e.getMessage();
			sync.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			sync.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
		} catch (XmlPullParserException e) {
			sync.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			sync.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
		} catch (Exception e){
			sync.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			sync.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
		}


		return sync;
	}


	@Override
	protected SynchronisationBean doInBackground(ValidateUserBean... params) {
		// TODO Auto-generated method stub
		return this.callWs(params[0]);
	}



}
