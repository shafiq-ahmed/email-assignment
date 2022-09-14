package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mail.entity.Account;
import com.mail.entity.Mail;
import com.mail.service.AccountService;
import com.mail.service.MailService;

@RestController
public class MailController {
	
	@Autowired
	private MailService mailService;
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestParam(value = "senderId", required=true) String senderId,@RequestParam(value = "receiverId", required=true) String receiverId  ,@RequestBody Mail mail) {
		
		//mailService.sendMail(mail);
		Account sender=accountService.findById(senderId);
		Account receiver=accountService.findById(receiverId);
		if(receiver!=null && sender!=null) {
			mail.setReceiver(receiver);
			mail.setSender(sender);
			mailService.sendMail(mail);
			return "Mail sent";
		}else {
			return "Account not found";
		}
		}
		
	}
	
	


