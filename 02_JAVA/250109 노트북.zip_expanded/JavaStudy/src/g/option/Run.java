package g.option;

import java.util.Scanner;

public class Run {
/*
 *  pacakge
 *  클래스간의 공간적 충돌이나 접근방법의 충돌을 막기위해
 *  저장위치를 구분하여 명확하게 접근할 수 있도록 해주는 것
 *  보통 네이밍 방법은 회사 도메인 역순으로 입력한다.
 *  도메인 : www.kh.com
 *  패키지 : com.kh.팀명(또는 프로젝트명)
 * */

	
/*
 * static이란 '정적인', '고정적인'이라는 의미를 가진다.
 * static변수와 static메서드는 정적메모리를 사용하여 프로그램 실행시점에 따로 객체생성없이
 * 메모리가 생성되며, 이를 모든 객체가 공유해서 사용한다.
 * 
 * 클래스(static)변수  : 한 클래스에서 공통적인 값을 유지해야할 때 사용 
 * 클래스(static)메서드 : 인스턴스 변수를 사용할 수 없으므로 인스턴스와 관계없는 메서드를 클래스메서드로 사용한다.
 * */	
	
	 
	public static void main(String[] args) {
		 /*
		Book b1 = new Book("이게 되네?", "IT","오힘찬", 100);
		Book b2 = new Book("Easy!딥러닝", "IT", "혁펜하임",200);
		Book b3 = new Book("혼자 공부하는 컴퓨터 구조", "IT", "강민철",300);
		
		System.out.println(b1.getTitle());
		System.out.println(b2.getTitle());
		System.out.println(b3.getTitle());
	
		b1.setMaxPage(50);
		b2.setMaxPage(-50);
		
		System.out.println(b1.getMaxPage()+ " " + b2.getMaxPage());
*/
		/*
		Human h1 = new Human("최지원", 19);
		Human h2 = new Human("최지이", 20);
		Human h3 = new Human("최지삼", 21);
		System.out.println(h1.count);
		System.out.println(h2.count);
		System.out.println(Human.count);
		*/
		Scanner sc = new Scanner(System.in);
		Human[] humanList = new Human[3];
		
		for(int i = 0; i<humanList.length; i++) {
			System.err.print("이름을 입력하세요: ");
			String name = sc.next();
			
			System.out.print("나이를 입력하세요");
			int age = sc.nextInt();
			
			humanList[i] = new Human(name, age);
			
		}
		
		for(Human h : humanList) {
			System.out.println(h.getName()+ h.getAge());
		}
		System.out.println(Human.count);
		
		
}
		
	
	
	
	
	

}
