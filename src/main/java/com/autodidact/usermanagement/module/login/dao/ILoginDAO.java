package com.autodidact.usermanagement.module.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autodidact.usermanagement.module.login.entity.LoginDAOEntity;

@Repository
public interface ILoginDAO extends JpaRepository<LoginDAOEntity, Integer> {

}
