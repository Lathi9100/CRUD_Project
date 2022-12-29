package com.example.demo.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
@Component
public class Employee {

	@Id
	private int id;
	private String name;
	private String mail;
	
	Employee(){
		super();
	}
	Employee(int id, String name, String mail){
		super();
		this.id=id;
		this.name=name;
		this.mail=mail;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setMail(String mail) {
		this.mail=mail;
	}
	public String getMail() {
		return mail;
	}
}
