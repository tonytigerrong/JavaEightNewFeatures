package com.corejava.interviews.collection;

import java.util.ArrayList;
import java.util.List;

public class ListIteratorDemo {

	public static void main(String[] args){
		List<String> strList = new ArrayList<>();
		setList(strList);
	}
	
	private static void setList(List<String> strList){
		strList.add("Tony");
		strList.add("David");
		strList.add("Smith");
	}
}
