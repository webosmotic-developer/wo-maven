package com.wo.rest.bean;

public class Contact {
	int id;
	String firstName;
	String lastName;
	String mobile;
	
	public Contact() {
		super();
	}
	
	public Contact(int i, String firstName, String lastName, String mobile) {
		super();
		this.id = i;
		this.firstName = firstName;
		this.lastName= lastName;
		this.mobile= mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
