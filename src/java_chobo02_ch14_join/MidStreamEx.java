package java_chobo02_ch14_join;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {
	
	public static void main(String[] args) {
//		extract01(); //skip(),limit(),filter(),distict()
		
//		extracte02(); //sorted()
	extract03();
		
		
		
		
			}

	public static void extract03() {
		Stream<Student> stdStream  = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 100)
				);
		
		stdStream
		.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Comparator.naturalOrder()))
		.forEach(System.out::println);
		
		System.out.println();
		Stream<Student> std1Stream  = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 100)
				);
		
		std1Stream
		.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Student::getName))
		.forEach(System.out::println);
	}

	public static void extracte02() {
		//sorted
		Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
		strStream.sorted().forEach(s -> System.out.print(s + " " ));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(Comparator.naturalOrder())
		.forEach(s -> System.out.print(s + " " ));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted((s1,s2) -> s1.compareTo(s2))
		.forEach(s -> System.out.print(s + " " ));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(String::compareTo)
		.forEach(s -> System.out.print(s + " " ));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(Comparator.reverseOrder())	
		.forEach(s -> System.out.print(s + " " ));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER)
		.forEach(s -> System.out.print(s + " " ));
		System.out.println();
		
		Stream.of("dd", "aaa", "CC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
		.forEach(s -> System.out.print(s + " " ));
		System.out.println();
	}

	public static void extract01() {
		//중간연산
		//1. skip(), limit()
		IntStream.rangeClosed(1, 10)
		.skip(3).limit(5).forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// 2. filter(), distict()
		IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 5)
		.distinct().forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		IntStream.rangeClosed(1, 20)
		.filter(i -> i%2 == 0)
		.filter(i -> i%3 ==0)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		IntPredicate test = new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				return value % 2 ==0;
			}
		};		
		
		IntPredicate p = t -> t%2 ==0;
		IntStream.rangeClosed(1, 20)
		.filter(p)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}
		
	}

