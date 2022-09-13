package com.mail.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_table")
public class Account {
	
	private String name;
	@Id
	private String accountId;
	private String password;
	private String ImageId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImageId() {
		return ImageId;
	}
	public void setImageId(String imageId) {
		ImageId = imageId;
	}
	

}
