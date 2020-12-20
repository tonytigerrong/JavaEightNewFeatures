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
		/*
		 * Change the referent of car2's driver to "new Driver("David")
		 * So, only effect car2 only, will not effect car1, since car1's driver still refer to original Driver("Tony")
		 */
		//car2.setDriver(new Driver("David")); //will not effect car2, since we change the reference of driver of car2
		/**
		 * object reference copied when clone
		 * this means shallow clone.
		 * will affect both car1 and car2, since shallow clone car1 to car2, both car1 and 2's driver refer to same Driver object,
		 * method getDriver will return car2's driver reference which both 1 and 2 point to
		 * 
		 */
		car2.getDriver().setName("David"); // 
		System.out.printf("%s%n%s%n", car1,car2);
	}
}
