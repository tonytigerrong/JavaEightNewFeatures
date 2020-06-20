package com.corejava.interviews.clone;

public class Driver {
	private String name;
	Driver(String name){
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Object clone() throws CloneNotSupportedException{
//		return super.clone();
//	}
	
}
