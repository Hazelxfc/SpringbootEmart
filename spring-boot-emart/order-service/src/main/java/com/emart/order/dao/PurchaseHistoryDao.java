package com.emart.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.emart.order.entity.Order;
import com.emart.order.entity.PurchaseHistory;

public interface PurchaseHistoryDao
		extends JpaRepository<PurchaseHistory, Long>, JpaSpecificationExecutor<PurchaseHistory> {

	/**
	 * Repository interface method name naming query
	 *
	 */

	/**
	 * search for user's pachase history by user id
	 * 
	 * @param userId
	 * @return
	 */
	List<Order> findByUserid(String userId);
}
