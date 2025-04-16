package o.collection.set.ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class LotteryMenu {
	Scanner sc = new Scanner(System.in);
	LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("========== KH 추첨 프로그램 ==========");
			
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 :");
			
			int choice = sc.nextInt();
			
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.insertObject();
				break;
				
			case 2:
				this.deleteObject();
				break;
				
			case 3:
				this.winObject();
				break;
				
			case 4:
				this.sortedWinObject();
				break;
			case 5:
				this.searchWinner();
				break;
				
			case 9:
				System.out.println("프로그램 종료.");
				return;
				
			default :
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				break;
			}
		}
	}
	public void insertObject() {
		
		List list = new ArrayList();
		int num;
		System.out.print("추가할 추첨 대상 수 : ");
		num = sc.nextInt();
		
		for(int i =0; i<num;i++) {
			String name;
			String phone;
			System.out.print("이름 :");
			name = sc.next();
			System.out.print("핸드폰 번호('-'빼고)");
			phone = sc.next();
			
			
			Lottery lottery = new Lottery(name, phone);
			boolean isInsert = lc.insertObject(lottery);
			if(!isInsert) {
				System.out.println("중복된 대상입니다.");
				i--;
			}
		}
		
		
		System.out.println("추가완료");
	}
	public void deleteObject() {
		
		System.out.print("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.: ");
		
		System.out.println("이름 :");
		String name = sc.next();
		System.out.println("핸드폰 번호('-'뺴고) :");
		String phone = sc.next();
		
		Lottery lottery = new Lottery(name, phone);
		if(lc.deleteObject(lottery)) {
			System.out.println("삭제완료되었습니다.");
		}else {
			System.out.println("존재하지 않는 대상입니다.");
		}
		
	}
	public void winObject() {
		lc.winObject();
		System.out.println(lc.winObject());
		HashSet win = lc.winObject();
		if(win == null) {
			System.out.println("당첨결과가 없습니다.");
		}else {
			System.out.println(win);
		}
	}
	public void sortedWinObject() {
		TreeSet sortedSet = lc.sortedWinObjecet();
		System.out.println(sortedSet = lc.sortedWinObjecet());
	}
	public void searchWinner() {
		
	System.out.print("검색할 대상의 이름과 핸드폰 번호를 입력하세요.: ");
		
		System.out.println("이름 :");
		String name = sc.next();
		System.out.println("핸드폰 번호('-'뺴고) :");
		String phone = sc.next();
		
		Lottery lottery = new Lottery(name, phone);
		if(lc.searchWinner(lottery)) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		}else {
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다");
		}
	}
}
