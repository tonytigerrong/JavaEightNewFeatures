package com.eight.function;

import java.util.function.Function;

public class Demo {

	
	public static void main(String[] args){
		// 1st: input; 2nd: return
		Function<String, Integer> func = x->x.length();
		Integer length = func.apply("tring");
		System.out.println(length);
		
		//for function chain
		Function<Integer,Integer> func2 = x->x*x;
		Integer i = func.andThen(func2).apply("trong");
		//1:func.apply('frong') 2: func2 3: func2
		i = func.andThen(func2.andThen(func2)).apply("frong");
		
		System.out.println(i);
	}
}
