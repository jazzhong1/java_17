package com.iu.member;

import java.sql.*;

public abstract class MemberDTO {
	private String id;
	private String name;
	private int age;
	private String mail;
	private String birday;
	private String jab;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBirday() {
		return birday;
	}
	public void setBirday(String date) {
		this.birday = date;
	}
	public String getJab() {
		return jab;
	}
	public void setJab(String jab) {
		this.jab = jab;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
