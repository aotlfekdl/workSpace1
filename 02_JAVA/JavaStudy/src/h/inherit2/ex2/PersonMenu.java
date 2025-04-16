package h.inherit2.ex2;

import java.util.Scanner;

public class PersonMenu {
	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController();
	

	
		public void mainMenu(){
			while(true) {
				
				int[] countArr = pc.personCount();
				System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
				System.out.println("현재 저장된 학생은"+ countArr[0]+"명입니다.");
				System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
				System.out.println("현재 저장된 사원은"+countArr[1]+" 명입니다.");
				
				int choice;
				System.out.println("1. 학생 메뉴");
				System.out.println("2. 사원 메뉴");
				System.out.println("9. 끝내기");
				System.out.println("메뉴번호");
				choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				case 1:
					studentMenu();
					break;
				case 2:
					employeeMenu();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("잘못 입력하였습니다.다시 입력해주세요");
					break;
				}
			}
			
		}
	
	
	public void studentMenu() {
		int choice;
		int[] countArr = pc.personCount();
		if(countArr[0]<3) {
			System.out.println("1. 학생 추가");
		}else {
			System.out.println("학생을 담을 수 있는 공간이 꽉 찾기 때문에 학생 추가 메뉴는 더이상 활성화 되지 않습니다.");
		}
		System.out.println("2. 학생 보기");
		System.out.println("9. 메인으로");
		System.out.print("메뉴번호");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			
			insertStudent();
			break;
		case 2:
			printStudent();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.print("잘못 입력하였습니다.다시 입력해주세요");
			break;
		}
	

	}
	public void employeeMenu() {
		int choice;
		int[] countArr = pc.personCount();
		if(countArr[0]<3) {
			System.out.println("1. 사원 추가");
		}else {
			System.out.println("사원을 담을 수 있는 공간이 꽉 찾기 때문에 사원 추가 메뉴는 더이상 활성화 되지 않습니다.");
		}
		System.out.println("2. 사원 보기");
		System.out.println("9. 메인으로");
		System.out.print("메뉴번호");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			
			insertEmployee();
			break;
		case 2:
			printEmployee();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.print("잘못 입력하였습니다.다시 입력해주세요");
			break;
		}

	
	}
	
	public void insertStudent() {
		
	while(true){
			int[] countArr = pc.personCount();
			String name, major;
			int age, grade;
			double height,  weight;
			
			
			System.out.print("학생 이름:");
			name = sc.next();
			System.out.print("학생 나이:");
			age = sc.nextInt();
			System.out.print("학생 키:");
			height = sc.nextDouble();
			System.out.print("학생 몸무게:");
			weight = sc.nextDouble();
			System.out.print("학생 학년:");
			grade = sc.nextInt();
			System.out.print("학생 전공:");
			major = sc.next();
			sc.nextLine();
			
			pc.insertStudent(name, age, height, weight, grade, major);
			
			if(countArr[0]<3) {
			
				System.out.print("그만 하시려면 N(또는n), 이어서 하시려면 아무키나 누르세요 :");
				char scchoice = sc.next().charAt(0);
				if(scchoice == 'n' && scchoice == 'N') {
					return;
				}else {
					insertStudent();
				}
			}else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
			}
			
		}
	
	}
	
		
	
	
	public void printStudent() {
		Student[] stuArr = pc.printStudent();
		for(Student stu :stuArr) {
			if(stu ==null)
				break;
		
			System.out.println(stu.toString());
		}
		
	}
	
	
	public void insertEmployee() {

		int[] countArr = pc.personCount();
		String name, major;
		int age, grade;
		double height,  weight;
	
		
		
	System.out.println("사원 이름:");
	name = sc.next();
	System.out.print("사원 나이:");
	age = sc.nextInt();
	System.out.print("사원 키:");
	height = sc.nextDouble();
	System.out.print("사원 몸무게:");
	weight = sc.nextDouble();
	System.out.print("사원 급여:");
	grade = sc.nextInt();
	System.out.print("사원 부서:");
	major = sc.next();
	sc.nextLine();
	
	pc.insertEmployee(name, age, height, weight, grade, major);
	
	if(countArr[1]<3) {
	
		System.out.print("그만 하시려면 N(또는n), 이어서 하시려면 아무키나 누르세요 :");
		char scchoice = sc.next().charAt(0);
		if(scchoice == 'n' && scchoice == 'N') {
			return;
		}else {
			insertEmployee();
		}
		}else {
			System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
		}
	
	}
	
	
	
	
	public void printEmployee() {
		
	}

}

	

