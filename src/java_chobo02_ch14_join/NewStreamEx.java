package java_chobo02_ch14_join;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewStreamEx {

	public static void main(String[] args) {
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();
		
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		System.out.println(" =======랜덤=====");
		
		//난수를 요소로		
		new Random().ints().limit(5).sorted().forEach(System.out::println);
		System.out.println();
		System.out.printf(" int () range =>%d ~ %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		new Random().ints().limit(5).sorted().forEach(System.out::println);
		System.out.println();
		
		
	}

}
