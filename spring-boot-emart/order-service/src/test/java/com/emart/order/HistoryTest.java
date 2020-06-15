package com.emart.order;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emart.order.entity.PurchaseHistory;
import com.emart.order.service.PurchaseHistoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryTest {

	@Autowired
	private PurchaseHistoryService purchaseHistoryService;

	@Before(value = "")
	public void before() {
		PurchaseHistory his = new PurchaseHistory();
		his.setHisid(1L);
		his.setItemid(1);
		his.setTransactionid("1234");
		his.setUserid("207745");
		his.setDate("2019-02-01");
		purchaseHistoryService.save(his);
	}

	@Test
	public void testAdd() {
		PurchaseHistory his = new PurchaseHistory();
		his.setHisid(2L);
		his.setItemid(2);
		his.setTransactionid("12345");
		his.setUserid("009700");
		his.setDate("2019-02-01");
		purchaseHistoryService.save(his);
	}

	@Test
	public void testFindAll() {
		purchaseHistoryService.findAll();
	}

	@Test
	public void testFindOne() {
		purchaseHistoryService.findByHisid(1L);
	}

	/*
	 * @Test public void testFindUserPachaseHistory() { HttpServletRequest request =
	 * null; purchaseHistoryService.findUserPachaseHistory(request, "009700"); }
	 * 
	 * @Test public void testDelete() { purchaseHistoryService.delete(2L); }
	 */
}