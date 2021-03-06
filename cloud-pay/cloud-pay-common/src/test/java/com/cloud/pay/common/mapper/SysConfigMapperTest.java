package com.cloud.pay.common.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SysConfigMapperTest {

	@Autowired
	private SysConfigMapper sysConfigMapper;
	
	@Test
	public void selectByPrimaryKeyTest() {
		System.out.println(sysConfigMapper.selectByPrimaryKey("123213"));
	}
	
}
