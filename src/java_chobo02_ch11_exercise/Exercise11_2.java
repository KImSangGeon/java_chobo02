package java_chobo02_ch11_exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Exercise11_2 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("홍길동", 1, 1, 100, 100, 100));
		list.add(new Student("남궁성", 1, 2, 90, 70, 80));
		list.add(new Student("깅자바", 1, 3, 80, 80, 90));
		list.add(new Student("이자바", 1, 4, 70, 90, 70));
		list.add(new Student("안자바", 1, 5, 60, 100, 80));
		
		Comparator<Student> comp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return  ;
			}
		};
		
		
		Collections.sort(list);
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.hasNext());
			
		}
		
		
	}

}
