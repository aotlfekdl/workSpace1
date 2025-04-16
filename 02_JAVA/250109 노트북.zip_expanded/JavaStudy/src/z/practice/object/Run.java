package z.practice.object;

public class Run {
	
	public static void main(String[] args) {
		
	
		Member m1 = new Member("als3603", "3603","홍승민1");
		m1.setInfo("010-4664-2653", "als3603@naver.com", 26, '남');
		
		
		
		Member m2 = new Member("als3604", "3604","홍승민2");
		m2.setInfo("010-4664-2654", "als3603@naver.com", 27, '남');
		
		Member m3 = new Member("als3605", "3605","홍승민3");
		m3.setInfo("010-4664-2655", "als3605@naver.com", 28, '남');
		
		
		//,"010-4664-2653", "als3603@naver.com", 26, '남');
		
				//("als3603", "3603","홍승민1");
		//ref1 = new Member("010-4664-2653", "als3603@naver.com", 26, '남');
		/*
		Member ref2 = new Member("als3604", "3604","홍승민2");
		ref2 = new Member("010-4664-2654", "als3604@naver.com", 27, '남');
		Member ref3 = new Member("als3605", "3605","홍승민3");
		ref3 = new Member("010-4664-2655", "als3605@naver.com", 28, '남');
	//	"als", 3603, "홍승민", 010-4664-2653, "als3603@naver.com", 26, "남");
	*/
		

		
		m1.toInfo();
		m2.toInfo();
		m3.toInfo();
		
	}
	
}
