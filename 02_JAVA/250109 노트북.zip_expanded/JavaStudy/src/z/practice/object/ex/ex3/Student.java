package z.practice.object.ex.ex3;
//Edward 학생이 늦잠을 자서 택시를 타고 학교에 가게 되었다. 택시요금은 10,000,원을 지불했다.
//이 과정을 구현

//1. student클래스에서 Edward의 객체 생성
//2. text클래스 생성

public class Student {
	
	String studentName;
	int grade;
	int money;
	public Student() {
		super();
	}
	
	public Student(String studentName, int grade, int money) {
		super();
		this.studentName = studentName;
		this.grade = grade;
		this.money = money;
	}
	
	public void takeTexi(Texi texi) {
		texi.take(10000);
		this.money -= 10000;

	}
	public void showInfo() {
		System.out.println(this.studentName+"의 남은 돈은"+this.money+"입니다.");
	}


	
	
	

}
