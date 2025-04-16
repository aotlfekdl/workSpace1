package a.basic;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		
		/*
		 * 키보드로 가로, 세로값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력
		 * 면정 : 가로*세로
		 * 둘레: (가로+세로) * 2
		 * 
		 * [출력창]
		 * 가로 : (키보드로 입력)
		 * 세로 : (키보드로 입력)
		 * 
		 * 면적 : ~
		 * 둘레 : ~
		 * + 소수점 2번째 자리까지만 출력
		 * 
		 * */
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("가로:");
		float num1 = sc.nextFloat();
		System.out.print("세로:");
		float num2 = sc.nextFloat();
		
		float res1 = (num1 * num2);
		float res2 = (num1+ num2) * 2;
		System.out.println("면적: %.2f" +res1);
		System.out.println("둘레: %.2f" +res2);
		
	}
}
