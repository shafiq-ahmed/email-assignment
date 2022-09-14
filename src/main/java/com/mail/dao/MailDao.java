package com.mail.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mail.entity.Mail;

public interface MailDao extends JpaRepository<Mail, Integer>{

}
