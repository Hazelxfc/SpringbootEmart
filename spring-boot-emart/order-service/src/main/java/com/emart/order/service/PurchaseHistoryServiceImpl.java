package com.emart.order.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.order.dao.PurchaseHistoryDao;
import com.emart.order.entity.Order;
import com.emart.order.entity.PurchaseHistory;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

	@Autowired
	private PurchaseHistoryDao pachaseHisDao;

	@Override
	public PurchaseHistory findByHisid(Long id) {
		Optional<PurchaseHistory> history = pachaseHisDao.findById(id);
		if (history != null && history.isPresent()) {
			return history.get();
		}
		return null;
	}

	@Override
	public List<PurchaseHistory> findAll() {
		return pachaseHisDao.findAll();
	}

	@Override
	public void delete(Long id) {
		pachaseHisDao.deleteById(id);
	}

	@Override
	public List<Order> findUserPachaseHistory(HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		return pachaseHisDao.findByUserid(userId);
	}

	@Override
	public void save(PurchaseHistory his) {
		pachaseHisDao.save(his);

	}

}