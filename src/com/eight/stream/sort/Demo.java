package com.eight.stream.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args){
		// default order and reverse order for sort()
		List<String> strList = Arrays.asList("a","z","s","c","i","f","1","5","2","8");
		List<String> sortedList = strList.stream().sorted().collect(Collectors.toList());
		sortedList.stream().forEach(System.out::print);
		System.out.println();
		strList = Arrays.asList("a","z","s","c","i","f","1","5","2","8");
		sortedList = strList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		sortedList.stream().forEach(System.out::print);
		System.out.println();
		
		// Object list sort
		List<User> users = Arrays.asList(
				new User("Tony",12), new User("David",13), new User("Smith",51),
				new User("Floyde",41)
				);
		List<User> usersSorted = users.stream()
									  .sorted(
											  Comparator.comparingInt(User::getAge)
											  //.reversed() // can reverse the sequence of order
											 )
									  .collect(Collectors.toList());
		usersSorted.stream().forEach(System.out::println);
		
		// Map sort by Key of map
		Map<String, Integer> unsortMap = null;
		unsortMap = setMap(unsortMap);
		Map<String, Integer> sortedMap = unsortMap.entrySet()
				 .stream()
				 .sorted(Map.Entry.comparingByKey())
				 .collect(
						 Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue,newValue)->oldValue, LinkedHashMap::new)
				         );
		System.out.println(sortedMap);
		// Map sort by value of map
		Map<String, Integer> unsortMap1 = null;
		unsortMap1 = setMap(unsortMap1);
		Map<String, Integer> sortedMap1 = unsortMap1.entrySet()
							 .stream()
							 .sorted(Map.Entry.comparingByValue())
							 .collect(
									 Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
											 (oldValue,newValue)->oldValue, LinkedHashMap::new)
								    );
		System.out.println(sortedMap1);
	}
	
	
	public static Map<String, Integer> setMap(Map<String, Integer> map){
		map = new HashMap<>();
		map.put("a",10);map.put("g",6);map.put("b",9);map.put("d",7);
		map.put("h",7);map.put("c",8);map.put("i",3);
		map.put("e",4);map.put("j",2);map.put("f",5);
		map.put("k",1);
		return map;
	}
	static class User{
		private String name;
		private int age;
		User(String name,int age){
			this.name = name;
			this.age = age;
		}
		public String getName(){ return this.name; }
		public int getAge(){ return this.age; }
		
		public String toString(){
			return "User[ "+this.name+","+this.age+" ]";
		}
	}
}

