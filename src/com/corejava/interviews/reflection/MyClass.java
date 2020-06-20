package com.corejava.interviews.reflection;

public class MyClass {
	private int age;
	private String name;
	
	private String lastName;
	private void setLastName(String lastName){ // we want to access the private method outside class !! reflection !!
		this.lastName = lastName;
	}
	
	MyClass(int age, String name, String lastName){
		this.age = age;
		this.name = name;
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return "[name: "+this.name+"; lastname: "+this.lastName+" ; age: "+this.age+"]";
	}
	
}
