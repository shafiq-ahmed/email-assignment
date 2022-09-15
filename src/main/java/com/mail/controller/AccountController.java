package com.mail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		
		Account accountObject=accountService.getAccountObject(account, image);
		accountService.addAccount(accountObject);
		return "Account created";
	}
	@PostMapping("/sentMail")
	public List<String> viewSentMail(@RequestParam("senderId") String senderId) {
		 
		 List<String> sentMails=accountService.getSentMails(Integer.parseInt(senderId));
		 
		 return sentMails;
	}
	
	@PostMapping("/gotMail")
	public List<String> viewReceivedMail(@RequestParam("receiverId") String receiverId) {
		 
		 List<String> receivedMails=accountService.getReceivedMails(Integer.parseInt(receiverId));
		 
		 return receivedMails;
	}
	
	@GetMapping("/viewDetails/{accountId}")
	public String viewaccountDetail(@PathVariable("accountId")int accountId) {
		
		
		return accountService.getAccountDetails(accountId);
		
	}
	@PostMapping("/update")
	public String updateAccount(@RequestPart("account") String account, @RequestPart("image") MultipartFile image){
		
		
		Account updatedAccount=accountService.getAccountObject(account, image);
		if(updatedAccount!=null) {
			accountService.updateAccount(updatedAccount);
			return "Account updated";
		}else return "Account update failed";
		
	}
	
	@PostMapping("/delete")
	public String deleteAccount(@RequestParam("accountId") int accountId, @RequestParam("password") String password) {
		 
		 if(accountService.deleteAccount(accountId, password)) {
			 return "Account deleted";
		 }
		 
		 return "Password is incorrect";
	}
	
}
