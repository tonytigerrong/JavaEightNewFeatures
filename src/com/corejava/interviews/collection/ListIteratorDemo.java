package com.corejava.interviews.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

	public static void main(String[] args){
		List<String> strList = new ArrayList<>();
		setList(strList);
		/**
		 * listiterator has next() and previous() bidirection traverse methods
		 * has add and remove method, fail-safe
		 * but you can't add and remove source collection(list) via listiterator in same listiterator 
		 */
		ListIterator<String> listIt = strList.listIterator(); // clone from collection to generate a listiterator
		// pointer of listiterator move from 1st to last
		while(listIt.hasNext()){
			System.out.println(listIt.next());
			/**
			 * will throw exception if you add and remove in same listiterator
			 */
			listIt.add("Tony1");
//			listIt.remove(); // can't apply add and remove to same listiterator
		}
		System.out.println("Pointer move from last to 1st");
		while(listIt.hasPrevious()){
//			listIt.remove(); //can't apply add and remove to same listiterator
			System.out.println(listIt.previous());
			
		}
		System.out.println("Create 2nd pointer of listiterator, traverse from 1st to last");
		
		ListIterator<String> listIt2 = strList.listIterator();
		while(listIt2.hasNext()){
			System.out.println(listIt2.next());
			listIt2.remove();
		}
		System.out.println("Should print nothing");
		while(listIt2.hasPrevious()) {
			System.out.println(listIt2.previous());
		}
	}
	
	private static void setList(List<String> strList){
		strList.add("Tony");
		strList.add("David");
		strList.add("Smith");
	}
}
