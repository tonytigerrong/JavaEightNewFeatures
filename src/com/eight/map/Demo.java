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
		intList = intList.stream().map(i->i*2).collect(Collectors.toList());
		intList.forEach(System.out::print);
		
		System.out.println();
		System.out.println("Flat map Example");
		String[][] data = new String[][]{{"a","b"},{"c","e"},{"f","g"}};
		Stream<String[]> stream = Arrays.stream(data);
		stream.forEach(strList->{
			for(String str : strList)
				System.out.print(str);
		});
		System.out.println();
		stream = Arrays.stream(data); //long l = stream.count(); System.out.println(l);
		Stream<String> stream2 = stream.flatMap(strs->Arrays.stream(strs));
		stream2.forEach(System.out::print);
		
		
		
		
	}
}
