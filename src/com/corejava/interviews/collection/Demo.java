package com.corejava.interviews.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

	public static void main(String[] args){
//		List<String> strList1 = Arrays.asList("A","b","C","def");
//		strList1.removeIf(x->"A".equals(x)); // will throw exception, since Arrays.asList can't remove elements
		// removeIf arraylist's elements
		List<String> strList1 = new ArrayList<>();
		strList1.add("A");strList1.add("b");strList1.add("C");strList1.add("def");
		strList1.removeIf(x->"A".equals(x));
		strList1.stream().forEach(System.out::println);
		
		// Map remove
		Map<String,String> map = new HashMap<>();
		fillMapData(map);
		map.forEach((k,v)->System.out.printf("%s->%s%n", k,v));
		map.put("D", "4");
		map.remove("A");
		map.forEach((k,v)->System.out.printf("%s->%s%n", k,v));
		
		// Collection contains different object element
		Collection collection = new ArrayList<>();
		collection.add(new Car("car1",23.12));
		collection.add(new Car("car2",23.13));
		collection.add(new Bike("bike1",23.11));
		collection.add(new Bike("bike2",23.10));
		
		
		
	}
	
	public static void fillMapData(Map<String,String> map){
		map.put("A","1");
		map.put("C","3");
		map.put("B","2");
	}
	
	
}
class Car{
	private String name;
	private double price;
	Car(String name,double price){this.name=name; this.price = price;}
}
class Bike{
	private String name;
	private double price;
	Bike(String name,double price){this.name=name; this.price = price;}
}