package java_chobo02_ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;

public class ArraysEx {

	public static void main(String[] args) {
//		arrayToString();
//		arrayDeepToString();
//		arrayToEquals();
//		arrayToFill();
//		arrayToList();
//		arrayToBinarySearchBySort();
		
		Student[] stdArr = {
				new Student(1, "이종윤", 90, 90, 90), 
				new Student(5, "김길현", 80, 79, 68), 
				new Student(3, "박유진", 78, 91, 55), 
				new Student(4, "김인환", 99, 60, 40)
				};
		
		//기본 학번순으로 정렬
		Arrays.sort(stdArr);
		prnStudent(stdArr);
		
		
		//국어점수순으로 정렬
		Comparator<Student> comp = new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			return o1.getKor() - o2.getKor();
			
		
		}
		
		
		};
		Comparator<Student> revComp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getMath() - o2.getMath();
			}
		};
		Arrays.sort(stdArr, comp);
		prnStudent(stdArr);
	
		Arrays.sort(stdArr, revComp);
		prnStudent(stdArr);
		
		
		
		
		
				
	}

	private static void prnStudent(Student[] stdArr) {
		System.out.println("=======장렬======");
		
		for(Student s : stdArr) {
			System.out.println(s);
		}
		System.out.println();
		
	}

	public static void arrayToBinarySearchBySort() {
		//이분검색(바이너리서치) 반드시 정렬되어야한다.
		int[] arr = {10, 9, 5, 6, 7, 8, 1};
		System.out.println(Arrays.binarySearch(arr, 8));
		System.out.println(Arrays.binarySearch(arr, 1));
		
		
		long start = System.nanoTime();
		
		System.out.println("start  " );
		Arrays.sort(arr);
//		Arrays.parallelSort(arr);
		
		long end = System.nanoTime() - start;
		
		System.out.println("end - " + end);
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println(Arrays.binarySearch(arr, 8));
		System.out.println(Arrays.binarySearch(arr, 1));
	}

	public static void arrayToList() {
		Integer[] intArr = new Integer[] {1, 2, 3, 4};
		
		List<Integer> arList = Arrays.asList(new Integer[] {1,2,3,4});
		System.out.println("arList >" + arList);
		for(int a : arList) {
			System.out.println(a);
		}
		
		arList.set(1, 6);
		System.out.println(arList);
		ArrayList<Integer> al = new ArrayList<Integer>(arList);
		al.add(10);
		System.out.println(al);
		
		
//		arList.add(10);
//		System.out.println(arList);
	}

	public static void arrayToFill() {
		int[] intArr1 = {1, 2, 3, 4, 5, 6};
		int[] copyArr1 = Arrays.copyOf(intArr1, intArr1.length);
		
		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.equals(intArr1, copyArr1));
		
		int[] copyArr2 = Arrays.copyOf(intArr1, 3);
		System.out.println(Arrays.toString(copyArr2));
		
		int[] newArr = new int[10];
		Arrays.fill(newArr, 10);
		System.out.println(Arrays.toString(newArr));
		Arrays.setAll(newArr, (i)->(int) (Math.random()*100)+1);
		System.out.println(Arrays.toString(newArr));
		
		/*
		Arrays.setAll(newArr, new IntUnaryOperator() {
			
			@Override
			public int applyAsInt(int operand) {
			return (int) (Math.random()*100)+1;
			}
		}); 
		*/
	}

	public static void arrayToEquals() {
		int[] intArr1 = {1,2,3};
		int[] intArr2 = {1,2,3};
		
		System.out.println(Arrays.equals(intArr1, intArr2));
		
		int[][] intTwoDimen1 = {{1,2}, {3,4}};
		int[][] intTwoDimen2 = {{1,2}, {3,4}};
		
		System.out.println(Arrays.deepEquals(intTwoDimen1, intTwoDimen2));
	}

	public static void arrayDeepToString() {
		int[][] twoArr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				
		};
		
		System.out.println(Arrays.toString(twoArr));
		System.out.println(Arrays.deepToString(twoArr));
	}

	public static void arrayToString() {
		//List -> array
		ArrayList<String> arList = new ArrayList<String>();
		arList.add("add");
		arList.add("def");
		arList.add("ghi");
		
		Object[] objArr = arList.toArray();
		String str = Arrays.toString(objArr);
		System.out.println("objArr to String > " + str);
		
		String[] strArr = new String[arList.size()];
		arList.toArray(strArr);
		System.out.println(Arrays.toString(strArr));
	}
}
