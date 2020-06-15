package com.emart.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE_HIS")
public class PurchaseHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key generation strategy
	@Column(name = "his_id")
	private Long hisid;

	@Column(name = "user_id")
	private String userid;

	@Column(name = "transaction_id")
	private String transactionid;

	@Column(name = "item_id")
	private int itemid;

	@Column(name = "date")
	private String date;

	@Column(name = "remarks")
	private String remarks;

	public Long getHisid() {
		return hisid;
	}

	public void setHisid(Long hisid) {
		this.hisid = hisid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}