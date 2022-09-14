package com.mail.service;

import org.springframework.web.multipart.MultipartFile;

import com.mail.entity.Account;

public interface AccountService {
		
	public void addAccount(Account account);
	public Account getAccountObject(String accountString, MultipartFile image);
	public Account findById(String id);
	public void showSentMails(int id);
}
