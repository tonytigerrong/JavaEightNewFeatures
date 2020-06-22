package com.corejava.interviews.ploymorphism;

public class Demo {

	public static void main(String[] args) {
		/**
		 * upcasting for class
		 * class member not upcasting
		 * 
		 * bike is Splendor, so bike.get is Splendor.get()
		 * bike.speedlimit is 14.00
		 */
		Bike bike = new Splendor();
		System.out.println(bike.get());  //28.00
		System.out.println(bike.speedlimit); // 14.00

	}

}

class Bike{
	public double speedlimit = 14.00;
	public String get(){
		return "I'm Bike, my Speedlimit is "+String.valueOf(this.speedlimit);
	}
}
class Splendor extends Bike{
	public double speedlimit = 28.00;
	public String get(){
		return "I'm Splendor, my Speedlimit is "+String.valueOf(this.speedlimit);
	}
}