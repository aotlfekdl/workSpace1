package a.basic;

public class Output {
	public static void main(String[] asgs) {
		//코드를 사용하는 영역
		
		//출력문
		System.out.println(); 
		System.out.println("HI"); //println() -> 개행문자를 포함 한줄 띄어져있다.
		System.out.print("최지원입니다.");  //print() -> 일반 출력문
		// printf() -> 문자열 포멧을 이용한 출력문
		//System.out.printf(문자열 포멧, 값1, 값2, 값3
		String name = "최지원";
		int age = 15;
		
		System.out.println("저는 " + name + "이고 나이는" + age +"살 입니다.");
	
		System.out.printf("제 나이는 20살 입니다."); // printf() -> 문자열 포멧을 이용한 출력문

		System.out.printf("저는 %s이고 나이는 %d입니다.", name, age);
	
		
		/*
		 * 포멧안에서 쓸 수 있는 키워드
		 * %d : 정수
		 * %c: 문자(한글자)
		 * %s 문자열
		 * %f : 실수
		 */
		
		
		/*
		 *  주석 : 컴퓨터는 인식하지 않고 사람이 필요에 따라 설명 등을 적어두는 용도
		 * */ 
		
	}
	
}
