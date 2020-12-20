package com.corejava.interviews.string;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * intern():
		 * 		return interned string
		 * 
		 * == : 
		 * 		operator, compare the reference or memory location of object in HEAP
		 * 		Whether they point to the same (Heap) location or not 
		 * 
		 * equals:
		 * 		For any object x, x.equals(x) should return true.
		 *		For any two object x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
		 *		For multiple objects x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
		 *		Multiple invocations of x.equals(y) should return same result, unless any of the object properties is modified that is being used in the equals() method implementation.
		 *		Object class equals() method implementation returns true only when both the references are pointing to same object.
		 * 
		 * hashCode:
		 * 		Multiple invocations of hashCode() should return the same integer value, unless the object property is modified that is being used in the equals() method.
		 *		An object hash code value can change in multiple executions of the same application.
		 *		If two objects are equal according to equals() method, then their hash code must be same.
		 *		If two objects are unequal according to equals() method, their hash code are not required to be different. Their hash code value may or may-not be equal.
		 */
		String s1 = "test"; // create a string pool in heap, contains 'test', pass the reference to s1
		String s2 = "test"; // search, there is string pool of 'test', pass reference of the string pool to s2
		String s3 = new String("test"); // create another string pool contains 'test', pass the reference to s3
		String s4 = s2.intern();
		System.out.println(s1==s2); // true
		System.out.println(s1.intern() == s2.intern()); // true
		//s1 and s2 point to same content pool, but having different reference 
		System.out.println(s1==s3); // false
		System.out.println(s2==s4); // true
		System.out.println(s2.intern()==s4.intern()); //content compare
		
		// content compare
		System.out.println(s1.hashCode() + " ; "+s2.hashCode()+" ; "+s3.hashCode());
	}

}
