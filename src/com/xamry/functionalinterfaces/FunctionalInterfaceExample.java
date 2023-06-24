package com.xamry.functionalinterfaces;

import java.util.function.Function;

public class FunctionalInterfaceExample {
	
	public static void main(String[] args) {
		
		////////////Using your own custom functional interface//////////////////
		
		//Instantiating Interface1 using anonymous inner class
		Interface1 i = new Interface1() {
			
			@Override
			public int add(int a, int b) {
				
				return a + b;
				
			}
		};
		System.out.println(i.add(2,3));
		
		//Instantiating Interface1 using lambda expression
		Interface1 i1 = (a, b) -> a + b;   //small brackets are optional for single parameter, curly braces optional if single statement
		System.out.println(i1.add(3,4));
		
		
		///////////////////Using Function functional interface///////////////
		
		//Using Anonymous inner class
		Function<String, String> fn = new Function<String, String>() {
			@Override
			public String apply(String s) {
				return "Hello " + s;
			}
		};
		System.out.println(fn.apply("Amresh"));   // Hello Amresh
		

		//Using lambda expression (Same effect as above, but new syntax)
		Function<String, String> fn2 = s -> "Goodbye " + s;
		System.out.println(fn2.apply("Amresh"));   //Goodbye Amresh
		
		Function fn3 = fn.andThen(fn2);
		System.out.println(fn3.apply("Amresh"));    //Goodbye Hello Amresh
		
		Function fn4 = fn.compose(fn2);
		System.out.println(fn4.apply("Amresh"));		//Hello Goodbye Amresh
	}
	

}
