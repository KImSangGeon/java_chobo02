package java_chobo02_ch14_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

public class Ex14_4 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			list.add(i);

		list.forEach(i -> System.out.print(i + " "));
		System.out.println();

		list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
		System.out.println(list);

		list.replaceAll(i -> i * 10);
		System.out.println(list);

		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		System.out.println("Map<key, value > 출력1");
		for (Entry<String, String> e : map.entrySet()) {
			System.out.printf("{ %s -> %s}%n", e.getKey(), e.getValue());
		}

		System.out.println("Map<key, value > 출력2");
		for (String key : map.keySet()) {
			System.out.printf("{ %s -> %s}%n", key, map.get(key));
		}
		BiConsumer<String, String> w = new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				System.out.printf("{%s -> %s}%n", t, u);
			}
		};
		System.out.println("Map<key, value > 함수형 인터페이스 출력1");
		map.forEach(w);
		System.out.println();
		
		System.out.println("Map<key, value > 함수형 인터페이스 출력2");
		map.forEach((key, value) -> System.out.printf("{ %s -> %s}%n", key, value));
	}

}
