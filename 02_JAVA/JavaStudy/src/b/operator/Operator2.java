package b.operator;
	/*
	 * 증감연산자
	 * ++ : 변수에 담긴값을 1증가 시켜주는 연산자
	 * 
	 * -- : 변수에 담긴 값을 1감소 시켜주는 연산자
	 * 
	 * (증감연산)변수 : 전위연산 -> "선증감" 후처리
	 * 변수(증감연산) : 후위연산 -> 선처리 "추증감"
	 * */
public class Operator2 {
	public static void main(String[] args) { 
		int num1 = 0;
		

		System.out.println(num1++); //0,(1)
		System.out.println(++num1); //2 (2)
		System.out.println(num1--); //2,(1)
		System.out.println(--num1); //0 (0)
		System.out.println(++num1); //1
		System.out.println(++num1); //2
		System.out.println(num1++); //2,(3)
		System.out.println(num1--); //3,(2)
		System.out.println(--num1); //1
		System.out.println(--num1); //0

	}

}
