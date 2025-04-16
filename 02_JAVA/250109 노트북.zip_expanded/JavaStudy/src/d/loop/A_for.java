package d.loop;

import java.util.Scanner;

public class A_for {
	/*
	 * <반복문>
	 * 프로그램 흐름을 제어하는 제어문 중 하나.
	 * 어떤 실행코드를 반복적으로 수행시켜준다.
	 * 
	 * 크게 두 종류로 나뉜다.(for  while(do_while))
	 * 
	 * for문
	 * for(초기식; 조건식; 증감식;){ //반복횟수를 지정하기위해 제시하는 것들
	 * 		반복적으로 실행시키고자 하는 코드 더미
	 * }
	 * 
	 * -초기식: 반복문 수행될 때 "처음에 딱 한번만 실행하는 구문"
	 * 			(반복문 안에서 사용 될 변수를 선언및 초기화하는 작업)
	 * 
	 * -조건식: "반복문이 수행될 조건"을 작성하는 구문
	 * 			조건식이 true일 경우 해당 반복을 실행
	 * 			조건식이 false가 되는 순간 반복문을 탈출
	 * 			(초기식에서 제시된 변수를가지고 조건식을 정함)
	 * 
	 * -증감식: 반복문을 제어하는 변수값을 증감시키는 구문
//	 * 			(보통 초기식에 제시된 변수를 가지고 증감을 시킴)
//	 * */
//	public static void main(String[] args) {
//	
//		Scanner sc = new Scanner(System.in);
//		//10번 반복하는 반복문
//		for(int i =0; i<10; i++) {
//			System.out.println(i);
//		}
//		
		/*
		 * n 번 반복하는 for문의  형식
		 for(int i =0; i<10; i++) {
			실행코드
		}
		
//		 * */
//		for(int i = 11; i<=17; i+=2) {
//			System.out.println(i);
//		}
		//1~5까지 숫자를 순차적으로 입력하세요
			
//		for(int i=1; i<=5; i++){
//			System.out.print(i+" ");
//		}
//		
		
		/*
		 * 자바의 지역변수
		 *- 특정 메서드나 블록({})내부에서 선언된다.
		 *-선언된 블록({}) 범위 내에서만 접근이 가능하고 해당 블록이 종료되면 함께 사라진다.
		 * */
		/*
		 * 초기식, 조건식, 증감식을 사용하지 않아도 상관없지만 그렇다면 for문을 사용할 이유가 없다.
		 * */
		
		//5~1까지 순차적으로 출력
//		for(int i = 5;i >= 1; i--) {
//			System.out.print(i+" ");
//		}
//
//		int num;
//		
//		System.out.println("정수를 입력하세요 :");
//		num = sc.nextInt();
//		System.out.println("입력한 값:"+num);
//		for(int i = 1; i <=num; i++) {
//			System.out.print(i);
//		}
//		int count;
//		System.out.println("아메리카노 몇잔을 구매하시겠습니까?(가격 1500) :");
//		count = sc.nextInt();
//		int sum = 0;
//		
//		for(int i = 0; i < count;i++) {
//			sum+=1500;
//			
//		}
//		System.out.println("가격은 "+ sum+"입니다.");
	
	
	//1~10 숫자중 홀수만 출력
//		for(int i = 0; i<=10; i++) {
//			if(i % 2 == 1) {
//				System.out.println("홀수입니다."+i);
//			}
//		}

		//1부터 100까지의 총합
//		int sum = 0;
//		for(int i = 1; i<=100; i++) {
//
//			sum += i;
//			System.out.println(i);
//		}
//		System.out.println(sum);

		//정수 n을 입력받아서 1부터 n까지 1씩 증가하며 모든 수를 더해서 출력해라\
//		int sum =0;
//		System.out.println("정수 입력:");
//		int n = sc.nextInt();
//		for(int i = 1; i<= n; i++) {
//			sum += i;
//		}
//		System.out.println("최종값: "+ sum);

		/*
		 * java.lang.Math 클래스에서 제공하는 random()함수를 호출하면 매번 다른 랜덤값을 받을 수 있다.
		 * 
		 * Math.random() 호출 시 ->0.0~0.999999999999999사이의 랜덤값을 반환
		 * 
		 * int num = Math.random(); // double형의 random함수이기 때문에 int로 받을 수 없음
		 * int num = (int)Math.random(); -> i무조건 0
		 * -> 0.0부터 0.9999999999999이기때문
		 * int num = (int)(Math.random() * 10) +1;
		 * 최소값~ 최대값 사이의 랜덤 수 : (int)(Math.random()*(최대값+1-최소값)) + 최소값

		 * 
		 * */
//		int num = (int)(
//				Math.random() * 10);
//		System.out.println(num);
//		int n = (int)(Math.random() *10 + 30
//		
		
		
		//random(1~10)한 숫자 n을 생성해서 1부터 n까지 모두 더한 값을 출력
//		int sum = 0;
//		int num = (int)(Math.random() *10) +1;
//		System.out.println("random 수:"+num);
//		for(int i= 1; i<=num; i++) {
//			sum += i;
//		}
//		System.out.printf("1부터 %d까지의 합:%d\n",num,sum);
//		System.out.println("1부터"+num+"까지의 합:"+ sum);
//		
		//random (5~50)한 숫자 n을 생성 후 1부터 n까지의 수중 짝수만 출력
//		int num = (int)(Math.random()* 46)+5;
//		System.out.println("random생성된 수:"+num);
//		for (int i = 1; i<=num;i++) {
//			if(i% 2 != 1){
//				System.out.print(i);
//			}
//		}
		
//		String str = "Hello";
		/*
		 * 각 인덱스별 문자 출력
		 * str.charAt(0); -> H
		 * str.charAt(1); -> e
		 * str.charAt(2); -> l
		 * str.charAt(3); -> l
		 * str.charAt(4); -> o
		 * index반복 -> 0~(길이-1)
		 * 
		 * 문자열 길이: 
		 * 
		 * 
		 * 
		 * */
				
//		System.out.println("길이" +str.length());
//		for(int i=0; i<str.length(); i++) {
//			System.out.println(str.charAt(i));
//		}
		
		//사용자에게 문자열을 입력받아 해당 문자열의 짝수자리 글자만 출력
		//문자열 입력:
//		String str;
//		System.out.println("문자열 입력: ");
//		str = sc.next();
//		
//		for(int i =0; i<str.length(); i++) {
//			if (i % 2 != 0) {
//			System.out.print(str.charAt(i));
//			}
//		}

		/*
		 * 2*1 =2
		 * 2*2 =4
		 * 2*3 =6
		 * 2*4 =8
		 * 2*5 =10
		 * 2*6 =12
		 * 2*7 =14
		 * 2*8 =16
		 * 2*9 =18
		 * 
		 * */
//		for(int i =2; i<=9; i++) {
//			for(int j= 1; j<=9;j++) {
//				System.out.printf("%d*%d=%d\n",i,j,i*j);
//			}
//		}
		
		
	
		
	
	
}
