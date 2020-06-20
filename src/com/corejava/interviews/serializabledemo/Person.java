package com.corejava.interviews.serializabledemo;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private int age;
	private Address address;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String toString(){
		return "[name: "+this.name+", age: "+this.age+", address:"+address.getCity()+" ]";
	}
	
}
