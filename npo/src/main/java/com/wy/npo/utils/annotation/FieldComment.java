package com.wy.npo.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作日志记录注解
 * @author wangy
 */
@Target({ElementType.TYPE, ElementType.FIELD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented  
public @interface FieldComment {
   
	public String value() default "";
}
