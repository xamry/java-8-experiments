package com.xamry.functionalinterfaces;

public class ConcreteClass implements Interface1, Interface2 {

	@Override
	public double substract(double x, double y) {
		return 0d;		
	}

	@Override
	public int add(int a, int b) {
		return 0;
	}
	
	//MyClass won't compile without having it's own log() implementation, because it inherits two similar methods
	@Override
	public void log(String str) {
		System.out.println("MyClass logging::" + str);
		Interface1.print("abc");
	}

}
