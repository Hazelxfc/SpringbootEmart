package com.emart.order.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.emart.order.entity.Order;

@Service
public interface OrderService {
	/**
	 * get order by order id
	 * 
	 * @param id
	 * @return
	 */
	Order findById(Long id);

	/**
	 * get orser list
	 * 
	 * @return
	 */
	List<Order> findAll();

	/**
	 * create new Order
	 * 
	 * @param order
	 */
	void save(Order order);

	/**
	 * update order
	 * 
	 * @param order
	 */

	void update(Order order);

	/**
	 * delete order by order id
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * search for user's order
	 *
	 * @param request
	 * @return
	 */
	List<Order> findUserOrder(HttpServletRequest request, String userId);

	/**
	 * update order state
	 *
	 * @param id
	 * @param status
	 */
	void updateOrderState(Long id, String status);

}