package com.xamry.streamapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {
	
	public static void main(String[] args) {
		/////////////////Stream Creation////////////////////////
		
		// 1. Empty Stream
		Stream<String> streamEmpty = Stream.empty();
		
		//2. Stream of Collection by calling stream() method of collection interface
		Collection myCollection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = myCollection.stream();
		
		//3. Stream of array by calling of() method of Stream 
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		
		//4. Create stream using Stream.builder() method
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		
		//5. Create Stream using Stream.generate() method. Limit result otherwise an infinite stream will be generated
		Stream<String> streamGenerated = Stream.generate(() -> "John").limit(10);
		
		//6. Create an infinite stream from Stream.iterate() method
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2);
		
		//7. Create stream of primitives from IntStream, LongStream, DoubleStream etc.
		IntStream intStream = IntStream.range(1, 3);	//Excluding 3
		LongStream longStream = LongStream.rangeClosed(1, 3); //Including 3
		
		
		//////////////////////Referencing a Stream/////////////////////////
		
		
	}

}
