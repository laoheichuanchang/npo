package com.wy.npo.service;

import java.util.List;

import com.wy.npo.entity.SysOperationLog;
import com.wy.npo.utils.PageHelper;

public interface ISysOperationLogService {
     
	/**
	 * 查询操作日志列表
	 * @param page
	 * @param record
	 * @return
	 */
	List<SysOperationLog> queryListByBean(PageHelper page,SysOperationLog record);
	
	/**
	 * 查询列表数量
	 * @param record
	 * @return
	 */
	Long queryCountByBean(SysOperationLog record);
}
