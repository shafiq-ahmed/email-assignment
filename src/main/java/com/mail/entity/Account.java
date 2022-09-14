package com.mail.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account_table2")
public class Account {
	
	
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private String password;
	@OneToOne
	private Image image;
	@OneToMany(mappedBy = "receiver")
	private List<Mail> receivedMails=new ArrayList<>();
	@OneToMany(mappedBy = "sender")
	private List<Mail> sentMails=new ArrayList<>();
	
	public List<Mail> getSentMails() {
		return sentMails;
	}
	public void setSentMails(List<Mail> sentMails) {
		this.sentMails = sentMails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public List<Mail> getReceivedMails() {
		return receivedMails;
	}
	public void setReceivedMails(List<Mail> mails) {
		this.receivedMails = mails;
	}
	

}
