package com.emart.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key generation strategy

	@Column(name = "iteam_id")
	private Long iteamid;

	@Column(name = "category_id")
	private int categoryid;

	@Column(name = "subcategory_id")
	private int subcategoryid;

	@Column(name = "price")
	private int price;

	@Column(name = "item_name")
	private String itemname;

	@Column(name = "description")
	private String description;

	@Column(name = "stock_number")
	private int stocknumber;

	@Column(name = "remarks")
	private String remarks;

	public Long getIteamid() {
		return iteamid;
	}

	public void setIteamid(Long iteamid) {
		this.iteamid = iteamid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(int subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStocknumber() {
		return stocknumber;
	}

	public void setStocknumber(int stocknumber) {
		this.stocknumber = stocknumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}