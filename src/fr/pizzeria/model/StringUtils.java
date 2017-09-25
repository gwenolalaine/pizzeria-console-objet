package fr.pizzeria.model;

import java.lang.reflect.Field;

public class StringUtils {
	public static String convert(Object object){
		String str = "";
		Class thisClass;
		try {
			thisClass = Class.forName(object.getClass().getName());

	        Field[] fields = thisClass.getDeclaredFields();
	        
	        
			for(int i = 0; i < fields.length; i++){
				fields[i].setAccessible(true);
				ToString anotation = fields[i].getAnnotation(ToString.class);
				Object value = fields[i].get(object);
				if(anotation != null){
					if(fields[i].getAnnotation(ToString.class).upperCase()  == true){
						str += ((String) value).toUpperCase() + " ";
					}else{
						str += value + " ";
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}
}
