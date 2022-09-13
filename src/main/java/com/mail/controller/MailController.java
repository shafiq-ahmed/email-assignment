package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.entity.Mail;
import com.mail.service.MailService;

@RestController
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody Mail mail) {
		
		mailService.sendMail(mail);
		return "Mail sent";
	}
	
	

}
