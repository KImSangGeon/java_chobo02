package java_chobo02_ch14_collection;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionEx {

	public static void main(String[] args) {
		ArrayList<Integer> arList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			arList.add(i);
		}
		for(int i : arList) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Consumer<Integer> c =new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.print(t + " ");
			}
		};
		Consumer<Integer> d = i -> System.out.print(i + " ");
		arList.forEach(c);
		System.out.println();
		
		arList.forEach(d);
		System.out.println();
		
		arList.forEach(i ->System.out.print(i + " "));
		System.out.println();
		
		//List에서 2또는 3의 배수를 제거
		arList.removeIf(x -> x % 2 == 0 || x % 3 ==0);
		arList.forEach(i ->System.out.print(i + " "));
		
		Predicate<Integer> p1 = i -> i % 2 ==0;
		Predicate<Integer> p2 = i -> i % 3 ==0;
		Predicate<Integer> p3 = p1.or(p2);
		
		
		ArrayList<Integer> arList2 = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			arList2.add(i);
		}
		System.out.println();
		arList2.forEach(i->System.out.print(i+ " "));
		System.out.println();
		
		arList2.removeIf(p3);
		arList2.forEach(i->System.out.print(i + " "));
		System.out.println();
		
		UnaryOperator<Integer> v = new UnaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t * 10;
			}
		};
		arList.replaceAll(v);
		arList.forEach(i->System.out.print(i + " "));
		System.out.println();
	
		UnaryOperator<Integer> u = i -> i * 10;
		arList2.replaceAll(u);
		arList2.forEach(i->System.out.print(i + " "));
		
	
		
		
	}

}
