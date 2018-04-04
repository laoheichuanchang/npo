package com.wy.npo.service;

/**
 * 业务层公共接口类
 * @author wangy
 * @param <T>
 */
public interface IBaseService<T> {
        
	/**
	 * 根据主键获取数据
	 * @param id
	 * @return
	 */
    T selectByPrimaryKey(Integer id);

}
