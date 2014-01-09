package org.infospray.android.replik.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import android.util.Log;

public class Serializator {

	
	
	
	
	 private Serializator() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static byte[] serializeObject(Object o) { 
		    ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		 
		    try { 
		      ObjectOutput out = new ObjectOutputStream(bos); 
		      out.writeObject(o); 
		      out.close(); 
		 
		      // Get the bytes of the serialized object 
		      byte[] buf = bos.toByteArray(); 
		 
		      return buf; 
		    } catch(IOException ioe) { 
		      Log.e("serializeObject", "error", ioe); 
		 
		      return null; 
		    } 
		  } 
	 
	 
	 public static Object deserializeObject(byte[] b) { 
		    try { 
		      ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(b)); 
		      Object object = in.readObject(); 
		      in.close(); 
		 
		      return object; 
		    } catch(ClassNotFoundException cnfe) { 
		      Log.e("deserializeObject", "class not found error", cnfe); 
		 
		      return null; 
		    } catch(IOException ioe) { 
		      Log.e("deserializeObject", "io error", ioe); 
		 
		      return null; 
		    } 
		  }
	 
	 
	 public static void tableauDeBytesVersFichier(byte[] tableau, java.io.File fichier) throws java.io.IOException {
	    java.io.FileWriter f = new java.io.FileWriter(fichier);
	    //on itère sur chaque élément, car il n'y a pas de fonction globale
	    for (int i = 0; i < tableau.length; i++)
	        f.write(tableau[i]);
	    f.close();
	}
	
	
}
