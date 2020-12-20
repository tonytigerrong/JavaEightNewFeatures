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
			//if any execption is propergated to this method, will print the following:
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
		
		/**
		 * Un-Checked Exception: Can be propergated up forward by throw.
		 * 		Eg. int i = 1/0; //ArithmeticException
		 */
		throw new ArithmeticException();
		
		/**
		 * Checked Exception: Can't be propergated up forward by throw,
		 *                    But if apply throws exception chain in method signature, it will be progergated.
		 * If you un-comment this line, complier should force you either of the following: 
		 * (1) add "throws IOException" in call chain, up forward
		 * (2) add "try/catch", wrap the "throw new IOException"                 
		 */
//		throw new IOException(); 
		
		
		
	}
}
