package z.practice.object.ex3;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		//choi객체 생성 최지원, 15살, 수학 : 80, 영어 60, 국어 90
		//kim객체 생성 김민수 17살 수학 60 영어 75  수학 60
		//park 생성 박지민, 19살 수학90  영어45  수학 90
		
		Student choi = new Student("최지원", 15, 80, 60, 90);
		Student kim = new Student("김민수", 17, 60, 75, 60);
		Student park = new Student("박지민", 19, 90, 45, 90);
		
		choi.myInfo();
		kim.myInfo();
		park.myInfo();
		
		//각 항생의 평균을 구하세요.
		
		choi.getavg();
		kim.getavg();
		park.getavg();
		
		System.out.println(choi.name+choi.getavg());
		System.out.println(kim.name +kim.getavg());
		System.out.println(park.name + park.getavg());
		
//		double choiavg = (choi.mathScore + choi.enScore + choi.koScore) /3.0;
//		double kimavg = (kim.mathScore + kim.enScore + kim.koScore) /3.0;
//		double parkavg = (park.mathScore + park.enScore + park.koScore) /3.0;
//		System.out.println(choi.name+choiavg);
//		System.out.println(kim.name +kimavg);
//		System.out.println(park.name + parkavg);
		
		
		String name;
		int age;
		double enScore;
		double mathScore;
		double koScore;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 입력:");
		name = sc.next();
		System.out.println("나이 입력:");
		age = sc.nextInt();
		System.out.println("영어점수: ");
		enScore = sc.nextDouble();
		System.out.println("수학점수: ");
		mathScore = sc.nextDouble();
		System.out.println("국어점수: ");
		koScore = sc.nextDouble();
		
		Student lee = new Student(name, age, enScore, mathScore, koScore);
		
		System.out.println(lee.getavg());
		

		//사용자로부터 이름, 나이, 영어점수, 수학점수, 국어점수를 입력받아
		//lee라는 객체를 만들 것이다.
		//평균을 구해서 출력하는 프로그램 작성
	
	//kh 대학교 evgcut = 75 , encut:60, kocut : 60
		
		University kh = new University("kh대학교", 75, 60, 60);
		
		kh.apply(lee);
		kh.apply(choi);
		kh.apply(kim);
		kh.apply(park);
	
	}
}
