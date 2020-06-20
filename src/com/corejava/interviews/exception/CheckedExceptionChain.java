package com.corejava.interviews.exception;

import java.io.IOException;

public class CheckedExceptionChain {
	public static void main(String[] args) throws IOException{
		CheckedExceptionChain demo = new CheckedExceptionChain();
		demo.A();
	}
	private static void A() throws IOException{
		B();
	}
	private static void B() throws IOException{
		C();
	}
	private static void C() throws IOException{
		/*
		 * checked exception are not propagated, 
		 * compiler force use to either try/catch it 
		 * or create a exception handler chain by add "throws excption" in function signature chain
		 */
		throw  new IOException(); 
		
	}
}
