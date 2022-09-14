package com.mail.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mail.entity.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

}
