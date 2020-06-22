package com.corejava.interviews.genericsdemo;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	@Override
	public String toString() {
		return "I am a Fruit !!";
	}
}

class Apple extends Fruit {
	@Override
	public String toString() {
		return "I am an Apple !!";
	}
}

class AsianApple extends Apple {
	@Override
	public String toString() {
		return "I am an AsianApple !!";
	}
}

public class GenericsExamples {
	public static void main(String[] args) {
		/**
		 *  1. Use the <? extends T> wildcard if you need to retrieve object of type T from a collection.
		 *	2. Use the <? super T> wildcard if you need to put objects of type T in a collection.
		 *	3. If you need to satisfy both things, well, don¡¯t use any wildcard. As simple as it is.
		 *	4. In short, remember the term PECS. Producer extends Consumer super. Really easy to remember.
		 */
		// List of apples
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple());
		
		List<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(new Fruit());

		// We can assign a list of apples to a basket of apples
		List<? super Apple> basket = apples;
		basket.add(new Apple()); // Successful
		basket.add(new AsianApple()); // Successful
//		basket.add(new Fruit()); //Compile time error
		basket.forEach(System.out::println);
		System.out.println();
		
		//We can assign a list of apples to a basket of fruits;
	      //because apple is subtype of fruit 
	      List<? extends Fruit> _basket = apples;
	       
	      //Here we know that in basket there is nothing but fruit only
	      for (Fruit fruit : _basket)
	      {
	         System.out.println(fruit);
	      }
	       
	      //basket.add(new Apple()); //Compile time error
	      //basket.add(new Fruit()); //Compile time error
	}
}
