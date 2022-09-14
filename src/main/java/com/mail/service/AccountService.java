package com.mail.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mail.entity.Account;

public interface AccountService {
		
	public void addAccount(Account account);
	public Account getAccountObject(String accountString, MultipartFile image);
	public Account findById(String id);
	public List<String> getSentMails(int id);
}
