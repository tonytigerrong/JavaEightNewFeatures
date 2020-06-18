package com.eight.stream.iterate;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args){
		
		
		System.out.println("ITERATE of stream, 2 input parameter, 1st is seed, 2nd is rule of the nexts");
		Stream.iterate(0, n->n+1).limit(10).forEach(System.out::print);
		System.out.println();
		
		Stream.iterate(0, n->n+1).filter(x->x%2 !=0).limit(10).forEach(System.out::print);
		System.out.println();
		Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0]+n[1]})
		      .limit(10)
		      .forEach(p->System.out.println(p[0]));
		
	}
}
