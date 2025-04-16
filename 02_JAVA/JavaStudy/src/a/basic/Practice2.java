package a.basic;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 키보드로 정수 두개를 입력받아 두 수의 합, 차, 곱, 나누기 값을 출력
	 * 
	 * 첫번째 정수 : (키보드 입력)
	 * 두번째 정수 : (키보드 입력)
	 * 
	 * 더하기 : n
	 * 빼기 : n
	 * 곱하기 : n
	 * 나누기 : n
	 * 
	 * */
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력:");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 정수 입력:");
		int num2 = sc.nextInt();
		
		
		int res1 = num1 + num2;
		int res2 = num1 - num2;
		int res3 = num1 * num2;
		int res4 = num1 / num2;
		
		System.out.println("더하기 :"+res1);
		System.out.println("빼기 :"+res2);
		System.out.println("곱하기 :" +res3);
		System.out.println("나누기 : "+res4);
		

	}
}
