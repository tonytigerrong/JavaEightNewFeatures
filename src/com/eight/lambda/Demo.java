package com.eight.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo {
	public void test(List<String> stringList) {
		// anonymous class
		stringList.forEach(new Consumer<String>() {

			@Override
			public void accept(String arg0) {
				System.out.println(arg0);
			}
		});
		// lambda expression
		stringList.forEach(str->System.out.println(str));
		//method reference
		stringList.forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("Tony", "David", "Smith");
		Demo demo = new Demo();
		demo.test(strList);
	}
}
