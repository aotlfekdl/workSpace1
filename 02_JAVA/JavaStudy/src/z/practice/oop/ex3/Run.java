package z.practice.oop.ex3;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		//다음과 같은 코드를 실행했을 떄 예시와 같은 결과가 출력되도록 TV클래스를 작성하세요
		Scanner sc = new Scanner(System.in);


		Tv myTV = new Tv("삼성", 2020, 65, 100000);
	 	myTV.show();
	 	Tv myTV2 = new Tv("LG", 2024, 85, 500000);
	 	myTV2.show();
	
	 	
		Human one = new Human("최지원", 1000000);
		one.buy(); 
	}

}
