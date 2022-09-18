package com.mail.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mail.entity.Account;
import com.mail.entity.Image;

public interface AccountService {
		
	public void addAccount(Account account);
	public Account getAccountObject(String accountString, MultipartFile image);
	public Account findById(String id);
	public List<String> getSentMails(int id);
	public List<String> getReceivedMails(int id);
	public String getAccountDetails(int  accountId);
	public void updateAccount(Account account);
	public boolean deleteAccount(int accountId, String password);
	public Image storeImage(MultipartFile image);
}
