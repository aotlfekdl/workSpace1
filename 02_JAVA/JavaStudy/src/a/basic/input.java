package a.basic;

import java.util.Scanner;
//1) Scanner를 사용하기 위해 외부로부터 가져온다.

public class input {
	/*
	 * 키보드로 값을 입력하는 방법
	 * Scanner를 사용한다.
	 * (java.util.Scanner 클래스를 이용한다.)
	 * 
	 * 사용하면 따로 우리가 데이터를 입력하여 사용할 수 있음
	 * 거의 scanf와 비슷
	 * 
	 * [사용법]
	 * Scanner 이름 = new Scanner(System.in);
	 * ex) Scanner sc = new Scanner(System.in);
	 * 
	 * */
	
	public static void main(String[] args) {
		int num = 10;
		Scanner sc = new Scanner(System.in);
		
//		String str1, str2;
//		
//		System.out.print("입력해주세요 : ");
//		str1 = sc.next();
//		str2 = sc.nextLine();
//		
//		
//		System.out.println("str1에 입력한 값: " + str1);
//		System.out.println("str2에 입력한 값: "+ str2);
//	
		System.out.println("============================================================================");
		String name;
		String test;
		int age;
		float height;
		
		System.out.println("이름을 입력하세요 : ");
		name = sc.next();
		sc.nextLine(); // 버퍼에서 \n(엔터값)을 비워주는 코드
//		
//		System.out.println("test에 들어갈 값을 입력하세요 : ");
//		test = sc.next();
//		
		System.out.print("나이를 입력하세요:");
		age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("키를 입력하세요 :");
		height = sc.nextFloat();
		sc.nextLine();
		
//		System.out.println("이름 : " + name + "test: "+ test);
		System.out.println("이름을 입력하세요:");
		System.out.println("나이를 입력하세요:");
		System.out.println("키를 입력하세요:");
	
		System.out.println("이름 : " +name);
		System.out.println("키:" + height);
		System.out.println("나이:" + age);
		
		sc.close(); //Scanner자원을 반납한다. *한번 반납하면 다시 사용할 수 없음
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
