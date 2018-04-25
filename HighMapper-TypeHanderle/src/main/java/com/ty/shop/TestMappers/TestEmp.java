package com.ty.shop.TestMappers;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ty.shop.entities.Address;
import com.ty.shop.entities.Employee;
import com.ty.shop.entities.SeasonEnum;
import com.ty.shop.entities.User;
import com.ty.shop.mappers.EmployeeMapper;
import com.ty.shop.mappers.UserMapper;
import com.ty.shop.service.UserService;

import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * @Description: 测试类
 * @ClassName: TestEmp.java
 * @version: v1.0.0
 * @author:
 * @date: 2018年1月1日 下午4:18:22
 */
public class TestEmp {
	private UserService userService;
	{
		userService = new ClassPathXmlApplicationContext("applicationContext.xml").getBean(UserService.class);
	}
	@Test
	public void savaOneUser() {
		userService.saveUser(new User(null, "tom03", new Address("四川", "成都", "中和街道"), SeasonEnum.AUTUMN));
	}
	
	@Test
	public void selectUser() {
		List<User> users = userService.selectAll();
		System.out.println(users);
	}
}
