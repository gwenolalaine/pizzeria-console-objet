package fr.pizzeria.model;

import java.lang.reflect.Field;

public class StringUtils {
	public static String convert(Object object){
		String str = "";
		Class thisClass;
		StringBuilder bld = new StringBuilder();
		
		try {
			thisClass = Class.forName(object.getClass().getName());

	        Field[] fields = thisClass.getDeclaredFields();
	        
	        
			for(int i = 0; i < fields.length; i++){
				
				fields[i].setAccessible(true);
				ToString anotation = fields[i].getAnnotation(ToString.class);
				Object value = fields[i].get(object);
				if(anotation != null){
					if(fields[i].getAnnotation(ToString.class).upperCase()){
						bld.append(((String) value).toUpperCase() + " ");
					}else{
						bld.append(value + " ");
					}
				}
			}
			str = bld.toString();
		} catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return str;
	}
}
