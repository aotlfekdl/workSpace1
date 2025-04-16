package o.collection.set;

import java.util.Objects;

public class Student {
	private String name;
	private int age;
	private int score;
	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public Student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public int hashCode() {
		//return Objects.hash(name, age); //방법 1 -> Objects를 이용해서 hash메서드에 비교를 원하는 값을 전부 전달
		return ("" + name + age).hashCode();//방법 2-> String의 hashCode메서드 이용
	}
	@Override
	public boolean equals(Object obj) { //현재객체와 전닯다은 객채ㅔ의 각 필드값들이 모두 같은지 비교
		//htis -> 현재 객체 <-> obj -> 전달받은 객체
		if(obj instanceof Student) {
			Student other = (Student)obj;
			if(this.name.equals(other.getName()) &&
					this.age == other.getAge()) {
				return true;
			}
		}
		return false;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	
	
}
