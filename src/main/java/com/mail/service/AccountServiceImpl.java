package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.dao.AccountDao;
import com.mail.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.save(account);
		
	}

}
