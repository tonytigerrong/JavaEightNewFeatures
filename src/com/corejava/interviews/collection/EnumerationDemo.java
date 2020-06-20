package com.corejava.interviews.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class EnumerationDemo {
	public static void main(String[] args){
		List<String> strList = new ArrayList<>();
		setList(strList);
		Enumeration<String> enum1 = Collections.enumeration(strList);
		while(enum1.hasMoreElements()){
			System.out.println(enum1.nextElement()); // ConcurrentModificationException occur here once collection(list) changed(insert,remove)
			/* fail-fast, if you using enumeration to traverse a collection, you can't remove element, 
			 * otherwise will get concurrentmodificationexception
			 * Enumeration don't have remove method to delete element, 
			 * fail-fast occur immediatly once source list lost an element or add an element
			 */
			strList.remove("Tony");
			strList.add("Philp");
		}
	}
	private static void setList(List<String> strList){
		strList.add("Tony");
		strList.add("David");
		strList.add("Smith");
	}
}
