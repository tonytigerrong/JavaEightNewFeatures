package com.eight.function;

import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
public class Demo {

	
	public static void main(String[] args){
		// 1st: input; 2nd: return
		Function<String, Integer> func = x->x.length(); //define a Function method by Lambda syntax
		Integer length = func.apply("abcde");           //instance.apply to invode the method
		System.out.println(length);
		
		//for function chain
		Function<Integer,Integer> func2 = x->x*x;
		Integer i = func.andThen(func2).apply("abcde");
		
		/* 1:func.apply('abcde') 2: func2 3: func2
		 * 
		 */
		i = func.andThen(func2.andThen(func2)).apply("abcde");
		System.out.println(i);
		
		//BiFunction 2 input parameters 1 return value
		BiFunction<String,Integer,String> bifunc = (str, start)->{
			return str.substring(start);
		};
		System.out.println(bifunc.apply("abcd1234",2));
		
		//BiConsumer 2 input parameters 0 return value
		BiConsumer<Integer, Integer> func3 = (x,y)->{
			System.out.println(x+y);
		};
		func3.accept(3, 4);
	}
}
