package z.practice.object.ex.ex4;

public class Student {
	
	String name;
	int age;
	double mathScore;
	double koScore;
	double enScore;
	public Student() {
		super();
	}
	public Student(String name, int age, double mathScore, double koScore, double enScore) {
		super();
		this.name = name;
		this.age = age;
		this.mathScore = mathScore;
		this.koScore = koScore;
		this.enScore = enScore;
	}
	
	public void myInfo() {
		System.out.println(this.name +" " +this.age+" "+" " +this.mathScore+" " +this.koScore+" " +this.enScore);
	}
	
	public double getAvg() {
		return (this.mathScore+this.koScore+this.enScore)/3;
	}
	
	

}
