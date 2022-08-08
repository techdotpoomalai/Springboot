package com.springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.springboot.security.entity.User1;


@Repository
public interface UserRepository extends JpaRepository<User1, Long>{
	
	User1 findByUsername(String username);
}
