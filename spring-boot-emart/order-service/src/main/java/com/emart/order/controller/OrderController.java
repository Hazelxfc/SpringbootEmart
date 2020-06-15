package com.emart.order.controller;

import java.util.List;

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

import com.emart.order.entity.Order;
import com.emart.order.entity.PurchaseHistory;
import com.emart.order.service.OrderService;
import com.emart.order.service.PurchaseHistoryService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private PurchaseHistoryService historyService;

	/**
	 * get the user order list of all orders
	 * 
	 * @return
	 */
	@GetMapping("/findall")
	@ResponseBody
	public List<Order> findAllOrders() {
		return orderService.findAll();
	}

	/**
	 * get order detail by id
	 * 
	 * @param transactionid
	 * @return
	 */
	@GetMapping("/search-by-id/{transactionid}")
	@ResponseBody
	public Order findOrderById(@PathVariable Long transactionid) {
		Order order = orderService.findById(transactionid);
		return order;
	}

	/**
	 * save new order
	 * 
	 * @param order
	 * @return
	 */
	@PostMapping("/add")
	public String saveOrder(@RequestBody Order order) {
		orderService.save(order);
		return "saveSuccess";
	}

	/**
	 * update order(eg.state of order)
	 * 
	 * @param order
	 * @return
	 */
	@PutMapping("/edit")
	public String updateOrder(@RequestBody Order order) {
		orderService.update(order);
		return "updateSuccess";
	}

	/**
	 * delete order
	 * 
	 * @param transactionid
	 * @return
	 */
	@DeleteMapping("/delete/{transactionid}")
	public String deleteOrder(@PathVariable Long transactionid) {
		orderService.delete(transactionid);
		return "deleteSuccess";
	}

	// pachase history:

	/**
	 * get the user pachase history list
	 * 
	 * @return
	 */
	@GetMapping("/history")
	@ResponseBody
	public List<PurchaseHistory> findAllHistory() {
		return historyService.findAll();
	}

	/**
	 * get pachase history detail by id
	 * 
	 * @param transactionid
	 * @return
	 */
	@GetMapping("/history/find-by-id/{hisId}")
	@ResponseBody
	public PurchaseHistory findHitoryById(@PathVariable Long historyId) {
		PurchaseHistory history = historyService.findByHisid(historyId);
		return history;
	}

	/**
	 * delete pachase history
	 * 
	 * @param hisId
	 * @return
	 */
	@DeleteMapping("/history/delete/{hisId}")
	public String deleteHistory(@PathVariable Long historyId) {
		historyService.delete(historyId);
		return "deleteSuccess";
	}

}
