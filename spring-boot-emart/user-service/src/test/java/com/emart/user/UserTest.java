package com.emart.user;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emart.user.entity.User;
import com.emart.user.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserService UserService;

	@Before(value = "")
	public void before() {
		User user = new User();
		user.setUserid(1L);
		user.setUsername("lee");
		user.setType(1);
		user.setPhonenumber("123457890");
		user.setPassword("xxxxxxxx");
		user.setActive(false);
		user.setAdress("sichuanchengdu");
		UserService.save(user);
	}

	@Test
	public void testAdd() {
		User user = new User();
		user.setUserid(2L);
		user.setUsername("Miya");
		user.setType(2);
		user.setPhonenumber("7865432190");
		user.setPassword("xxxxxxxx");
		user.setActive(true);
		user.setAdress("yunnanqujing");
		UserService.save(user);
	}

	@Test
	public void testFindAll() {
		UserService.findAll();
	}

	@Test
	public void testFindOne() {
		UserService.findByUserid(1L);
	}

	@Test
	public void testFindUserByName() {
		UserService.findByUsername("Miya");
	}

	@Test
	public void testUnblockUser() {
		UserService.unblockUser(2L);
	}

	@Test
	public void testBlockUser() {
		UserService.blockUser(1L);
	}

	@Test
	public void testUpdate() {
		User user = UserService.findByUserid(2L);
		user.setEmail("Miya@cn.hhh.com");
		UserService.update(user);
	}

}