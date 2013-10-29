package br.com.mirabilis.sqlite.annotation.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anottation of field sqlite.
 * 
 * @author Rodrigo Sim�es Rosa
 */
@Documented
@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SQLiteAnnotationField {
	String name();

	String type();

	boolean primaryKey() default false;

	boolean autoIncrement() default false;

	boolean notNull() default false;
}