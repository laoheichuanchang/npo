package com.wy.npo.dao;

/**
 * 数据层基类
 * @author wangy
 * @param <T>
 */
public interface BaseMapper<T>{
     
	T selectByPrimaryKey(Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
    
}
