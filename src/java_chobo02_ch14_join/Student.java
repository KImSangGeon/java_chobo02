package java_chobo02_ch14_join;

public class Student implements Comparable<Student> {

	private String name;
	private int ban;
	int totalScore;

	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, ban=%s, totalScore=%s]", name, ban, totalScore);
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}


	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return (this.totalScore - o.totalScore) * 1;
	}

}
