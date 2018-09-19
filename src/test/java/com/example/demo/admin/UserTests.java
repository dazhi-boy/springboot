package com.example.demo.admin;

import com.example.demo.admin.entity.User;
import com.example.demo.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.demo.*.dao")
public class UserTests {
	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		List<User> users = userService.list();
		for (User user:users){
			System.out.println(user.toString());
		}
	}

	@Test
	public void insertTest() {
		User user = new User();
		user.setId(8);
		user.setName("张三");
		user.setPassword("123456");
		user.setSalt("654321");
		user.setState((byte)0);
		user.setUsername("zs");
		int result = userService.insert(user);
		System.out.println(result);
	}
}
