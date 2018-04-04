package com.wy.npo.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.wy.npo.constants.enums.OperationTypeEnum;

/**
 * 定义日志操作类型注解
 * @author wangy
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented   
public @interface OperationLog {
    
	/**
	 * 要执行的操作类型，比如：新增操作
	 * @return
	 */
	public OperationTypeEnum operationType();
	
	/**
	 * 要执行的操作的名称，比如：用户管理
	 * @return
	 */
	public String operationName() default "";
}
