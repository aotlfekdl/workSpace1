package z.practice.object.ex.ex1;

public class Run {

	public static void main(String[] args) {

		Member m1 = new Member("als3603","3603","홍승민");
		m1.setInfo("010-4664-2653","als3603@naver.com",26,'남');
		
		Member m2 = new Member("als3604","3604","홍승민");
		m2.setInfo("010-4664-2654","als3604@naver.com",27,'남');
		
		Member m3 = new Member("als3605","3605","홍승민");
		m3.setInfo("010-4664-2655","als3605@naver.com",28,'여');
		
		m1.toInfo();
		m2.toInfo();
		m3.toInfo();

		
	}

}
