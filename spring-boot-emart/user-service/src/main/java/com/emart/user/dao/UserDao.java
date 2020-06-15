package com.emart.user.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emart.user.entity.User;

public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	/**
	 * Repository interface method name naming query
	 *
	 */

	@Modifying
	@Transactional
	@Query(value = "update user u set u.active=false where u.user_id='009700'", nativeQuery = true)
	public void blockUser(@Param("userId") Long userId);

	@Modifying
	@Transactional
	@Query(value = "update user u set u.active=true where u.user_id=?", nativeQuery = true)
	public void unblockUser(@Param("userId") Long userId);

	List<User> findByUsername(String name);

	User findByUseridAndUsername(Long userid, String name);

	User findByUserid(Long userId);

}
