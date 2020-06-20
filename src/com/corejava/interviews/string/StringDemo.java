package com.corejava.interviews.string;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * intern(), return interned string
		 */
		String s1 = "test"; 
		String s2 = "test";
		String s3 = new String("test");
		String s4 = s2.intern();
		System.out.println(s1==s2); // true
		System.out.println(s1.intern() == s2.intern()); // true
		//s1 and s2 point to same content pool, but having different reference 
		System.out.println(s1==s3); // false
		System.out.println(s2==s4); // true
		System.out.println(s2.intern()==s4.intern()); //content compare
		System.out.println(s1.hashCode() + " ; "+s2.hashCode()+" ; "+s3.hashCode());
	}

}
