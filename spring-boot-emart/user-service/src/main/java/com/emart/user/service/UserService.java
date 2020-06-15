package com.emart.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emart.user.entity.User;

@Service
public interface UserService {

	/**
	 * search user by id
	 * 
	 * @param id
	 * @return
	 */
	User findByUserid(Long id);

	/**
	 * search user by name
	 * 
	 * @param name
	 * @return
	 */
	List<User> findByUsername(String name);

	/**
	 * list all users
	 * 
	 * @return
	 */
	List<User> findAll();

	/**
	 * block user
	 * 
	 * @param id
	 */
	void blockUser(Long id);

	/**
	 * unblock user
	 * 
	 * @param id
	 */
	void unblockUser(Long id);

	/**
	 * save a new user
	 * 
	 * @param user
	 * @return
	 */
	User save(User user);

	/**
	 * edit user info
	 * 
	 * @param user
	 */
	void update(User user);

	/**
	 * delete user
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * check login
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User checkLogin(String username, String password, Long userid);

}