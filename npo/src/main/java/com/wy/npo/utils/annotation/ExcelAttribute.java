package com.wy.npo.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导入导出字段注解
 * 标注在实体类的字段上
 * @author wangy
 */
@Target(ElementType.FIELD)    
@Retention(RetentionPolicy.RUNTIME)    
@Documented  
public @interface ExcelAttribute {

	/**
	 * 列名
	 * @return
	 */
	public abstract String name();
	
	/**
	 * 列的顺序
	 * @return
	 */
	public abstract String column() default "";
	
	/**
	 * 是否导出数据 
	 * @return
	 */
	public abstract boolean isExport() default true;
	
	/**
	 * 是否为重要字段（整列标红,着重显示）
	 * @return
	 */
	public abstract boolean isMark() default false;
	
	/**
	 * 是否合计当前列 
	 * @return
	 */
	public abstract boolean isSum() default false; 
	
	/**
	 * 格式化数据
	 * @return
	 */
	public Class fommat() default String.class;
	
	/**
	 * 宽度设置
	 * @return
	 */
	public abstract int width() default 0;
}
