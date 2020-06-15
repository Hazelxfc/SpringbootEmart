package com.emart.item.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emart.item.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

	/*
	 * Item findByitem_name(String name);
	 */

	List<Item> findByCategoryid(int category);

	/**
	 * Repository接口方法名称命名查询
	 *
	 */

	@Transactional
	@Query(value = "select * from Item i where i.item_name =:name", nativeQuery = true)
	public Item findByitem_name(@Param("name") String name);

}
