package org.infospray.android.replik.ws;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;

import org.infospray.android.replik.dao.AndroidHttpTransport;
import org.infospray.android.replik.ws.beans.ConstantsError;
import org.infospray.android.replik.ws.beans.InfosUser;
import org.infospray.android.replik.ws.beans.ClassementBean;
import org.infospray.android.replik.ws.beans.ValidateUserBean;
import org.infospray.android.replik.ws.utils.ConstantsWs;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;


public class GetMatch extends AsyncTask<ValidateUserBean, Integer, ClassementBean> {

	
	private static final String SOAP_ACTION = "getClassement";
	private static final String METHOD_NAME = "getClassement";

	
	public ClassementBean callWs(ValidateUserBean userBean){
		
		SoapObject requete = new SoapObject(ConstantsWs.NAMESPACE, METHOD_NAME);
		requete.addProperty("arg0", userBean.getPseudo());
		requete.addProperty("arg1", userBean.getSecurityString());
	
		SoapSerializationEnvelope envelope=  new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(requete);		
		AndroidHttpTransport transport = new org.infospray.android.replik.dao.AndroidHttpTransport(ConstantsWs.URL_WEBSERVICE, ConstantsWs.TIMEOUT);
		
		
		ClassementBean match = new ClassementBean();
		
		
		
		try {
			transport.call(SOAP_ACTION, envelope);
			SoapObject result = (SoapObject) envelope.getResponse();
			
			
			for(int cpt = 0; cpt != result.getPropertyCount(); cpt++){
				PropertyInfo pi = new PropertyInfo();
				result.getPropertyInfo(cpt, pi);
				
				if(pi.getType().equals(SoapPrimitive.class)){
				
					String nomField = pi.getName();
					SoapPrimitive valueField = (SoapPrimitive)pi.getValue();
					String valueStrField = valueField.toString();
					Field field= null;
					try{
						field = match.getClass().getDeclaredField(nomField);
					}
					catch (NoSuchFieldException e) {
						field =  match.getClass().getSuperclass().getDeclaredField(nomField);
					}
					field.setAccessible(true);
					field.set(match, valueStrField);
				}
				if(pi.getType().equals(SoapObject.class)){
					SoapObject valueField = (SoapObject)pi.getValue();
					InfosUser infosUser = new InfosUser();
					for(int cptSub = 0; cptSub != valueField.getPropertyCount(); cptSub++){
						PropertyInfo piSub = new PropertyInfo();
						valueField.getPropertyInfo(cptSub, piSub);
						if(piSub.getType().equals(SoapPrimitive.class)){
							
							String nomFieldSub = piSub.getName();
							SoapPrimitive valueFieldSub = (SoapPrimitive)piSub.getValue();
							String valueStrFieldSub = valueFieldSub.toString();
							Field field = infosUser.getClass().getDeclaredField(nomFieldSub);
							field.setAccessible(true);
							field.set(infosUser, valueStrFieldSub);

						}
					}
					match.getListeUser().add(infosUser);
				}
			}
			
		} catch (IOException e) {
			e.getMessage();
			match.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			match.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
		} catch (XmlPullParserException e) {
			match.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			match.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
		} catch (Exception e){
			match.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			match.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
		}
		
		
		Collections.sort(match.getListeUser());
		
		return match;
		
	}


	@Override
	protected ClassementBean doInBackground(ValidateUserBean... params) {
		return callWs(params[0]);
	}


	
	
}
