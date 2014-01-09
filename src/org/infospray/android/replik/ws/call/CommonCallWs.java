package org.infospray.android.replik.ws.call;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;


import org.infospray.android.replik.dao.AndroidHttpTransport;
import org.infospray.android.replik.utils.PseudoCredentials;
import org.infospray.android.replik.ws.Synchronisation;
import org.infospray.android.replik.ws.ValidateAnswerInputParameter;
import org.infospray.android.replik.ws.beans.AnswerBean;
import org.infospray.android.replik.ws.beans.ConstantsError;
import org.infospray.android.replik.ws.beans.ClassementBean;
import org.infospray.android.replik.ws.beans.InfosUser;
import org.infospray.android.replik.ws.beans.PlayBean;
import org.infospray.android.replik.ws.beans.Proposition;
import org.infospray.android.replik.ws.beans.Replik;
import org.infospray.android.replik.ws.beans.SynchronisationBean;
import org.infospray.android.replik.ws.beans.ValidateUserBean;
import org.infospray.android.replik.ws.utils.ConstantsWs;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParserException;

public class CommonCallWs {

	
	private CommonCallWs() {
		// TODO Auto-generated constructor stub
	}
	
	


	
	/*public static SynchronisationBean callSynchronisationWs(String pseudo, String securityString){

		Synchronisation syncWs = new Synchronisation();
		SynchronisationBean sync = null;
		ValidateUserBean user = new ValidateUserBean();
		user.setPseudo(pseudo);
		user.setSecurityString(securityString);
		try {
			sync = syncWs.execute(user).get();
		} catch (Exception e) {
			sync.setCodeRetour(ConstantsError.WS_CALL_ERROR_CODE);
			sync.setLibelleRetour(ConstantsError.WS_CALL_ERROR_LBL);
	
		}

		return sync;
	}*/
	
	public static SynchronisationBean callSynchronisationWs(PseudoCredentials pseudoCredentials){

		SoapObject requete = new SoapObject(ConstantsWs.NAMESPACE, ConstantsWs.METHODE_NAME_SYNCHRONISATION);
		requete.addProperty("arg0", pseudoCredentials.getPseudo());
		requete.addProperty("arg1", pseudoCredentials.getSecurityString());

		SoapSerializationEnvelope envelope=  new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(requete);		
		AndroidHttpTransport transport = new org.infospray.android.replik.dao.AndroidHttpTransport(ConstantsWs.URL_WEBSERVICE, ConstantsWs.TIMEOUT);


		SynchronisationBean sync = new SynchronisationBean();


		try {
			transport.call(ConstantsWs.SOAP_ACTION_SYNCHRONISATION, envelope);
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


		} catch (Exception e) {
			sync.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			sync.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
	
		}

		return sync;
	}
	
	

	
	public static PlayBean callPlayWs(ValidateUserBean user){
		
		SoapObject requete = new SoapObject(ConstantsWs.NAMESPACE, ConstantsWs.METHODE_NAME_PLAY);
		requete.addProperty("arg0", user.getPseudo());
		requete.addProperty("arg1", user.getSecurityString());
	
		SoapSerializationEnvelope envelope=  new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(requete);		
		AndroidHttpTransport transport = new org.infospray.android.replik.dao.AndroidHttpTransport(ConstantsWs.URL_WEBSERVICE, ConstantsWs.TIMEOUT);

		
		PlayBean play = new PlayBean();
		
		
		try {
			transport.call(ConstantsWs.SOAP_ACTION_PLAY, envelope);
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
						field = play.getClass().getDeclaredField(nomField);
					}
					catch (NoSuchFieldException e) {
						field =  play.getClass().getSuperclass().getDeclaredField(nomField);
					}
					field.setAccessible(true);
					field.set(play, valueStrField);
				}
				// second niveau ici objet replik
				if(pi.getType().equals(SoapObject.class)){
					SoapObject valueField = (SoapObject)pi.getValue();
					Replik replik = new Replik();
					for(int cptSub = 0; cptSub != valueField.getPropertyCount(); cptSub++){
						PropertyInfo piSub = new PropertyInfo();
						valueField.getPropertyInfo(cptSub, piSub);
						if(piSub.getType().equals(SoapPrimitive.class)){
							
							String nomFieldSub = piSub.getName();
							SoapPrimitive valueFieldSub = (SoapPrimitive)piSub.getValue();
							String valueStrFieldSub = valueFieldSub.toString();
							Field field = replik.getClass().getDeclaredField(nomFieldSub);
							field.setAccessible(true);
							field.set(replik, valueStrFieldSub);

						}
						
						// troisieme niveau
						if(piSub.getType().equals(SoapObject.class)){
							Proposition proposition = new Proposition();
							SoapObject valueFieldThirld = (SoapObject)piSub.getValue();
							for(int cptSubThird = 0; cptSubThird != valueFieldThirld.getPropertyCount(); cptSubThird++){
								PropertyInfo piSubThird = new PropertyInfo();
								valueFieldThirld.getPropertyInfo(cptSubThird, piSubThird);
								if(piSubThird.getType().equals(SoapPrimitive.class)){
									
									String nomFieldSubThird = piSubThird.getName();
									SoapPrimitive valueFieldSubThird = (SoapPrimitive)piSubThird.getValue();
									String valueStrFieldSubThird = valueFieldSubThird.toString();
									Field field = proposition.getClass().getDeclaredField(nomFieldSubThird);
									field.setAccessible(true);
									field.set(proposition, valueStrFieldSubThird);
									
								}
								
							}
							replik.getPropositions().add(proposition);
						}												
					}
					play.getReplik().add(replik);
				}
			}
			
			
			
		

		} catch (Exception e) {
			play.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			play.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
	
		}
		
		
		return play;
	}
	
	
	/**
	 * Appel du webservice utilisé pour le classement  : getMatch
	 * @param userBean
	 * @return
	 */
	public static ClassementBean callClassementWs(ValidateUserBean userBean){
		
		SoapObject requete = new SoapObject(ConstantsWs.NAMESPACE, ConstantsWs.METHODE_NAME_CLASSEMENT);
		requete.addProperty("arg0", userBean.getPseudo());
		requete.addProperty("arg1", userBean.getSecurityString());
	
		SoapSerializationEnvelope envelope=  new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(requete);		
		AndroidHttpTransport transport = new org.infospray.android.replik.dao.AndroidHttpTransport(ConstantsWs.URL_WEBSERVICE, ConstantsWs.TIMEOUT);
		
		
		ClassementBean classementBean = new ClassementBean();
		
		
		
		try {
			transport.call(ConstantsWs.SOAP_ACTION_CLASSEMENT, envelope);
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
						field = classementBean.getClass().getDeclaredField(nomField);
					}
					catch (NoSuchFieldException e) {
						field =  classementBean.getClass().getSuperclass().getDeclaredField(nomField);
					}
					field.setAccessible(true);
					field.set(classementBean, valueStrField);
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
					classementBean.getListeUser().add(infosUser);
				}
			}
			
		} catch (Exception e) {			
			classementBean.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			classementBean.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);	
		}
		
		
		Collections.sort(classementBean.getListeUser());
		
		return classementBean;
		
	}


	/**
	 * Appel du webservice d enregistrement ou de validation du pseudo
	 * @param inputParam
	 * @return
	 */
	public static ValidateUserBean callValidateUserWs(PseudoCredentials inputParam){

		SoapObject requete = new SoapObject(ConstantsWs.NAMESPACE, ConstantsWs.METHODE_NAME_VALIDATE_USER);
		requete.addProperty("arg0", inputParam.getPseudo());
		requete.addProperty("arg1", inputParam.getSecurityString());

		SoapSerializationEnvelope envelope=  new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(requete);
		AndroidHttpTransport transport = new org.infospray.android.replik.dao.AndroidHttpTransport(ConstantsWs.URL_WEBSERVICE, ConstantsWs.TIMEOUT);

		ValidateUserBean validateUser =	new ValidateUserBean();


		try {
			transport.call(ConstantsWs.SOAP_ACTION_VALIDATE_USER, envelope);
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
						field = validateUser.getClass().getDeclaredField(nomField);
					}
					catch (NoSuchFieldException e) {
						field =  validateUser.getClass().getSuperclass().getDeclaredField(nomField);
					}
					field.setAccessible(true);
					field.set(validateUser, valueStrField);
				}
			}


		} catch (Exception e) {
			validateUser.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			validateUser.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
		} 

		return validateUser;

	}
	
	
	/**
	 * Appel au webservice de recuperation des informations liés a la reponse donnée
	 * @param inputParam
	 * @return
	 */
	public static  AnswerBean callAnswerWs(ValidateAnswerInputParameter inputParam){
		SoapObject requete = new SoapObject(ConstantsWs.NAMESPACE, ConstantsWs.METHODE_NAME_VALIDATE_ANSWER);
		
		SoapSerializationEnvelope envelope=  new SoapSerializationEnvelope(SoapEnvelope.VER11);
		requete.addProperty("arg0", inputParam.getPseudoCredentials().getPseudo());
		requete.addProperty("arg1", inputParam.getPseudoCredentials().getSecurityString());
		requete.addProperty("arg2", inputParam.isGoodAnswer());
		requete.addProperty("arg3", String.valueOf(inputParam.getCurrentReplikid()));
		requete.addProperty("arg4", inputParam.getTempsReaction());
		envelope.setOutputSoapObject(requete);		
		AndroidHttpTransport transport = new org.infospray.android.replik.dao.AndroidHttpTransport(ConstantsWs.URL_WEBSERVICE, ConstantsWs.TIMEOUT);
		
		
		AnswerBean answer =  new AnswerBean();
		
		
		try {
			transport.call(ConstantsWs.SOAP_ACTION_VALIDATE_ANSWER, envelope);
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
						field = answer.getClass().getDeclaredField(nomField);
					}
					catch (NoSuchFieldException e) {
						field =  answer.getClass().getSuperclass().getDeclaredField(nomField);
					}
					field.setAccessible(true);
					field.set(answer, valueStrField);
				}
			}
		
		} catch (Exception e){
			answer.setCodeRetour(ConstantsError.CNX_FAILED_CODE);
			answer.setLibelleRetour(ConstantsError.CNX_FAILED_LBL);
		}
		
		return answer;
	}
}
