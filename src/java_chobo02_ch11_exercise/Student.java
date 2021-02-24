package java_chobo02_ch11_exercise;

import java.util.Comparator;

public class Student {
	String name;
	 int ban; 
	int no;
	int kor, eng, math;
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ban;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (ban != other.ban)
			return false;
		return true;
	}

	Student(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	int getTotal() {
		return kor + eng + math;
	}
	
	float  getAverage() {
		return (int)((getTotal()/ 3f) * 10 + 0.5)/10f;
	}
	
	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}

}

class BanNoAscending implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
			return ((Student) o1).getBan() -((Student) o2).getBan();
	}
	
}


