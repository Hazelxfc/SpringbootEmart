package com.emart.order.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.emart.order.entity.Order;
import com.emart.order.entity.PurchaseHistory;

@Service
public interface PurchaseHistoryService {
	/**
	 * get history by history id
	 * 
	 * @param id
	 * @return
	 */
	PurchaseHistory findByHisid(Long id);

	/**
	 * get PachaseHistory list
	 * 
	 * @return
	 */
	List<PurchaseHistory> findAll();

	/**
	 * delete PachaseHistory history id
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * search for user's pachase history
	 *
	 * @param request
	 * @return
	 */
	List<Order> findUserPachaseHistory(HttpServletRequest request, String userId);

	void save(PurchaseHistory his);
}