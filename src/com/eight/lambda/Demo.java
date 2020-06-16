package com.eight.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo {
	public void test(List<String> stringList) {
		//1 anonymous class
		System.out.println("anonymous class print:");
		stringList.forEach(new Consumer<String>() {

			@Override
			public void accept(String arg0) {
				System.out.println(arg0);
			}
		});
		//2 lambda expression
		System.out.println("lambda expression print:");
		stringList.forEach(str->System.out.println(str));
		
		// 2.1 sort by lambda expression
		stringList.sort((str1, str2)-> {
			return str1.compareTo(str2);
		});
		System.out.println("print after sort");
		//3 method reference
		stringList.forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("Tony", "David", "Smith");
		Demo demo = new Demo();
		demo.test(strList);
	}
}
