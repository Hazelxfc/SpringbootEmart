package com.emart.order.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.emart.order.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

	/**
	 * Repository interface method name naming query
	 *
	 */

	/**
	 * update order state
	 * 
	 * @param state
	 * @param id
	 */
	@Modifying
	@Transactional
	@Query(value = "update transaction o set o.transaction_state='paied' where o.transaction_id='2'", nativeQuery = true)
	void updateOrderState(Long id, String state);

	/**
	 * search for user's order by user id
	 * 
	 * @param userId
	 * @return
	 */
	List<Order> findByUserid(String userId);

}
