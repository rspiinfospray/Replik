package org.infospray.android.replik.ws.utils;

public class ConstantsWs {

	private ConstantsWs(){
		
	}
	
	public static String	URL_WEBSERVICE = "http://ws.infospray.org/ReplikSrvWs";
	
	public static String	NAMESPACE = "http://ws.replik.infospray.org/";
	
	public static String	METHODE_NAME_PLAY = "play";
	
	public static String	SOAP_ACTION_PLAY = "\"play\"";
	
	public static String	METHODE_NAME_CLASSEMENT = "getClassement";
	
	public static String	SOAP_ACTION_CLASSEMENT = "\"getClassement\"";
	
	public static String	METHODE_NAME_VALIDATE_USER = "validateUserByPseudo";
	
	public static String	SOAP_ACTION_VALIDATE_USER = "\"validateUserByPseudo\"";
	
	public static String	METHODE_NAME_VALIDATE_ANSWER = "validateAnswer";
	
	public static String	SOAP_ACTION_VALIDATE_ANSWER = "\"validateAnswer\"";
	
	public static String	METHODE_NAME_SYNCHRONISATION = "synchronisation";
	
	public static String	SOAP_ACTION_SYNCHRONISATION = "\"synchronisation\"";

	
	public static Integer	TIMEOUT = 3000;
	
	
}
