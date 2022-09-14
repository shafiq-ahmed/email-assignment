package com.mail.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.dao.AccountDao;
import com.mail.dao.ImageDao;
import com.mail.entity.Account;
import com.mail.entity.Image;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Value("${project.image}")
	private String path;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ImageDao imageDao;
	
	
	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.save(account);
		
		
	}
	@Override
	public Account getAccountObject(String accountString, MultipartFile image) {
		// TODO Auto-generated method stub
		Account account= new Account();
		
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			account = objectMapper.readValue(accountString, Account.class);
		} catch (IOException e) {
			System.out.printf("Error maping account object", e.toString());
		}
		System.out.println(account.getName()+" "+account.getPassword());
		
		account.setImage(storeImage(image));
		return account;
	}
	
	public Image storeImage(MultipartFile image) {
		//Image image= new Image();
		
		
		String name=image.getOriginalFilename();
		String randomId=UUID.randomUUID().toString();
		String fileName=randomId.concat(name.substring(name.lastIndexOf(".")));
		String filePath=path+File.separator+fileName;
		
		
		File file= new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		
		try {
			Files.copy(image.getInputStream(), Paths.get(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.printf("Error storing image", e.toString());
		}
		
		Image imageEntity=new Image();
		imageEntity.setFilePath(filePath);
		imageDao.save(imageEntity);
		return imageEntity;
	}
	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return accountDao.getReferenceById(Integer.parseInt(id));
		
	}

}
