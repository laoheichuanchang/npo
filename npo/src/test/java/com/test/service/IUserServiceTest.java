package com.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kft.npo.entity.SysUser;
import com.kft.npo.service.IUserService;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:applicationContext.xml"})
public class IUserServiceTest{

	@Autowired
	private IUserService userService;
	
	@Test
	public void getUserByIdTest(){
		 SysUser user = userService.getUserById(14);
		 if(null != user){
		     System.out.println(user.getAccount());
		 }
	}
}
