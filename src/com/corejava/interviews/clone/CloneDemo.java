package com.corejava.interviews.clone;

public class CloneDemo {
	
	public static void main(String[] args){
		Driver driver = new Driver("Tony");
		Car car1 = new Car("car1", 12.23,driver);
		Car car2 = null;
		try {
			 car2 = (Car) car1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%s%n%s%n", car1,car2);
		/**
		 * primitive value copied when clone
		 */
		car2.setPrice(12.22); // for primitive attribute, cloneable is copy value to new one, so car1's price(primitive) change only effect itself
//		car2.setDriver(new Driver("David")); //will not effect car2, since we change the reference of driver of car2
		/**
		 * object reference copied when clone
		 * this means shallow clone
		 */
		car2.getDriver().setName("David"); //will affect both car1 and car2
		System.out.printf("%s%n%s%n", car1,car2);
	}
}
