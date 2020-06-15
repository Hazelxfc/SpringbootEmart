package com.emart.auth.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emart.auth.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

	/**
	 * Repository interface method name naming query
	 *
	 */

	public Optional<UserEntity> findById(Integer id);

	public UserEntity findUserByUserName(String userName);

	@Modifying
	@Transactional
	@Query(value = "update s_user u set u.active=true where u.id=?", nativeQuery = true)
	public int activeUser(@Param("userId") Integer userId);

}
