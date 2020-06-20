package com.corejava.interviews.clone;

public class Car implements Cloneable{
	
	private String name;
	private double price;
	private Driver driver;
	Car(String name,double price,Driver driver){
		this.name = name;
		this.price = price;
		this.driver = driver;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
	
	public String toString(){
		return "Car-["+this.getName()+", "+this.getPrice()+", "+driver.getName()+"]";
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
}
