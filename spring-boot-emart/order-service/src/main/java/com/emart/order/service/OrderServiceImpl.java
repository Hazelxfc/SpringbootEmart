package com.emart.order.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.order.dao.OrderDao;
import com.emart.order.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public Order findById(Long id) {
		Optional<Order> order = orderDao.findById(id);
		if (order != null && order.isPresent()) {
			return order.get();
		}
		return null;
	}

	@Override
	public List<Order> findAll() {
		return orderDao.findAll();
	}

	@Override
	public void save(Order order) {
		orderDao.save(order);
	}

	@Override
	public void update(Order order) {
		orderDao.save(order);
	}

	@Override
	public void delete(Long id) {
		orderDao.deleteById(id);
	}

	@Override
	public void updateOrderState(Long id, String status) {
		orderDao.updateOrderState(id, status);

	}

	@Override
	public List<Order> findUserOrder(HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		return orderDao.findByUserid(userId);
	}

}