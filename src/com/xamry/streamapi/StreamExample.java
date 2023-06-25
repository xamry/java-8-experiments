package com.xamry.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {
	
	public static void main(String[] args) {
		/////////////////Stream Creation////////////////////////
		
		// 1. Empty Stream
		Stream<Employee> streamEmpty = Stream.empty();
		
		//2. Stream of Collection by calling stream() method of collection interface
		List<Employee> employeeList = new ArrayList<>();
		Employee emp1 = new Employee(1, "John Smith", 1000.0); employeeList.add(emp1);
		Employee emp2 = new Employee(2, "David Parker", 2000.0); employeeList.add(emp2);
		Employee emp3 = new Employee(3, "Angela Merkel", 3000.0); employeeList.add(emp3);
		
		Stream<Employee> byStreamMethod = employeeList.stream();
		
		//3. Stream of List by calling of() method of Stream 
		Stream<Employee> byOfMethod = Stream.of(emp1, emp2, emp3);
		
		//4. Create stream using Stream.builder() method
		Stream<Employee> byStreamBuilder = Stream.<Employee>builder().add(emp1).add(emp2).add(emp3).build();
		
		//5. Create Stream using Stream.generate() method. Limit result otherwise an infinite stream will be generated
		Stream<Employee> streamGenerated = Stream.generate(() -> emp1).limit(10);
		
		//6. Create an infinite stream from Stream.iterate() method
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2);
		
		//7. Create stream of primitives from IntStream, LongStream, DoubleStream etc.
		IntStream intStream = IntStream.range(1, 3);	//Excluding 3
		LongStream longStream = LongStream.rangeClosed(1, 3); //Including 3
		
		
		//////////////////////Referencing a Stream/////////////////////////
		
		
		///////////////////Stream Operations/////////////////////////////////
		//https://stackify.com/streams-guide-java-8/
		//(i) Intermediate operations(map, filter, sorted etc)  (ii) Terminal operations (forEach, collect, reduce etc)
		
		
		//1. forEach  (double the salary of each employee)  [Terminal operation, Stream can't be used further]
		employeeList.forEach(e -> e.setSalary(e.getSalary() * 2));
		System.out.println("ForEach::\n" + employeeList);
		
		
		//2. map (Intermediate operation, returns a new stream)
		List<Employee> empListRefined = employeeList.stream().map(e -> {e.setName("Mr./Ms." + e.getName());return e;}).collect(Collectors.toList());
		System.out.println("Map and collect::\n" + empListRefined);
		
		//3. Collect (Terminal operation) - for collecting the elements in a collection
		//Code as above
		
		
		//4. filter (Intermediate operation)
		List<Employee> employeesAfterFilter = employeeList.stream().filter(e -> e.getSalary() > 4000).collect(Collectors.toList());
		System.out.println("Filter::\n" + employeesAfterFilter);
		
		//5. findFirst
		Employee firstEmployee = employeeList.stream().filter(e -> e.getSalary() > 2000).findFirst().orElse(null);
		System.out.println("FindFirst::\n" + firstEmployee);
		
		//6. toArray
		Employee[] employeeArr = employeeList.stream().toArray(Employee[]::new);
		System.out.println("toArray::\n" + Arrays.asList(employeeArr));
		
	}

}
