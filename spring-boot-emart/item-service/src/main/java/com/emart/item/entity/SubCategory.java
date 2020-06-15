package com.emart.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subcategory")
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key generation strategy
	@Column(name = "subcategory_id")
	private int subcategoryId;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "subcategory_name")
	private String subcategoryName;

	@Column(name = "details")
	private String details;

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "SubCategory [subcategoryId=" + subcategoryId + ", categoryId=" + categoryId + ", subcategoryName="
				+ subcategoryName + ", details=" + details + "]";
	}

}