package com.wo.rest.bean;

public class Contact {
	long id;
	String firstName;
	String lastName;
	String mobile;
	
	public Contact() {
		super();
	}
	
	public Contact(long id, String firstName, String lastName, String mobile) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName= lastName;
		this.mobile= mobile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
