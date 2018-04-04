package com.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wy.npo.entity.SysUser;
import com.wy.npo.service.IUserService;

/**
 * ����spring��junit��ϣ�junit����ʱ����springIOC���� spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ����junit spring�����ļ�
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
