package com.eight.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("test1", "test2", "test3", "test4");
		List<Person> perList = Arrays.asList(
				new Person("Tony"), new Person("David"), new Person("Smith"),
				new Person("Tony")
				);
		System.out.println();
		///////////////////////////////////////////////////////////////////////////
		System.out.println("using FILTER to filter, and then using COLLECT to convert to result a list");
		List<String> resList = strList.stream()
				                      .filter(str -> !"test2".equals(str))
				                      .collect(Collectors.toList()); // get a list as result
		resList.forEach(System.out::println);
		System.out.println();
		///////////////////////////////////////////////////////////////////////////
		System.out.println("using FINDANY to find any one proper element");
		Person per =  perList.stream()
				             .filter(person->{
									return "Tony".equals(person.getName());
								})
				             .findAny() // get any proper element as result
				             .orElse(null);
		System.out.println(per.getName());
		System.out.println();
		///////////////////////////////////////////////////////////////////////////
		System.out.println("using MAP to reset all element filtered by FILTER ");
		String name = perList.stream()
				             .filter(person-> "Tony".equals(person.getName()))
				             .map(person->person.getName())
				             .findAny()
				             .orElse(null);
		System.out.println("name: "+name);
		System.out.println();
		///////////////////////////////////////////////////////////////////////////	
		List<String> nameList = perList.stream()
									   .map((person)->  person.getName())
									   .collect(Collectors.toList());
		nameList.forEach(System.out::println);
		System.out.println();
		///////////////////////////////////////////////////////////////////////////
		System.out.println("using PARALLEL STREAM to go through each element parallelly");
		IntStream intList1 =   IntStream.rangeClosed(1,10);
		intList1.forEach(System.out::println);
		System.out.println();
		IntStream intList2 = IntStream.rangeClosed(1,10);
		intList2.parallel().forEach(System.out::println);
		System.out.println();
		List<String> strList2 = Arrays.asList("a","b","c","d","e","f","g","h","i","j");
		strList2.forEach(System.out::println);
		System.out.println();
		strList2.parallelStream().forEach(System.out::println);
		
		
		
	}
}

class Person{
	private String name;
	private int age;
	Person(String name){
		this.name = name;
	}
	public int getAge(){ return this.age;}
	public String getName(){ return this.name;}
}
