package java_chobo02_ch14_join;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFlatMapEx {
	public static void main(String[] args) {
		String[][] strArrs = {
				{"abc", "def", "jkl"},
      			{"ABC", "GHI", "JKL"}
		};
		
		Stream<String[]> strArrStream = Stream.of(strArrs);
		Stream<Stream<String>> strStreamStream = strArrStream.map(Arrays::stream);
		strArrStream = Stream.of(strArrs);

		Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
		
		strStream.map(String::toLowerCase)
		.distinct()
		.sorted()
		.forEach(System.out::println);
		System.out.println();
	}

}
