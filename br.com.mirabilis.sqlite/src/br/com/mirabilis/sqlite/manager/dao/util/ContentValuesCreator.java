package br.com.mirabilis.sqlite.manager.dao.util;

import java.lang.reflect.Field;

import br.com.mirabilis.sqlite.annotation.model.SQLiteAnnotationField;
import android.content.ContentValues;

/**
 * Class that recovery ContentValues by T data. 
 * @author Rodrigo Sim�es Rosa.
 */
public class ContentValuesCreator {
	
	public static <T> ContentValues creator(T data) throws IllegalArgumentException, IllegalAccessException{
		ContentValues contentValues = new ContentValues();
		Class<?> c = data.getClass(); 
		for(Field field : c.getDeclaredFields()){
			
			if(field.isAnnotationPresent(SQLiteAnnotationField.class)){
				field.setAccessible(true);
				Object value = field.get(data);
				
				//TODO I know it's smelling like shit, but it was the first solution that I found (XGH) :B
				switch (ContentValuesType.getType(value)) {
					case BOOLEAN:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(), (Boolean) value);
					break;

					case BYTE:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(), (Byte) value);
					break;
					
					case BYTE_ARRAY:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(), (byte[]) field.get(data));
					break;
					
					case DOUBLE:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(), (Double) value);
					break;
					
					case FLOAT:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(), (Float) value);
					break;
					
					case INTEGER:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(),  (Integer) value);
					break;
					
					case LONG:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(),  (Long) value);
					break;
					
					case SHORT:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(), (Short) value);
					break;
					
					case STRING:
						contentValues.put(field.getAnnotation(SQLiteAnnotationField.class).name(), (String) value);
					break;
					
					default:
						contentValues.putNull(field.getAnnotation(SQLiteAnnotationField.class).name());
					break;
				}
			}
		}
		return contentValues;
	}
}