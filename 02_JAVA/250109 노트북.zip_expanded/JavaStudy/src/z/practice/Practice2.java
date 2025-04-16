package z.practice;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
/*

	 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.

	단, 입력한 수는 1보다 크거나 같아야 합니다. 

	1 미만의 숫자가 입력됐다면 

	“1 이상의 숫자를 입력해주세요”가 출력되면서 다시 사용자가 값을 입력하도록 하세요

	ex.
	1이상의 숫자를 입력하세요 : 4			1이상의 숫자를 입력하세요 : 0
	1 2 3 4 						1 이상의 숫자를 입력해주세요.
									1이상의 숫자를 입력하세요 : 8
									1 2 3 4 5 6 7 8 
	*/
		/*
		System.out.println("1이상의 숫자를 입력해주세요:");

		while(true) {
			int num = sc.nextInt();
			if(num >=1) {
				for(int i=1; i<= num; i++) {
					System.out.print(i+" ");
				}
					
				}else {
					System.out.println("1이상의 숫자를 입력해주세요:");
					
			}
		}
	}
	*/
		
		
		/* 이 방법과
		int num;		
		
		do {
			System.out.println("1이상의 숫자를 입력해주세요:");
			num = sc.nextInt();
					for(int i=1; i<= num; i++) {
						System.out.print(i+" ");
					}
			}while(num <=0);
	}
	*/
		//===============================================================================================================
		//===============================================================================================================



	



	/*



		 사용자에게 관리자, 회원, 비회원 중 하나를 입력 받아 각 등급이 행할 수 있는 권한을 출력하세요.
		단, 관리자는 회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		회원은 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		비회원은 게시글 조회만 가능합니다.

		ex.

		권한을 확인하고자 하는 회원 등급 : 관리자
		회원관리 게시글관리 게시글작성 댓글작성 게시글조회 
		 */
		/*
		String str;
		System.out.print("권한을 확인하고자 하는 회원 등급 :\n");
		str = sc.next();
		switch(str) {
		case "관리자":

			System.out.println("회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성");
			break;
			case "회원":
			System.out.println("게시글 작성, 게시글 조회, 댓글작성");
			break;
		case "비회원":
			System.out.println("게시글 조회");
			break;
		default :
			System.out.println("해당하는 회원 등급이 없습니다.");
			}

		*/
		//===============================================================================================================

		//===============================================================================================================

	/*

		 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.

		만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.

		ex.

		첫 번째 숫자 : 8	첫 번째 숫자 : 4	첫 번째 숫자 : 9
		두 번째 숫자 : 4 	두 번째 숫자 : 8 	두 번째 숫자 : 0

		4 5 6 7 8 		4 5 6 7 8 		1 이상의 숫자를 입력해주세요.

		 */
		/*
		int n1, n2;
		System.out.print("첫 번째 숫자 :\n");
		n1 = sc.nextInt();
		System.out.print("두 번째 숫자 :\n");

		n2 = sc.nextInt();

		if(n1 > 0 && n2 > 0) {
			if(n1<n2) {
				for(int i= n1, j = n2; n1<=n2;n1++) {
					System.out.println(n1);
				}
			}else if(n1>n2) {
				for(int i= n1, j = n2; n1 >= n2;n2++) {
					System.out.println(n2);
			}
			}
		}else {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}
		 */
		/*
		int n1, n2, max, min;
		System.out.print("첫 번째 숫자 :\n");
		n1 = sc.nextInt();
		System.out.print("두 번째 숫자 :\n");
		n2 = sc.nextInt();
		
		max = n1 > n2 ? n1 : n1;
		min = n1 < n2 ? n1: n2;
		for(int i = min; i <= max; i++) {
			System.out.println(i);
		}
		
		*/

		
		
//===============================================================================================================		
//===============================================================================================================
		/*
		  사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
			단, 9를 초과하는 숫자가 들어오면 “9 이하의 숫자만 입력해주세요”를 출력하세요.
			숫자 : 4				숫자 : 10

			===== 4단 ===== 			9 이하의 숫자만 입력해주세요.

			===== 5단 =====

			===== 6단 =====

			===== 7단 =====

			===== 8단 =====

			===== 9단 =====
			(해당 단의 내용들은 길이 상 생략)
		 */
		/*
		 * 

		int num;
		System.out.print("숫자:\n");
		num = sc.nextInt();

		if(num <10) {
			for(int i = num; i <= 9; i++) {
				System.out.printf("====%d단====\n",i);
				for(int j =2; j<=9; j++)
					System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
		}else {
			System.out.println("9이하의 숫자만 입력해주세요");
		}

//===============================================================================================================		
//===============================================================================================================		
		*/
		 /*
		 	길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 
			순서대로 배열 인덱스에 넣은 후 그 값을 출력하세요.
			ex.
			1 2 3 4 5 6 7 8 9 10 
		 */
		/*
		int[] arr = new int[10];
		for(int i = 0, j=1; i<10; i++,j++){
			arr[i] = j;
			System.out.println(arr[i]);
		}
		/*
		for(int i = 0; i<10; i++){
			arr[i] = index +1;;
			System.out.println(arr[i]);
			*/

		//i가 0일때 i는 1부터 시작...
		//===============================================================================================================		
		//===============================================================================================================				
	 
		/*
		 	사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고 
			1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요
		
		ex.
			양의 정수 : 5
			1 2 3 4 5 
		 */
		/*
		int num;
		System.out.print("양의 정수:");
		num =sc.nextInt();
		int[] arr = new int[num];
//		arr[0] =1;
//		arr[1] =2;
//		arr[2] =3;
//		arr[3] =4;
//		arr[4] =5;
//		
		for(int i= 0, j=1; i<num;i++,j++) {
			arr[i] =j;
			System.out.print(arr[i]+ " ");
			}
		*/

/*
 * for(int i= 0; i<num;i++) {
			arr[i] =i+1;
			System.out.print(arr[i]+ " ");
			}
 */
		//===============================================================================================================		
		//===============================================================================================================				
		/*
			문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지
			개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.--실패
			--실패
			ex.
			문자열 : application
			문자 : i
			application에 i가 존재하는 위치(인덱스) : 4 8 
			i 개수 : 2
		 */
		/*
		 * 
		 */
		/*
				String str;
				char ch;
				System.out.print("문자열 입력:");
				str = sc.next();
				
				System.out.print("문자:");
				ch = sc.next().charAt(0);
				int count=0;
				
				
				char[] chArr = new char[str.length()];

				for(int i =0; i <str.length(); i++) {
					chArr[i] = str.charAt(i);
				}
				for(int i = 0; i<str.length(); i++) {
					if(chArr[i] == ch) {
						System.out.println(i+ " ");
						count ++;
					}
					
				}
				System.out.println();
				System.out.println(ch+"개수 :" + count);
	/*
		/*

		String str;
		System.out.print("문자열:\n");
		str = sc.next();
		char[] charArr = new char [str.length()];
		for(int i = 0; i< charArr.length; i++) {
			charArr[i] = str.charAt(i);
			System.out.print(charArr[i]);
		}		
		String ch;
		System.out.println("문자: \n");
		ch = sc.next();
		for(int i=0;i <= charArr.length;i++) {
			System.out.println(charArr[i]); 
		}			
		*/
		 /*
		 “일“ ~ “토”까지 초기화된 문자열 배열을 만들고 0부터 6까지 숫자를 입력 받아
			입력한 숫자와 같은 인덱스에 있는 요일을 출력하고 
			범위에 없는 숫자를 입력 시 “잘못 입력하셨습니다“를 출력하세요.
			ex.
			0 ~ 6 사이 숫자 입력 : 4			0 ~ 6 사이 숫자 입력 : 7
			목요일						    잘못 입력하셨습니다.
				// 일 월 화 수 목 금 토
		 */
	/*
		char[] day = new char[7];
		int num;
		System.out.println("0~6 사이 숫자 입력: ");
		num = sc.nextInt();
		day[0] = '일';
		day[1] = '월';
		day[2] = '화';
		day[3] = '수';
		day[4] = '목';
		day[5] = '금';
		day[6] = '토';
		if(num >= 0&& num<= 7){
			System.out.println(day[num]);
		}else{
		System.out.println("잘못입력하셨습니다.");
		*/
		//===============================================================================================================		
		//===============================================================================================================				
		 /*
		 4행 4열짜리 정수형 배열을 선언 및 할당하고
			1) 1 ~ 16까지 값을 차례대로 저장하세요.
			2) 저장된 값들을 차례대로 출력하세요.
		ex.
		 1  2  3  4 
		 5  6  7  8 
		 9 10 11 12 
		13 14 15 16 
		 */
		/*
		int[][] arr = new int[4][4];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[0][3] = 4;
		arr[1][0] = 5;
		arr[1][1] = 6;
		arr[1][2] = 7;
		arr[1][3] = 8;	
		for(int i = 0; i<4; i++) {
			arr[i]=i;
		}
		*/
		/*
		int a= 1;
		int[][] arr= new int[4][4];
		for(int i = 0; i<4; i++) {
			for(int j=0; j<4; j++,a++) {
				arr[i][j] = a;
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		//arr.length -> arr이 2차원 배열일 때 length는 1차원 배열의 개수를 나타낸다.
		물어볼것 2차원 배열에서 1차원배열 중 [1,2,3,4] [5,6] [7,8,9],[10,11,12,13,14,15,16] 반복문으로 저장하고 출력해라
		int[][] arr = {{1,2,3,4}
						{1,2}
						{7,8,9}
						{10,11,12,13,14,15,16}}; //이 방법으로는 가능한데 배열로 하는 방법은?
		2차원 배열에 넣는 방법은?
		
		
		
		
		
		*/
		//===============================================================================================================		
		//===============================================================================================================				
		/*
		for(int i = 0; i<4;i++) {
			for(int j = 0,a=1; j<4; j++,a++) {
				arr[i][j]= a;
				System.out.print(arr[i][a]);
			}
			System.out.println();
		}
		*/
		 /*
		 4행 4열짜리 정수형 배열을 선언 및 할당하고
			1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
			2) 저장된 값들을 차례대로 출력하세요.
		ex.
		16 15 14 13 
		12 11 10  9 
		 8  7  6  5 
		 4  3  2  1 
		*/
		/*
		int[][] arr= new int[4][4];
		int a= 16;
		for(int i= 0; i<4; i++) {
			for(int j = 0; j< 4; j++) {
				arr[i][j] = a;
				System.out.print(arr[i][j]+ " ");
				a--;	
			}
			System.out.println();
		}
		*/
		//===============================================================================================================		
		//===============================================================================================================				
	 /*
		 주민번호를 이용하여 남자인지 여자인지 구분하여 출력하세요.
			ex.
			주민번호를 입력하세요(- 포함) : 132456-2123456
			여
		 */
		/*
		String str;
		System.out.print("주민번호를 입력하세요(-포함)");
		str = sc.next();
		char[] charArr = new char[str.length()];
		for(int i=0; i<charArr.length; i++) {
			charArr[i] = str.charAt(i);
			System.out.print(charArr[i]);
		}
		System.out.println();
		if(charArr[7] == '2' || charArr[7] =='4') {
			System.out.println("여자");
		}else if(charArr[7] == '1' || charArr[7] =='3'){
			System.out.println("남자");
		}else{
			System.out.println("잘못입력하셨습니다.");
		*/
		//===============================================================================================================		
		//==============================================================================================================				
		/*
		System.out.print(charArr);
		boolean a= true;
		boolean b= false;
		System.out.println(charArr[7]==2);		
		System.out.println(charArr[7]=='2');
	*/
		/*
		 A, B, C 사원의 연봉을 입력 받고 각 사원의 연봉과 인센티브를 포함한 연봉을 계산하여 출력하고 
			인센티브 포함 급여가 3000만원 이상이면 “3000 이상”, 미만이면 “3000 미만”을 출력하세요.
			(A 사원의 인센티브는 0.4, B 사원의 인센티브는 없으며, C 사원의 인센티브는 0.15)
			ex.
			A사원의 연봉 : 2500
			B사원의 연봉 : 2900
			C사원의 연봉 : 2600
			A사원 연봉/연봉+a : 2500/3500.0
			3000 이상
			B사원 연봉/연봉+a : 2900/2900.0
			3000 미만
			C사원 연봉/연봉+a : 2600/2989.9999999999995
			3000 미만
		 */
/*
		float a, b, c;
		System.out.print("A사원의 연봉: ");
		a = sc.nextFloat();
		System.out.print("B사원의 연봉: ");
		b = sc.nextFloat();
		System.out.print("C사원의 연봉: ");
		c = sc.nextFloat();
		float a1, b1, c1;
		a1 = a+ a*0.4f;
		b1 = b+b*0f;
		c1 = c+c*0.15f;
		System.out.printf("A사원의 연봉/연봉+a: %.1f/%.1f\n",a,a1);
		if(a1>= 3000) {
			System.out.println("3000만원 이상");
		}else {
			System.out.println("3000만원 이하");
		}
		System.out.printf("B사원의 연봉/연봉+a: %.1f/%.1f\n",b,b1);
		if(b1>= 3000) {
			System.out.println("3000만원 이상");
		}else {
			System.out.println("3000만원 이하");
		}	
		System.out.printf("C사원의 연봉/연봉+a: %.1f/%.1f\n",c,c1);
		if(c1>= 3000) {
			System.out.println("3000만원 이상");
		}else {
			System.out.println("3000만원 이하");
		}	
//===============================================================================================================		
//===============================================================================================================				
 */
	 /*
	 	키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라 
		저체중/정상체중/과체중/비만을 출력하세요.
		BMI = 몸무게 / (키(m) * 키(m))
		BMI가 18.5미만일 경우 저체중  /  18.5이상 23미만일 경우 정상체중
		BMI가 23이상 25미만일 경우 과체중  /  25이상 30미만일 경우 비만
		BMI가 30이상일 경우 고도 비만
		ex.
		키(m)를 입력해 주세요 : 1.65
		몸무게(kg)를 입력해 주세요 : 58.4
		BMI 지수 : 21.45087235996327
		정상체중
	 */

/*
		double high, kg, bmi;
		System.out.print("키(m)를 입력해주세요 :");
		high = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해주세요 :");
		kg = sc.nextDouble();
		bmi = kg / (high*high);
		System.out.print("BMI 지수:"+ bmi);
		if(bmi <18.5) {
			System.out.println("저체중");
		}else if(bmi<23) {
			System.out.println("정상체중");
		}else if(bmi<25) {
			System.out.println("과체중");
		}else if(bmi<30) {
			System.out.println("비만");
		}else {
			System.out.println("고도비만");
		}
*/
//===============================================================================================================		
//===============================================================================================================
		/*
 	중간고사, 기말고사, 과제점수, 출석회수를 입력하고 Pass 또는 Fail을 출력하세요.
	평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
	이 때, 출석 비율은 출석 회수의 총 강의 회수 20회 중에서 출석한 날만 따진 값으로 계산하세요. 
	70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.
	ex 1.
	중간 고사 점수 : 80
	기말 고사 점수 : 30
	과제  점수 : 60
	출석 회수 : 18
	================= 결과 =================
	중간 고사 점수(20) : 16.0
	기말 고사 점수(30) : 9.0
	과제 점수       (30) : 18.0
	출석 점수       (20) : 18.0 
	총점 : 61.0
	Fail [점수 미달]
 */
		/*
		float score1, score2, score3, n;
		System.out.print("중간 고사 점수:");
		score1 = sc.nextFloat();
		System.out.print("기말 고사 점수:");
		score2 = sc.nextFloat();
		System.out.print("과제 점수:");
		score3 = sc.nextFloat();
		System.out.print("출석 횟수:");
		n = sc.nextFloat();
		System.out.println("================= 결과 =================");
		float score11, score22, score33, sum;
		score11 = score1 *0.2f;
		score22 = score2 * 0.3f;
		score33 = score3 * 0.3f;
		sum = score11 + score22 + score33+ n;

		

		System.out.printf("중간 고사 점수(20): %.1f\n", score11);

		System.out.printf("기말 고사 점수(30): %.1f\n", score22);

		System.out.printf("과제 점수(30): %.1f\n", score33);

		System.out.printf("출석 점수(20): %.1f\n", n);

		System.out.printf("총점 : %.1f", sum);

		

		if(sum<70) {

			System.out.println("Fail [점수미달]");

		}else if(n<=20*0.3){

			System.out.println("Fail [출석 횟수 미달]");

		}else if(sum>=70 && n>= 20*0.3) {

			System.out.println("Pass");

		}

		*/

		//===============================================================================================================		
		//===============================================================================================================
 /*
	 	정수 두 개와 연산자를 입력 받고 입력된 연산자에 따라 알맞은 결과를 출력하세요.
		단, 해당 프로그램은 연산자 입력에 “exit”라는 값이 들어올 때까지 무한 반복하며
		exit가 들어오면 “프로그램을 종료합니다.”를 출력하고 종료합니다.
		또한 연산자가 나누기이면서 두 번째 정수가 0으로 들어오면 
		“0으로 나눌 수 없습니다. 다시 입력해주세요.”를 출력하며,
		없는 연산자가 들어올 시 “없는 연산자입니다. 다시 입력해주세요.”라고 출력하고 
		두 경우 모두 처음으로 돌아가 사용자가 다시 연산자부터 입력하도록 하세요.
		연산자(+, -, *, /, %) : +
		정수1 : 10
		정수2 : 4
		10 + 4 = 14
		연산자(+, -, *, /, %) : /		  연산자(+, -, *, /, %) : /
		정수1 : 10 				      정수1 : 10
		정수2 : 4 				      정수2 : 0
		10 / 4 = 2				      0으로 나눌 수 없습니다. 다시 입력해주세요.
		연산자(+, -, *, /, %) : ^ 	  연산자(+, -, *, /, %) : exit
		정수1 : 10 				      프로그램을 종료합니다.
		정수2 : 4
		없는 연산자입니다. 다시 입력해주세요.
	 */
		/*
		String dustks;
		int num1, num2;
		System.out.print("연산자(+,-,*,/,%) : ");
		dustks = sc.next();
		System.out.print("정수 1 : ");
		num1 = sc.nextInt();
		System.out.print("정수 2 : ");
		num2 = sc.nextInt();
		*/
/*		
		String dustks;
		do {
			int num1, num2;
			System.out.print("연산자(+,-,*,/,%) : ");
			dustks = sc.next();
			System.out.print("정수 1 : ");
			num1 = sc.nextInt();
			System.out.print("정수 2 : ");
			num2 = sc.nextInt();
			switch (dustks) {
			case "+" :
				System.out.printf("%d + %d =%d\n",num1,num2,num1+num2);
				break;
			case "-":
				System.out.printf("%d -%d =%d\n",num1,num2,num1-num2);
				break;
			case "*":
				System.out.printf("%d * %d =%d\n",num1,num2,num1*num2);
				break;
			case "/":
				if(num1 ==0 || num2 ==0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요");
					break;
				}else {
					System.out.printf("%d / %d =%d\n",num1,num2,num1/num2);
					break;
				}
			case "%":
				System.out.printf("%d % %d =%d\n",num1,num2,num1%num2);
				break;
			default:
				System.out.println("없는 연산자입니다. 다시 입력해주세요");
				break;

			}

		}while(dustks != "exit");

*/

		//===============================================================================================================		

		//===============================================================================================================



		/*

		String dustks;

		System.out.print("연산자를 입력해주세요:");

		dustks = sc.next();

		

		while(dustks == "exit") {



			int num1, num2;

			System.out.print("연산자(+,-,*,/,%) : ");

			dustks = sc.next();

			

			System.out.print("정수 1 : ");

			num1 = sc.nextInt();

			

			System.out.print("정수 2 : ");

			num2 = sc.nextInt();

			

			switch (dustks) {

			case "+" :

				System.out.printf("%d + %d ="+ (num1 +num2),num1,num2);

				continue;

			case "-":

				System.out.printf("%d -%d ="+(num1-num2),num1,num2);

				break;

			case "*":

				System.out.printf("%d * %d ="+ (num1 * num2),num1,num2);

				break;

			case "/":

				if(num1 ==0 || num2 ==0) {

					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요");

					break;

				}else {

					System.out.printf("%d / %d ="+ (num1 / num2),num1,num2);

					break;

				}

			case "%":

				System.out.printf("%d % %d ="+ (num1 %num2),num1,num2);

				break;

			default:

				System.out.println("없는 연산자입니다. 다시 입력해주세요");

				break;

			}

			

			

		}

		*/



	 /*



		    사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가
			몇 개 있는지 개수를 출력하세요. 
		 	“더 하시겠습니까?”라고 추가로 물어보도록 하세요.
			이 때, N이나 n이 나오면 프로그램을 끝내고 Y나 y면 계속 진행하도록 하되 Y, y, N, n이 아닌 
			다른 문자를 입력했을 경우 “잘못된 대답입니다. 다시 입력해주세요.”를 출력하고 
			더 하겠냐는 물음을 반복하세요.
			ex.
			문자열 : application			 더 하시겠습니까? (y/n) : k
			문자 : a				         잘못된 대답입니다. 다시 입력해주세요.
			포함된 개수 : 2				 더 하시겠습니까? (y/n) : Y
			더 하시겠습니까? (y/n) : y		 문자열 : ant
			문자열 : business			     문자 : b
			문자 : s				         포함된 개수 : 0
			포함된 개수 : 3				 더 하시겠습니까? (y/n) : N
		 */
		/*
		String str;
		char ch;
		while(true) {
			System.out.print("문자열 입력:");
			str = sc.next();
			
			System.out.print("문자:");
			ch = sc.next().charAt(0);
			int count=0;
		
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == ch) {
				System.out.println(i+ " ");
				count ++;
			}
			
		}
		System.out.println(("포함된개수 : "+ count));
		char result;
		System.out.println("더 하시겠습니까?(y/n)");
		result = sc.next().charAt(0);
		
		if(result != 'n' && result != 'n' && result != 'y' &&result != 'Y') {
			System.out.println("잘못입력했습니다. 다시 입력해주세요");
		}else {
			break;
		}
		if(result == 'n' && result == 'N') {}
	}
		
	

*/
		

	/*
		 1부터 100 사이의 정수 중 임의의 난수가 정해지고 사용자는 정해진 난수를 맞추는데 
		 몇 번 만에 맞췄는지 출력하세요.
			ex.
			90
			1~100 사이의 임의의 난수를 맞춰보세요 : 0
			1~100 사이의 숫자를 입력해주세요.
			1~100 사이의 임의의 난수를 맞춰보세요 : 101
			1~100 사이의 숫자를 입력해주세요.
			1~100 사이의 임의의 난수를 맞춰보세요 : 50
			UP !
			1~100 사이의 임의의 난수를 맞춰보세요 : 75
			UP !
			1~100 사이의 임의의 난수를 맞춰보세요 : 83
			UP !
			1~100 사이의 임의의 난수를 맞춰보세요 : 93
			DOWN !
			1~100 사이의 임의의 난수를 맞춰보세요 : 89
			UP !
			1~100 사이의 임의의 난수를 맞춰보세요 : 92
			DOWN !
			1~100 사이의 임의의 난수를 맞춰보세요 : 90
			정답입니다 !!
			7회만에 맞추셨습니다.
		 */

		/*
		int rn =(int)(Math.random()*100) + 1;
		int num;
		int i=0;
		do {
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요 :");
			num = sc.nextInt();
			if(num >=1 && num<=100) {
				if(num > rn) {
					System.out.println("DOWN !");
				}else if(num < rn) {
					System.out.println("up !");
				}else {
					System.out.println("정답입니다 !!");
				}
			}else {
				System.out.println("1~100 사이의 숫자를 입력해주세요.");
			}
			i++;
		}while(num != rn);
		System.out.println(i+"회만에 맞추셨습니다.");
		
*/
		//===============================================================================================================		

		//===============================================================================================================



	/*
		  사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 컴퓨터가 가위인지 보인지 주먹인지는
			랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
			사용자가 “exit”를 입력하기 전까지 가위바위보를 계속 진행하고 “exit”가 들어가면 반복을 멈추고
			몇 번의 승부에서 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.
			당신의 이름을 입력해주세요 : 박신우          가위바위보 : exit
			가위바위보 : 가위                        3전 0승 2무 1패
			컴퓨터 : 가위
			박신우 : 가위
			비겼습니다.	
			가위바위보 : 가위
			컴퓨터 : 바위
			박신우 : 가위
			졌습니다 ㅠㅠ
			가위바위보 : 가위
			컴퓨터 : 가위
			박신우 : 가위
			비겼습니다.
			//컴퓨터에 랜덤으로 "가위,바위,보"중 하나를 부여해야한다.
			//문자열을 랜덤으로 줄 수 없으니 우리는 랜덤 숫자를 부여하자
			//		int com = (int)(Math.random() * 3); //0(가위) 1(바위) 2(보)
			//		gameArr[0] -> 가위
			//		gameArr[1] -> 바위
			//		gameArr[2] -> 보
	 */
		/*
		String name;
		System.out.print("사용자 이름 :");
		name = sc.next();
		String str;
		int n = 0, win=0, loss=0, draw=0;	
		do{
			System.out.print("가위,바위,보: ");
			str = sc.next();

			int[] gameArr = {"가위","바위","보"};

			System.out.print("컴퓨터 : ");
			int rn = (int)(Math.random() * 3) 
			

			if(user.equals(rn)){
			
			switch (str) {
			case "가위" :
				System.out.println(name+" : 가위");
				switch (rn) {
				case 0:
					System.out.println("컴퓨터 : 가위");
					System.out.println("비겼습니다.");
					n++;
					draw ++;
					break;
				case 1:
					System.out.println("컴퓨터 : 바위");
					System.out.println("졌습니다.ㅠㅠ");
					n++;
					loss++;
					break;
				case 2:
					System.out.println("컴퓨터 : 보");
					System.out.println("이겼습니다.");
					win++;
					n++;
					break;
				}
				break;
			case "바위":
				System.out.println(name+" : 바위");
				switch (rn) {
				case 0:
					System.out.println("컴퓨터 : 가위");
					System.out.println("이겼습니다.");
					win++;
					n++;
					break;
				case 1:

					System.out.println("컴퓨터 : 바위");

					System.out.println("비겼습니다.");

					draw++;

					n++;

					break;

				case 2:

					System.out.println("컴퓨터 : 보");

					System.out.println("졌습니다.ㅠㅠ");

					loss++;

					n++;

					break;

				}

				break;

			case "보":

				System.out.println(name+" : 보");

				switch (rn) {

				case 0:

					System.out.println("컴퓨터 : 가위");

					System.out.println("졌습니다.ㅠㅠ");

					loss++;

					n++;

					break;

				case 1:

					System.out.println("컴퓨터 : 바위");

					System.out.println("이겼습니다.");

					win++;

					n++;

					break;

				case 2:

					System.out.println("컴퓨터 : 보");

					System.out.println("비겼습니다.");

					draw++;

					n++;

					break;

				}

			case "exit":

				break;

				

			default : 

				System.out.println("가위, 바위, 보 중에서 입력해주세요");

				break;

			}



		}while(!str.equals("exit"));

		System.out.printf("%d전, %d승, %d무, %d패", n, win, draw, loss);
		*/
/*
		String name;
		System.out.print("사용자 이름 :");
		name = sc.next();
		String str;
		int n = 0, win=0, lose=0, draw=0;	
		do{
			System.out.print("가위,바위,보: ");
			str = sc.next();
			int rn = (int)(Math.random() * 3) + 0;
			int[] gameArr = new int[3];
			gameArr[0] = 0;
			gameArr[1] = 1;
			gameArr[2] = 2;
			switch (str) {
			case "가위" :
				System.out.println(name+" : 가위");
				switch (rn) {
				case 0:
					System.out.println("컴퓨터 : 가위");
					System.out.println("비겼습니다.");
					n++;
					draw ++;
					break;
				case 1:
					System.out.println("컴퓨터 : 바위");
					System.out.println("졌습니다.ㅠㅠ");
					n++;
					lose++;
					break;
				case 2:
					System.out.println("컴퓨터 : 보");
					System.out.println("이겼습니다.");
					win++;
					n++;
					break;
				}
				break;
			case "바위":
				System.out.println(name+" : 바위");
				switch (rn) {
				case 0:
					System.out.println("컴퓨터 : 가위");
					System.out.println("이겼습니다.");
					win++;
					n++;
					break;
				case 1:

					System.out.println("컴퓨터 : 바위");

					System.out.println("비겼습니다.");

					draw++;

					n++;

					break;

				case 2:

					System.out.println("컴퓨터 : 보");

					System.out.println("졌습니다.ㅠㅠ");

					lose++;

					n++;

					break;

				}

				break;

			case "보":

				System.out.println(name+" : 보");

				switch (rn) {

				case 0:

					System.out.println("컴퓨터 : 가위");

					System.out.println("졌습니다.ㅠㅠ");

					lose++;

					n++;

					break;

				case 1:

					System.out.println("컴퓨터 : 바위");

					System.out.println("이겼습니다.");

					win++;

					n++;

					break;

				case 2:

					System.out.println("컴퓨터 : 보");

					System.out.println("비겼습니다.");

					draw++;

					n++;

					break;

				}

			case "exit":

				break;

				

			default : 

				System.out.println("가위, 바위, 보 중에서 입력해주세요");

				break;

			}



		}while(!str.equals("exit"));

		System.out.printf("%d전, %d승, %d무, %d패", n, win, draw, lose);

		//===============================================================================================================		

		//===============================================================================================================

		

		

		*/

	/*	

		System.out.println(rn);

		for(int i=0; i<gameArr.length; i++) {

			System.out.println(gameArr[i]);



		}

		

		String str;

		System.out.print("가위바위 보 :");

		str = sc.next();

		

		

	int rkdnl, qkdnl, qh;

		switch(rn) {

		case qh :

			

		}

		*/


						
	 /*
		 배열에 들어있는 데이터 중 홀수의 값들을 출력하고 합을 구한다. 
		단, continue를 이용하여 작성한다. 
		사용데이터 : int[] array = {1,2,3,4,5,6,7,8,9,10};
		실행결과: 1 
				3 
				5 
				7 
				9 
				합계 : 25.0 
	 */
		/*
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		float sum =0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] %2 == 0) {
				continue;
			}
				System.out.println(array[i]);
			sum += array[i];
		}
		System.out.print("합계 :"+sum);
*/
	//===============================================================================================================		
	//===============================================================================================================
	/*
		 2차원 배열에 들어있는 데이터들의 합계와 평균을 구한다. 
		 데이터 : int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
 */
		/*
		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
		int sum = 0, n=0;
		for(int i = 0; i<array.length; i++) {
			for(int j = 0; j<array.length; j++) {
				System.out.print(array[i][j]+ " ");
				sum += array[i][j];
				n++;
			}
			System.out.println();
		}
		System.out.println("합계 :"+sum);
		System.out.println("평균 :"+sum/n);
*/
		//===============================================================================================================		
		//===============================================================================================================
		/*
		 2차원 배열에 들어있는 데이터중 가장 큰 값과 가장 작은 값을 구한다. 
		 데이터 : int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}}; 
 */
		/*
		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}}; 
		int max=array[0][0];
		int min =array[0][0];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j< array.length; j++) {	
				if(array[i][j]>= max) {
					max = array[i][j];
				}
				if(array[i][j]<=min) {
					min = array[i][j];
				}
			}
		}
		System.out.println(max);
		System.out.println(min);
*/
		//===============================================================================================================		
		//===============================================================================================================
/*
		 2차원 배열에 들어있는 데이터들 중 3의 배수만 골라내서 새로운 1차원배열에 기록하고 출력한다. 
		 단 중복 값은 하나만 기록되게 한다.
		 int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}}; 
		int[] copyAr = new int[array의 행갯수 * 열갯수];-- 나중에 한번 물어보기
		각 행마다 원소개수가 다를 경우
 */
/*

		int [][] array = {
							{12, 41, 36, 56}, 
							{82, 10, 12, 61},
							{14, 16, 18, 78}, 
						    {45, 26, 72, 23}}; 

		int size = 0;
		int copyIndex = 0; //비어있는 index중 가장 작은 값
		for(int i = 0; i < array.length; i++) {
			size += array[i].length;
		}
		
		int[] copyAr = new int[size];
		

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j< array[i].length; j++) {
				if(array[i][j] %3 ==0){
	
					
					//array[i][j]요소가 이미 copyAr에 있는 요소인지 확인
					boolean isDuplication = false; // 중복값이 있는지를 확인할 변수
					for(int k=0; k<copyIndex; k++) {
						if(copyAr[k] == array[i][j]) {
							isDuplication = true;
							break;
							
						}
					}
					if(!isDuplication) {
						copyAr[copyIndex++] = array[i][j];
					}
				}
			}
		}
		System.out.println("copyAr: ");
		for(int val: copyAr) {
			if(val == 0)break;
			System.out.print(val + " ");
		}
					
				*/

		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}}; 

		int n1=0, n2=0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j< array.length; j++) {
				System.out.print(array[i][j]+ " ");
				if(i != 0) {
					continue;
				}
				n1 ++;
			}
			n2++;
		}
		
		System.out.println();
		System.out.println("n1 :"+n1);
		System.out.println("n2 :"+n2);
		int[] copyAr = new int[n1*n2];
		int n3=0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j< array.length; j++) {
				if(array[i][j] %3 ==0) {
					boolean isDuplication = false;
					for(int a = 0; a < array.length; a++) {
							if(copyAr[a] == array[i][j]) {
								isDuplication = true;
								break;
							}
						}
					if(isDuplication == false) {
						copyAr[n3] = array[i][j];
						n3++;
					}
					
				}
			}
		}
		
		System.out.println("copyAr:");
		for(int val : copyAr) {
			if(val ==0)
				break;
			System.out.print(val + " ");
		}

	}
	
	private static char[] strArr1(int i) {
		// TODO Auto-generated method stub
		return null;

		
//ㅊ 100	볼50 가50 판10	
	}



}