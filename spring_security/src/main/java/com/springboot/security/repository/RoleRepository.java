package com.springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.security.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long>{

}
