package com.xbf.domain;

import java.sql.Date;

//客户类
public class Customer {
	private int id;
	private String name;
	private String gender;
	private Date birthday;
	private String phone;
	private String email;
	private String hobbies;
	private String type;
	private String address;
	private String description;

	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getGender() {
		return gender;
	}

	public synchronized void setGender(String gender) {
		this.gender = gender;
	}

	public synchronized Date getBirthday() {
		return birthday;
	}

	public synchronized void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public synchronized String getPhone() {
		return phone;
	}

	public synchronized void setPhone(String phone) {
		this.phone = phone;
	}

	public synchronized String getEmail() {
		return email;
	}

	public synchronized void setEmail(String email) {
		this.email = email;
	}

	public synchronized String getHobbies() {
		return hobbies;
	}

	public synchronized void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public synchronized String getType() {
		return type;
	}

	public synchronized void setType(String type) {
		this.type = type;
	}

	public synchronized String getAddress() {
		return address;
	}

	public synchronized void setAddress(String address) {
		this.address = address;
	}

	public synchronized String getDescription() {
		return description;
	}

	public synchronized void setDescription(String description) {
		this.description = description;
	}

}
