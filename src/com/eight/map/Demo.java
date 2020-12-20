package com.eight.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {

	
	public static void main(String[] args){
		
		System.out.println("General map Example");
		List<Integer> intList = Arrays.asList(1,2,3,4,5);
		/**
		 * stream.map: travers all elements, and do something on them, then put them back to collection
		 */
		intList = intList.stream().map(i->i*2).collect(Collectors.toList());
		intList.forEach(System.out::print);
		
		System.out.println();
		System.out.println("Flat map Example");
		String[][] data = new String[][]{{"a","b"},{"c","e"},{"f","g"}};
		/**
		 * stream: get 1st level of each element of collection
		 * 		   if collection is 2 dimensions, stream will get only 1st level
		 */
		Stream<String[]> stream = Arrays.stream(data);
		stream.forEach(strList->{    // 1st level travers
			for(String str : strList)// 2nd level travers
				System.out.print(str);
		});
		System.out.println();
		stream = Arrays.stream(data); //long l = stream.count(); System.out.println(l);
		/**
		 * flatMap: return collection's 1st level elements as a new stream
		 */
		Stream<String> stream2 = stream.flatMap(  // mapping 1st level element as a stream
											strs->Arrays.stream(strs) //return elements of 2nd level element as a stream
										);
		stream2.forEach(System.out::print);
		
		
		
		
	}
}
