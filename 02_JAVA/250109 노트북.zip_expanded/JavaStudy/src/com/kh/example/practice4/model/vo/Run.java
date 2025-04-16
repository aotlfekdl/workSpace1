package com.kh.example.practice4.model.vo;

public class Run {


	static int discountRate= 0;

	public static void main(String[] args) {
		
		Book b1 = new Book("이게되네?","한빛","김사");
		Book b2 = new Book("진짜되네?","두잇","박은종",15000, discountRate);

		
		

		b2.discountRate(discountRate);
		b2.inform();
		
	}

}
