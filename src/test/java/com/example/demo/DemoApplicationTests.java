package com.example.demo;

import com.example.demo.admin.dao.UserMapper;
import com.example.demo.admin.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.demo.*.dao")
public class DemoApplicationTests {
	@Autowired
	UserMapper userMapper;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setId(6);
		user.setName("张三");
		user.setPassword("123456");
		user.setSalt("654321");
		user.setState((byte)0);
		user.setUsername("zs");
		userMapper.insert(user);
	}

}
