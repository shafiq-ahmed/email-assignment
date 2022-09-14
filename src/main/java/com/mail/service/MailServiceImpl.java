package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.dao.MailDao;
import com.mail.entity.Mail;
@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	private MailDao mailDao;

	@Override
	public void sendMail(Mail mail) {
		// TODO Auto-generated method stub
		mailDao.save(mail);
		
	}

}
