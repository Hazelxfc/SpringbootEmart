package com.emart.order;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emart.order.entity.Order;
import com.emart.order.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

	@Autowired
	private OrderService OrderService;

	@Before(value = "")
	public void before() {
		Order order = new Order();
		order.setTransactionId(1L);
		order.setTransactionState("unpay");
		order.setTransactionTime("2019-09-02");
		order.setUserId("009700");
		order.setUserName("Hazel xu");
		order.setUserPhone("18234567121");
		order.setAddress("yunnanqujing");
		order.setTotal(230L);
		OrderService.save(order);
	}

	@Test
	public void testAdd() {
		Order order = new Order();
		order.setTransactionId(2L);
		order.setTransactionState("unpay");
		order.setTransactionTime("2020-09-02");
		order.setUserId("030031");
		order.setUserName("Jelly");
		order.setUserPhone("18254367121");
		order.setAddress("sichun");
		order.setTotal(230L);
		OrderService.save(order);
	}

	@Test
	public void testFindAll() {
		OrderService.findAll();
	}

	@Test
	public void testFindOne() {
		OrderService.findById(1L);
	}

	@Test
	public void testFindUserOrder() {
		HttpServletRequest request = null;
		OrderService.findUserOrder(request, "009700");
	}

	@Test
	public void testFindByName() {
		OrderService.updateOrderState(1L, "paid");
	}

	@Test
	public void testUpdate() {
		Order order = OrderService.findById(1L);
		order.setTotal(333L);
		OrderService.update(order);
	}

}