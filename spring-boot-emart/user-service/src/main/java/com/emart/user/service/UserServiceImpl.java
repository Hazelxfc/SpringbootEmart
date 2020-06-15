package com.emart.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.user.dao.UserDao;
import com.emart.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByUserid(Long userId) {
		Optional<User> user = Optional.ofNullable(userDao.findByUserid(userId));
		if (user != null && user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User save(User user) {
		userDao.save(user);
		return userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}

	@Override
	public void delete(Long userId) {
		userDao.deleteById(userId);
	}

	@Override
	public void blockUser(Long userId) {
		userDao.blockUser(userId);
	}

	@Override
	public void unblockUser(Long userId) {
		userDao.unblockUser(userId);

	}

	@Override
	public List<User> findByUsername(String name) {
		return userDao.findByUsername(name);
	}

	@Override
	public User checkLogin(String username, String password, Long userid) {
		return userDao.findByUseridAndUsername(userid, username);
	}

}