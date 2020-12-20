package com.eight.doublecolon;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("1", "2", "3", "4");
		System.out.println("method reference for static method (1)");
		strList.forEach(MyPrinter::print); // double colon to invoke static method 'print'
		
		System.out.println("method reference for static method (2)");
		List<Integer> intList = strList.stream().map(Integer::parseInt).collect(Collectors.toList());
		intList.forEach(MyPrinter::print);
		
		System.out.println("method reference for static method (3)");
		Integer addingForTwo = addingTwoInt(1,3, MyPrinter::adding);
		System.out.println("adding resutl is " + addingForTwo);
		
		System.out.println("method reference for instance method(1)");
		MyPrinter myprinter = new MyPrinter();
		strList.forEach(myprinter::printName); // double colon to invoke non-static method 'printName'
		
		System.out.println("method reference for instance method(1)");
		List<Integer> intList1 = Arrays.asList(1,10,2,5,3,4,9,32);
		intList1.sort(myprinter::compareByInt);
		intList1.forEach(MyPrinter::print);
	}
	/**
	 * BiFunction interface definition: using @FunctionalInterface, fit for (no need to implements from BiFunction) any 
	 * 				1. <R> methodName(Input1, Input2, R) { ... }
	 * 				2. R r = instance.apply(Input1, Input2);
	 * 				
	 * @param <R>
	 * @param a
	 * @param b
	 * @param func
	 * @return
	 */
	public static <R> R addingTwoInt(Integer a, Integer b, BiFunction<Integer, Integer, R> func){
		return func.apply(a,b);
	}
}

class MyPrinter {
	//print string
	public static void print(String str) {
		System.out.println(str);
	}
	
	//print integer
	public static void print(Integer i){
		System.out.println(i);
	}
	
	//print string
	public void printName(String str) {
		System.out.println(str);
	}
	
	//add a + b
	public static Integer adding(Integer a, Integer b){
		return a+b;
	}
	
	//compare
	public int compareByInt(Integer i1, Integer i2){
		return (i1 - i2)*-1;
	}
}