package com.mail.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mail.entity.Account;

public interface AccountDao extends JpaRepository<Account, String> {

}
