package c.control;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 나이를 입력받아 
		 * 13세이하면 : 어린이
		 * 13세 초과 19세 이하 : 청소년
		 * 13세 초과 :성인
		 * 
		 * [출력문]
		 * 나이를 입력하세요 : 
		 * xx세는 xxx에 속합니다.
		 * 
		 * */
//		
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("나이를 입력하세요 :");
//		int num = sc.nextInt();
//		
//		if (num <= 13) {
//			System.out.println(num +"세는 어린이에속합니다.");
//		}else if(num <=19) {
//			System.out.println(num+"세는 청소년에속합니다.");
//		}else
//			System.out.println(num+"세는 성인에속합니다.");

	
	/*
	 * 성별은 (m/f)(대소문자 상관x) 로 입력받아 남학생인지 여학생인지 
	 * 출력하는 프로그램을 작성하시오.
	 * 
	 * [출력문]
	 * 성멸(m/f) : x
	 * 여학생입니다. /남학생입니다./잘못입력하셨습니다.
	 * 
	 * 
	 * 
	 * */
//	
//	char gender;
//	
//	System.out.print("성별(m/f) :");
//	gender = sc.next().charAt(0);
//	
//	if(gender == 'm' || gender == 'M') {
//		System.out.println("여학생입니다.");
//	}else if(gender == 'f' || gender =='F') {
//		System.out.println("남학생입니다.");
//	}else {
//		System.out.println("잘못입력하셨습니다.");		
//	}
	/*
	 * 정수(양수)를 입력받아서 
	 * 짝수인지 홀수인지 출력하는 프로그램을 작성하라
	 * 
	 * [출력문]
	 * 정수 입력 : xx
	 * 짝수다 / 홀수다/ 양수가 아니다.
	 * */
	
	int num;
	
	System.out.println("정수 입력:");
	num = sc.nextInt();
	
	if(num%2 == 0 ) {
		System.out.println("짝수다.");
	}else if(num%2 ==1) {
		System.out.println("홀수다");
	}else
		System.out.println("양수가 아니다.");
	}
}























