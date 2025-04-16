package q.thread.ex2;

public class Run {

	public static void main(String[] args) {
			
			Thread t1 = new Thread(() -> {//20이상 짝수 출력
				for(int i = 0; i<= 100; i++) {
					if(i % 2 ==0) {
						System.out.println(i);
					}try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	
	
		//		Thread.currentThread()지금 실행하고 있는 쓰레드의 정보객체를 반환
				
			});
			
			Thread t2 = new Thread(() -> {
				
				for(int i = 0; i<= 100; i++) {
					if(i % 2 ==1) {
						System.out.println(i);
					}
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}//20 이하 홀수 출력
				
			});
			t1.start(); //Thread를 실행시키는 메서드
			t2.start();
	
	}
			
	

}
