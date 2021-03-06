package br.com.mirabilis.sqlite.annotation.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.mirabilis.sqlite.manager.model.SQLiteEntity;
import br.com.mirabilis.sqlite.manager.model.SQLiteField;
import br.com.mirabilis.sqlite.manager.model.SQLiteTable;

/**
 * Anottation of field sqlite.
 *
 * @author Rodrigo Sim�es Rosa
 */
@Documented
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SQLiteAnnotationField {

    /**
     * name field in sqlite.
     *
     * @return
     */
    String name();

    /**
     * type field in sqlite.
     *
     * @return
     */
    SQLiteField.SQLiteFieldType type();

    /**
     * if field is primarykey in table.
     *
     * @return
     */
    boolean primaryKey() default false;

    /**
     * if field is foreignkey in table. ** Only will be functional if set
     * reference.
     *
     * @return
     */
    boolean foreignKey() default false;

    /**
     * reference of foreignkey.
     *
     * @return
     */
    Class<? extends SQLiteTable> reference() default SQLiteTable.class;

    /**
     * modifier of foreign key.
     *
     * @return
     */
    SQLiteEntity.SQLiteForeignModifier foreignKeyModifier() default SQLiteEntity.SQLiteForeignModifier.RESTRICT;

    /**
     * not null in field.
     *
     * @return
     */
    boolean notNull() default false;

    /**
     * autoincrement in field.
     *
     * @return
     */
    boolean autoIncrement() default false;

    /**
     * action in field foreignkey
     *
     * @return
     */
    SQLiteEntity.SQLiteAction action() default SQLiteEntity.SQLiteAction.ON_DELETE;
}