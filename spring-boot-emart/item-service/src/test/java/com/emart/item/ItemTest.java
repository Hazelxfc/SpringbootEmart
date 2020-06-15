package com.emart.item;

import org.aspectj.lang.annotation.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emart.item.entity.Item;
import com.emart.item.service.ItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class ItemTest {

	@Autowired
	private ItemService itemService;

	@Before(value = "")
	public void before() {
		Item item = new Item();
		item.setCategoryid(1);
		item.setItemname("pen");
		item.setCategoryid(1);
		item.setPrice(5);
		item.setStocknumber(20);
		item.setSubcategoryid(1);
		item.setDescription("buy it!");
		itemService.save(item);

		item = new Item();
		item.setCategoryid(1);
		item.setItemname("toy");
		item.setSubcategoryid(1);
		item.setPrice(50);
		item.setStocknumber(200);
		item.setDescription("buy it!!");
		itemService.save(item);
	}

	@Test
	public void testAdd() {
		Item item = new Item();
		item.setCategoryid(1);
		item.setItemname("toy baby");
		item.setPrice(30);
		item.setStocknumber(200);
		item.setSubcategoryid(2);
		item.setDescription("lovely toy baby");
		itemService.save(item);
	}

	@Test
	public void testFindAll() {
		itemService.findAll();
	}

	@Test
	public void testFindOne() {
		itemService.findById(1L);
	}

	@Test
	public void testFindByCate() {
		itemService.findByCategoryid(1);
	}

	@Test
	public void testFindByName() {
		itemService.findByitem_name("toy");
	}

	@Test
	public void testUpdate() {
		Item item = itemService.findById(1L);
		item.setPrice(23);
		itemService.update(item);
	}

}
