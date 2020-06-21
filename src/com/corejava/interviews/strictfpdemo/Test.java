package com.corejava.interviews.strictfpdemo;

public class Test {
/**
 * strictfp : since precision difference in every platform, 
 *            strictfp will allow you get same result
 * @param args
 */
	public static void main(String[] args) {
		Test t = new Test();
		double d = t.adding(0.000000001d, 0.0000000002d);
		System.out.println(d);
	}
	
	public strictfp double adding(double d1, double d2){
		return d1+d2;
	}

}
