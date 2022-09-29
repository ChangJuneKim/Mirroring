package com.ssafy.offline;

public class Student{

	private int no;
	private int score;

	public Student(int no, int score) {
		super();
		this.no = no;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}

//	@Override
//	public int compareTo(Student o) {
//		return this.score - o.score;
//	}

}
