package z.practice.oop.ex1;

import java.util.Scanner;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();
	
	public void inputMenu(){
		while(true) {
			System.out.println("==== 도형 프로그램 ====");
			System.out.println("3.삼각형");
			System.out.println("4.사각형");
			System.out.println("9.프로그램 종료");
			System.out.print("메뉴번호 :" );
			int choice = sc.nextInt();
			sc.nextLine();//개행문자 비움
			
			switch(choice) {
			case 3:
				
				triangleMenu();
				break;
			case 4:
				squareMenu();
				break;
			case 9:
				break;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요");
			}
		}
		
	}
	public void triangleMenu(){
		while(true) {
			System.out.println("==== 삼각형 ====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.println("메뉴 번호 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			if(choice == 9) {//triangleMenu 종료 후 메인으로 이동
				return;
			}
			this.inputSize(1,choice);
			}
		
		
		}
	public void squareMenu(){
		
	}
	public void inputSize(int type, int menuNum){
		//type -> 1 삼각형 2. 사각형
		//menuNum -> 1. 면적색칠 2. 넓이 높이입력

		if(type ==1) {
			switch(menuNum) {
			case 1:

				System.out.println("높이 : ");
				double hegith = sc.nextDouble();
				
				System.out.println("너비 : ");
				double width = sc.nextDouble();
				
				double areaSize = tc.calcArea(hegith, width);
				System.out.println();
				
				break;
			case 2:
				System.out.println("색깔을 입력하세요");
				String color = sc.next();
				sc.nextLine();
				tc.paintColor(color);
				System.out.println("색이 수정되었습니다.");
				break;
			case 3:
				this.printlnformation(type);
				break;
			case 4:
				while(true) {
					System.out.println("==== 사각형 ====");
					System.out.println("1. 사각형 면적");
					System.out.println("2. 사각형 색칠");
					System.out.println("3. 사각형 정보");
					System.out.println("9. 메인으로");
					System.out.println("메뉴 번호 : ");
					int choice = sc.nextInt();
					sc.nextLine();
					
					if(choice == 9) {//triangleMenu 종료 후 메인으로 이동
						return;
					}
					this.inputSize(2,choice);
				}
				
				
			}
				
			}else {
				
				
		}
			
	}
	
	
	public void printlnformation(int type){
		if(type ==1) {
			String info = tc.print();
			System.out.println(info);
		}
		
	}

}
