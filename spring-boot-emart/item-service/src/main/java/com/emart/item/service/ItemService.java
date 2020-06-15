package com.emart.item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emart.item.entity.Item;

@Service
public interface ItemService {

	// 根据id查询
	Item findById(Long id);

	Item findByitem_name(String name);

	List<Item> findByCategoryid(int category);

	// 查询全部
	List<Item> findAll();

	// 保存
	void save(Item item);

	// 更新
	void update(Item item);

	// 删除
	void delete(Long id);

}