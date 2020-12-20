package com.corejava.interviews.overloadride;

import java.io.IOException;

public class ChildClass extends ParentClass {

	/**
	 * (1) if parent method don't have any exception declaration in signature
	 * 		override method can either declarer un-checked exception or no exception
	 * (2) if parent method have exception declaration in signature
	 * 		override method can only declare eight same level or sub level exception of parent
	 */
	@Override
	public String needOverriding() 
			// throws IOException // can't declare checked exception if parent function without any exception declaration
		throws NumberFormatException // can only declare unchecked exception in child function
	{
		return "1";
	}
	
	@Override
	public String needOverridingWithException()
			throws RuntimeException // if parent function have exception, you can only declare same or sub exception in child function
			//,Exception  // Exception if parent of runtimeexcetion, can't declare here
			, ArithmeticException // is child exceptin of runtimeexception, can declare here
	
	{
		return "";
	}
}
