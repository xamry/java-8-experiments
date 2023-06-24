package com.xamry.functionalinterfaces;

@FunctionalInterface   
public interface Interface2 {
	
	//Single abstract method, because it's a functional interface
	double substract(double x, double y);
	
	//Default methods are allowed to have concrete implementation in interfaces
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
	

}
