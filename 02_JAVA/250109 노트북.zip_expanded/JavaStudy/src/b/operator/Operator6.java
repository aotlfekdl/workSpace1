package b.operator;

import java.util.Scanner;

/*
	 * 삼항연산자
	 * [표현식]
	 * 조건식 ? 조건이 참일경우 결과값 : 조건이 거짓일 경우 결과값
	 * 
	 * 이때, 조건식은 반드시 true또는 false가 나오는 논리값이어야한다.
	 * 주로 비교, 논리연산자를 통해 작성
	 * 
	 * 
	 * */
	
public class Operator6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = (3>10) ? 10: 20;
		int num1,num2;
		
		//입력받은 정수값이 양수인지 아닌지 판별 후 출력해라
		System.out.print("정수값을 입력하세요:");
		num1 = sc.nextInt();
		
		String res = (num1 == 0) ? "0" :((num1 > 0) ? "양수": "음수");
		System.out.println("입력한 정수는"+ res + "입니다");
		
		
		
		
	}

}
