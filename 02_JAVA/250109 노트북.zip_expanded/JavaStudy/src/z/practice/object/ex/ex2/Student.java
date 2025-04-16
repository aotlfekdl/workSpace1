package z.practice.object.ex.ex2;

public class Student {
	public String studentName; //이름
	public int grade;  // 학년
	public int money; // 돈
	public Student() {
		super();
	}
	public Student(String studentName, int grade, int money) {
		super();
		this.studentName = studentName;
		this.grade = grade;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		bus.take(1000);
		money -=1000;
	}

	public void takeSubway(Subway subway) {
		subway.take(1500);
		money -=1500;
	}
		

	public void showInfo() {
		System.out.println(this.studentName + "님의 남은 돈은"+this.money+"입니다.");
	}
	
	
}
