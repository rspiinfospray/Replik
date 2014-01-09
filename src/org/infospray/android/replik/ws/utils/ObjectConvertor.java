package org.infospray.android.replik.ws.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class ObjectConvertor {


	private ObjectConvertor() {
		// TODO Auto-generated constructor stub
	}


	public static void convert(SoapObject input, Object  output){


		Field[] field  = output.getClass().getDeclaredFields();
		Field[] superfield = output.getClass().getSuperclass().getDeclaredFields();

		List<Field[]> listFieldTab = new ArrayList<Field[]>();
		listFieldTab.add(field);
		listFieldTab.add(superfield);



		String resultToString = input.toString();



		for (Field[] fieldTab : listFieldTab) {

			for (Field currentField : fieldTab) {
				currentField.setAccessible(true);

				String fieldName = currentField.getName();

				if(currentField.getType().equals(String.class) || currentField.getType().equals(Integer.class)){
					if(resultToString.indexOf(fieldName) != -1){
						SoapPrimitive valueProperty =  (SoapPrimitive)input.getProperty(fieldName);
						if(valueProperty != null){
							try {
								currentField.set(output, valueProperty.toString());
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				}else{

					currentField.getName();
					Type fieldType = currentField.getType();
					Field[] tabssFielf = null;



					try {
						String nomClass = fieldType.toString();
						nomClass =  nomClass.replaceAll("class ", "");
						nomClass = nomClass.replaceAll("\\[L", "");
						nomClass = nomClass.replaceAll(";", "");

						Class c = Class.forName(nomClass);
						tabssFielf =  c.getDeclaredFields();
						for (Field currentSouField : tabssFielf) {
							//System.out.println(currentSouField.getName());
							
							if(currentSouField.getType().equals(String.class) || currentSouField.getType().equals(Integer.class)){
								if(resultToString.indexOf(fieldName) != -1){
									SoapPrimitive valueProperty =  (SoapPrimitive)input.getProperty(fieldName);
									if(valueProperty != null){
										try {
											currentSouField.set(output, valueProperty.toString());
										} catch (IllegalArgumentException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (IllegalAccessException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}

								}
							}
							
							
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}






				}
			}
		}

	}

}
