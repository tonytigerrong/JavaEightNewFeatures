package com.corejava.interviews.overloadride;

public class ParentClass {

	public String needOverload(String str1, int i1){
		return "ParentClass: needOverload";
	}
	// can't just change return for overloading
//	public void needOverload(String s1, String s2){
//		
//	}
	
	/*
	 *  override function without exception
	 *  we can only add unchecked exception in children function which override the parent one
	 */
	public String needOverriding(){
		return "";
	}
	public String needOverridingWithException() throws RuntimeException {
		return "";
	}
}
