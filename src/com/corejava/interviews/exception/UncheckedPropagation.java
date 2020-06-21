package com.corejava.interviews.exception;

import java.io.IOException;

public class UncheckedPropagation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UncheckedPropagation demo = new UncheckedPropagation();
		try{
			demo.a();
		}catch(Exception e){
			System.out.println("unchecked exception propagation and catch");
		}
		
	}
	
	private static void a(){
		b();
	}
	private static void b(){
		c();
	}
	private static void c(){
		/**
		 * no need to manully maintain exception chain for each function signature
		 * Unchecked exception will popped up (properaged)
		 */
		int i = 10/0; //unchecked exception propagation 
	}
	
	

}
