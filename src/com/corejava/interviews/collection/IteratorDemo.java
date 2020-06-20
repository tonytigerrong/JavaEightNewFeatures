package com.corejava.interviews.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

	public static void main(String[] args){
		List<String> strList = new ArrayList<>();
		setList(strList);
		Iterator it = strList.iterator();
		while(it.hasNext()){
			String str = (String)it.next();
			System.out.println(str);
			/* iterator copy elements of strList and loop them,
			 *  we can remove or add element to iterator without throw ConcurrentModificationException
			 */
		    // iterator don't have add method for insert element
			it.remove(); //in loop scope, just iterator has been removed an element. this remove will effect to source(strList) after the loop
		}
		
		strList.stream().forEach(System.out::println);
	}
	
	private static void setList(List<String> strList){
		strList.add("Tony");
		strList.add("David");
		strList.add("Smith");
	}
}
