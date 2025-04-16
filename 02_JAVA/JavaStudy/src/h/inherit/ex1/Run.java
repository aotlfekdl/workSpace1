package h.inherit.ex1;

import java.util.Scanner;

import h.inherit.BusinessMan;

public class Run {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Man man1 = new Man("승민");
		man1.tellYourName();

		
		BusinessMan man2 = new BusinessMan("승민","강사","chlwldn");
		man2.setName("최지원");
		man2.tellYourName();
	}

}
