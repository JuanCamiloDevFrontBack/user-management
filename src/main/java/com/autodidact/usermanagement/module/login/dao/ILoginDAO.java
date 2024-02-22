package com.autodidact.usermanagement.module.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.autodidact.usermanagement.module.login.entity.LoginDAOEntity;

@Repository
public interface ILoginDAO extends JpaRepository<LoginDAOEntity, Integer> {

	@Query(value = "select id, email, password from login where id = 2", nativeQuery = true)
	public LoginDAOEntity searchByUserFirst();
	
	@Query("from LoginDAOEntity ld where ld.id = :searchById")
	LoginDAOEntity searchByIdQueryJPQL(@Param("searchById") Integer searchById);

}
