package com.mail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mail.entity.Account;
import com.mail.service.AccountService;


@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/addAccount")
	public String addAccount(@RequestPart("account") String account, @RequestPart("image") MultipartFile image){
		
		System.out.println(image.getOriginalFilename());
		Account accountObject=accountService.getAccountObject(account, image);
		System.out.println(accountObject.getName()+" "+accountObject.getPassword());
		accountService.addAccount(accountObject);
		return "Account created";
	}
	@PostMapping("/sentMail")
	public List<String> viewSentMail(@RequestParam("senderId") String senderId) {
		 
		 List<String> sentMails=accountService.getSentMails(Integer.parseInt(senderId));
		 
		 return sentMails;
	}
}
