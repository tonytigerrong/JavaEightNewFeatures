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
		
		while(listIt.hasNext()){
			System.out.println(listIt.next());
			/**
			 * will throw exception if you add and remove in same listiterator
			 */
			listIt.add("Tony1");
//			listIt.remove(); // can't apply add and remove to same listiterator
		}
		System.out.println();
		while(listIt.hasPrevious()){
//			listIt.remove(); //can't apply add and remove to same listiterator
			System.out.println(listIt.previous());
			
		}
		System.out.println();
		
		ListIterator<String> listIt2 = strList.listIterator();
		while(listIt2.hasNext()){
			System.out.println(listIt2.next());
			listIt2.remove();
		}
	}
	
	private static void setList(List<String> strList){
		strList.add("Tony");
		strList.add("David");
		strList.add("Smith");
	}
}
