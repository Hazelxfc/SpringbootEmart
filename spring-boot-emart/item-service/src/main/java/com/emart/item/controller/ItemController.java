package com.emart.item.controller;

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

import com.emart.item.entity.Item;
import com.emart.item.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	/**
	 * get all items
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findall")
	@ResponseBody
	public List<Item> findAll() {
		return itemService.findAll();
	}

	/**
	 * Get item by item name
	 * 
	 * @param itemName
	 * @return
	 */
	@GetMapping("/search-by-item-name/{itemName}")
	@ResponseBody
	public Item searchItemsByItemName(@PathVariable String itemName) {
		return itemService.findByitem_name(itemName);
	}

	/**
	 * get Item by item id
	 * 
	 * @param iteam_id
	 * @return
	 */
	@GetMapping("/search-by-item-id/{iteam_id}")
	@ResponseBody
	public Item findById(@PathVariable Long iteam_id) {
		Item item = itemService.findById(iteam_id);
		return item;
	}

	/**
	 * Get item by category
	 * 
	 * @param category
	 * @return
	 */
	@GetMapping("/search-by-category-id/{category}")
	@ResponseBody
	public List<Item> searchItemsByCategory(@PathVariable int category) {
		return itemService.findByCategoryid(category);
	}

	/**
	 * create new item
	 * 
	 * @param item
	 * @return
	 */
	@PostMapping("/add")
	public String save(@RequestBody Item item) {
		itemService.save(item);
		return "saveSuccess";
	}

	/**
	 * edit an item
	 * 
	 * @param item
	 * @return
	 */
	@PutMapping("/edit-by-item-id")
	public String update(@RequestBody Item item) {
		itemService.update(item);
		return "updateSuccess";
	}

	/**
	 * delete item
	 * 
	 * @param iteam_id
	 * @return
	 */
	@DeleteMapping("/delete/{iteam_id}")
	public String delete(@PathVariable Long iteam_id) {
		itemService.delete(iteam_id);
		return "deleteSuccess";
	}
}
