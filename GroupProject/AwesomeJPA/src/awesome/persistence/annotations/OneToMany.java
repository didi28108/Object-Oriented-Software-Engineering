package awesome.persistence.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Definition for the "OneToMany" annotation
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OneToMany {
	// How to treat the field at load time
	FetchType fetch() default FetchType.LAZY;
	//
	String mappedBy() default "";
}