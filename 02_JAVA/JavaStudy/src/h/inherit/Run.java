package h.inherit;

import java.util.Scanner;

public class Run {
	/*
	 * 상속이란 
	 * 부모클래스의 필드와 메소드를 자식클래스에서 그대로 이어받아 사용하는것
	 * (실제로 상속된 클래스를 통해서 객체생성시 부모클래스의 객체도 생성이 된다.)
	 * 
	 * 상송의 장점
	 * -적은양의 코드로 새로운 클래스를 정의하고 사용할 수 있다. (생산성이 좋아진다.)
	 * -코드를 공통으로 관리하기 떄문에 코드의 추가나 변경이 용이하다(유지보수성이 좋음)
	 * 
	 * 상속의 특징
	 * -클래스간의 다중상속은 불가(부모는 하나다.)
	 * -부모클래스의 정의되어있는 protecxted필드는 자식클래스에서 직접 접근이 가능하다.(private는 불가)
	 * -자식객체는 부모클래스에 있는 메서드와 필드를 마치 내것처럼 호출할 수 있다.(this.로 호출)
	 * +부모클래스의 정의된 기능이 마음에 들지 않는다면 내 마음대로 수정할 수 있음(오버라이딩)
	 * -명시되어있찌 않지만 모든 클래스(자바에서 제공하는 클래스, 직접만든 클래스)는 object 클래스의 후손이다.
	 * 		->object에 있는 메서드를 마음대로 호출해서 사용할 수 있다.=> 오버라이딩도 가능하다. 
	 * */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Man man1 = new Man("최지원");
		man1.tellYourName();
		
		BusinessMan man2 = new BusinessMan("최지원","강사","chlwldn");
		man2.setName("최지원");
		man2.tellYourName();
	
	}
}
