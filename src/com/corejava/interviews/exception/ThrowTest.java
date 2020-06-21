package com.corejava.interviews.exception;

import java.io.IOException;

public class ThrowTest {
/**
 * Throw: Checked exception can NOT be propergated by throw
 * Throws: Checked exception can be propergated by throws
 * @param args
 */
	public static void main(String[] args) {
		
		try{
			a();
		}catch(Exception e){
			System.out.println("exception catched");
			e.printStackTrace(); 
		}
	}

	public static void a(){
		b();
	}
	public static void b(){
		c();
	}
	public static void c() throws ArithmeticException{
		// unchecked exception can be propergated up forward.
//		int i = 1/0; //ArithmeticException
		throw new ArithmeticException();
		/**
		 * Throw keyword 
		 * if checked exception by throw will not propergated.
		 */
//		try{
//			throw new IOException(); // throw a checked exception
//		}catch(IOException e){
//			e.printStackTrace();
//		}
		
	}
}
