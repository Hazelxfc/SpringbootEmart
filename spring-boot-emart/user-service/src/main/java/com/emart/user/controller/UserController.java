package com.emart.user.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.user.entity.User;
import com.emart.user.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * search all user list
	 * 
	 * @return
	 */
	@GetMapping("/admin/findall")
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}

	/**
	 * search user by user id
	 * 
	 * @param userid
	 * @return
	 */
	@GetMapping("/admin/find-by-id/{userid}")
	@ResponseBody
	public User findById(@PathVariable Long userid) {
		User user = userService.findByUserid(userid);
		return user;
	}

	/**
	 * create new user
	 * 
	 * @param user
	 * @return
	 */

	@PostMapping("/admin/add")
	public String save(@RequestBody User user) {
		userService.save(user);
		return "saveSuccess";
	}

	/**
	 * edit user by user id
	 * 
	 * @param user
	 * @return
	 */
	@PutMapping("/admin/edit")
	public String update(@RequestBody User user) {
		userService.update(user);
		return "updateSuccess";
	}

	/**
	 * delete user by user id
	 * 
	 * @param userid
	 * @return
	 */
	@DeleteMapping("/admin/delete/{userid}")
	public String delete(@PathVariable Long userid) {
		userService.delete(userid);
		return "deleteSuccess";
	}

	// user
	/**
	 * login
	 *
	 * @param username
	 * @param password
	 * @throws LoginException
	 */
	@RequestMapping("/login.do")
	public void login(String username, String password, Long userid, HttpServletRequest request,
			HttpServletResponse response) throws IOException, LoginException {
		User user = userService.checkLogin(username, password, userid);
		if (user != null) {
			request.getSession().setAttribute("user", user);
		} else {
			throw new LoginException("Login failed! Incorrect password or user name.");
		}

	}

	/**
	 * register
	 * 
	 */
	@RequestMapping("/register.do")
	public void register(String username, String password, String name, String phone, String email, String addr,
			HttpServletResponse response) throws IOException {
		User user = new User();
		user.setUsername(username);
		user.setPhonenumber(phone);
		user.setPassword(password);
		user.setEmail(email);
		user.setAdress(addr);
		userService.save(user);
	}

	/**
	 * logout
	 */
	@RequestMapping("/logout.do")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
	}

	/**
	 * validate user name
	 * 
	 * @param username
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkUsername.do")
	public List<User> checkUsername(String username) {
		List<User> users = userService.findByUsername(username);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return users;
	}

}
