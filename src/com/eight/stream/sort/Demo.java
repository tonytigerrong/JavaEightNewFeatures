package com.eight.stream.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

