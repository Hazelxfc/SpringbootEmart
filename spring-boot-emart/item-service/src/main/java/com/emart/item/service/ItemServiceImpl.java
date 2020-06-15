package com.emart.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.item.dao.ItemDao;
import com.emart.item.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Override
	public Item findById(Long id) {
		Optional<Item> item = itemDao.findById(id);
		if (item != null && item.isPresent()) {
			return item.get();
		}
		return null;
	}

	@Override
	public Item findByitem_name(String name) {
		return itemDao.findByitem_name(name);
	}

	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
	public void save(Item item) {
		itemDao.save(item);
	}

	@Override
	public void update(Item item) {
		itemDao.save(item);
	}

	@Override
	public void delete(Long id) {
		itemDao.deleteById(id);
	}

	@Override
	public List<Item> findByCategoryid(int category) {
		// TODO Auto-generated method stub
		return itemDao.findByCategoryid(category);
	}

}