package com.mkyong.core;

import java.io.Serializable;

public class Person implements Serializable{

	public String name;
	public String lastName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
