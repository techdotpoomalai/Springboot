package com.springboot.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {
	
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rolename;
	
	
	public Long getRole_id() {
		return id;
	}
	public void setRole_id(Long role_id) {
		this.id = role_id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Roles(Long role_id, String rolename) {
		super();
		this.id = role_id;
		this.rolename = rolename;
	}
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
