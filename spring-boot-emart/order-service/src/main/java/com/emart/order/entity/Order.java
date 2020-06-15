package com.emart.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key generation strategy
	@Column(name = "transaction_id")
	private Long transactionid;

	@Column(name = "user_id")
	private String userid;

	@Column(name = "user_name")
	private String username;

	@Column(name = "address")
	private String address;

	@Column(name = "user_phone")
	private String userphone;

	@Column(name = "total")
	private Long total;

	@Column(name = "transaction_state")
	private String transactionstate;

	@Column(name = "transaction_time")
	private String transactiontime;

	@Column(name = "remarks")
	private String remarks;

	public Long getTransactionId() {
		return transactionid;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionid = transactionId;
	}

	public String getUserId() {
		return userid;
	}

	public void setUserId(String userId) {
		this.userid = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserPhone() {
		return userphone;
	}

	public void setUserPhone(String userPhone) {
		this.userphone = userPhone;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getTransactionState() {
		return transactionstate;
	}

	public void setTransactionState(String transactionState) {
		this.transactionstate = transactionState;
	}

	public String getTransactionTime() {
		return transactiontime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactiontime = transactionTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}