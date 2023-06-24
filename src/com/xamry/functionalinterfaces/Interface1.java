package com.xamry.functionalinterfaces;

@FunctionalInterface
public interface Interface1 {
	
	//Single abstract method, because it's a functional interface
	int add(int a, int b);
	
	//Default methods are allowed to have concrete implementation in interfaces
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	//Static methods are allowed to have concrete implementation in interfaces
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	//trying to override Object method gives compile-time error as
	//"A default method cannot override a method from java.lang.Object"
	
//	default String toString(){
//		return "i1";
//	}

}
