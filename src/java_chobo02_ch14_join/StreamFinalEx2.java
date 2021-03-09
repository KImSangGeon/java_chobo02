package java_chobo02_ch14_join;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamFinalEx2 {

	public static void main(String[] args) {

	
		
		//스트림을 reducing
		 OptionalInt maxValue = new Random(1234).ints(1,16)
				 .distinct().limit(6).peek(s -> System.out.printf(s + ", "))
						 .reduce(Integer::max);
		 
		 System.out.println("max = "+ maxValue.getAsInt());
		
		 System.out.println(maxValue.getAsInt());
		 
		 Optional<Integer> maxValue2 = new Random(1234).ints(1,16)
				 .distinct().limit(6) //IntStream
				 .boxed() //Stream<Integer>
				 .collect(Collectors.reducing(Integer::max));
		 
		 System.out.println("max = "+ maxValue2.get());
		 
		int sum1 = new Random(1234).ints(1,16)
		 .distinct().limit(6).reduce(0, (a,b) -> a + b);
		
		 int sum2 = new Random(1234).ints(1,16)
		 .distinct().limit(6).boxed().collect(Collectors.reducing(0, (a, b) -> a + b));
		 
		 System.out.printf("sum1 = %d, sum2 = %d%n", sum1, sum2);
		 
		 List<Student> list = new ArrayList<Student>();
			list.add(new Student("이자바", 3, 300));
			list.add(new Student("김자바", 1, 200));
			list.add(new Student("안자바", 2, 100));
			list.add(new Student("박자바", 2, 150));
			list.add(new Student("소자바", 1, 95));
			list.add(new Student("나자바", 3, 290));
			list.add(new Student("감자바", 3, 80));
			
			int grandTotal1 = list.parallelStream()
					.map(Student::getTotalScore).reduce(0,Integer::sum);
			
			System.out.println(grandTotal1);
			
			int grandTotal2 = list.parallelStream()
					.collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		
			System.out.println(grandTotal2);
		//문자열스트림을 모두 연결(Joinning)
		String names1 = list.parallelStream().map(Student::getName)
				.collect(Collectors.joining());
		
		String names2 = list.parallelStream().map(Student::getName)
				.collect(Collectors.joining(", "));
		
		String names3 = list.parallelStream().map(Student::getName)
				.collect(Collectors.joining(",", "[", "]"));
		
		System.out.println(names1);
		System.out.println(names2);
		System.out.println(names3);
		//스트림을 컬렉션으로 변환
//   	extracted01(list);
		
		//스트림의 통계변환
//		extracted2(list);
				

		
		
	}

	public static void extracted2(List<Student> list) {
		long cnt1 = list.stream().count();
		long cnt2 = list.stream().collect(Collectors.counting());
		
		System.out.printf("count %d, %d%n", cnt1, cnt2);
		
		int sum1 = list.
				parallelStream().
				mapToInt(Student::getTotalScore).
				peek(System.out::println).
				sum();
		
		int sum2 = list.
				parallelStream().
				collect(Collectors.
						summingInt(Student::getTotalScore));
		System.out.printf("total %d, %d%n", sum1, sum2);

		OptionalInt max1 =list.
		parallelStream().
		mapToInt(Student::getTotalScore).
		peek(System.out::println).
		max();
		// 옵셔널을 사용하면 INT로 바꿔주기위해 getAsInt() 사용.
		
		
		System.out.printf("maxScore %d%n", max1.getAsInt());
		
		Optional<Student> maxStd1 = list.parallelStream().
				max(Comparator.comparingInt(Student::getTotalScore));
		
		Student std = maxStd1.get();
		System.out.println(std);
			
		
		Optional<Student> maxStd2 = list.parallelStream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
		
		Student std1 = maxStd2.get();
		System.out.println(std1);
		
		IntSummaryStatistics iss1 = list.parallelStream()
		.mapToInt(Student::getTotalScore)
		.summaryStatistics();
		
		System.out.println(iss1);
		
		IntSummaryStatistics iss2 = list.parallelStream()
				.collect(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println(iss2);
	}

	public static void extracted01(List<Student> list) {
		List<String> stdList = 
				list.stream().map(Student::getName)
				.peek(System.out::println)
				.collect(Collectors.toList());
			
		System.out.println(stdList);
		
		
		ArrayList<Student> arList = list.stream()
				.collect(Collectors.toCollection(ArrayList::new));
		
		System.out.println(arList);
			
		
		//Map<이름, 학생>
		
		Map<String, Student> map = list.stream()
				.collect(Collectors.toMap(s->s.getName(), s->s));
		
		for(Entry<String, Student> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}
