package java_chobo02_ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class StudentManagement2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		Student[] students = new Student[5];

		HashMap<Integer, Student> students = new HashMap<>();
		initial(students);

		System.out.println("학생관리 프로그램");
		int choice;
		do {
			showMenu();
			System.out.print("메뉴 > ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addStudent(students, sc);
				break;
			case 2:
				modifyStudent(students, sc);
				break;
			case 3:
				deleteStudent(students, sc);
				break;
			case 4:
				prnStudent(students);
				break;
			}
		} while (choice < 5);
		sc.close();

	}

	private static void deleteStudent(HashMap<Integer, Student> students, Scanner sc) {
		prnStudent(students);
		System.out.print("삭제하고자하는 학생번호 입력 > ");
		int delStdNo = sc.nextInt();
		if (students.equals(delStdNo)) {
			System.out.println("해당 하는 학생이 존재하지 않음");
			return;
		}
		students.remove(delStdNo);

	}

	private static void modifyStudent(HashMap<Integer, Student> students, Scanner sc) {
		prnStudent(students);
		System.out.print("수정하고자하는 학생번호 입력 > ");
		int findStdNo = sc.nextInt();
		

		if (!students.containsKey(findStdNo)) {
			System.out.println("해당 하는 학생이 존재하지 않음");
			return;
		}
		Student newStd = createStudent(sc);
		students.remove(findStdNo);
		students.put(newStd.getStdNo(), newStd);
	}

	private static void addStudent(HashMap<Integer, Student> students, Scanner sc) {

		Student newStd = createStudent(sc);
		if (students.containsValue(newStd)) {
			System.out.println("동일한 학생을 입력할 수 없습니다.");
			return;
		}
		students.put(newStd.getStdNo(), newStd);
	}

	private static Student createStudent(Scanner sc) {
		System.out.println("학생 정보를 입력하세요. ex) 번호 성명 국어 영어 수학 ");
		int stdNo = sc.nextInt();
		String name = sc.next();
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		return new Student(stdNo, name, kor, eng, math);
	}

	private static void prnStudent(HashMap<Integer, Student> students) {

		Iterator<Entry<Integer, Student>> i = students.entrySet().iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			
		}
		
		System.out.println();
	}

	private static void initial(HashMap<Integer, Student> students) {
		students.put(1, new Student(1, "전수린", 90, 90, 90));
		students.put(2, new Student(2, "김상건", 91, 91, 91));
		students.put(3, new Student(3, "이태훈", 92, 92, 92));
	}

	private static void showMenu() {
		String[] m = new String[6];
		m[0] = "메뉴를 선택하새요.\n";
		m[1] = "1. 학생 추가\n";
		m[2] = "2. 학생 수정\n";
		m[3] = "3. 학생 삭제\n";
		m[4] = "4. 학생 목록\n";
		m[5] = "5. 종료\n";

		for (String str : m) {
			System.out.print(str);
		}
	}
}
