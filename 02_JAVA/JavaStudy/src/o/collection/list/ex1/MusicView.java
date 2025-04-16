package o.collection.list.ex1;

import java.util.Scanner;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
    private MusicController mc = new MusicController(); 
	
	public void mainMenu() {

		while(true) {
			int choice;
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡 명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 :");
			
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				addList();
				break;
				
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
				
			case 9:
				System.out.println("종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	
	public void addList() {
		
		String title;
		String singer;
		
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.println("곡 명 :");
		title = sc.next();
		
		System.out.println("가수 명 :");
		singer = sc.next();
		sc.nextLine();
		
		//mc.addList(new Music(title, singer)); -> 이렇게 간단하게 한줄로도 가능
		Music music = new Music(title, singer);
		int result = mc.addList(music);
		
		if(result ==1) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}
	
	public void addAtZero() {
		String title;
		String singer;
		System.out.println("곡 명");
		title = sc.next();
		
		System.out.println("가수 명");
		singer = sc.next();
		sc.nextLine();
		
		
		Music music = new Music(title, singer);
		int result = mc.addAtZero(music);
		
		if(result ==1) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}
	
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		mc.printAll();
		
		System.out.println(mc.printAll()+"\n");
	}
	
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		// 사용자에게 곡 이름을 받고 MusicController에 있는 searchMusic으로 값을 넘긴다.
		// searchMusic()의 반환 값에 따라 반환 값이 없으면 “검색한 곡이 없습니다.”
		// 반환 값이 있으면 “검색한 곡은 000(곡 명, 가수 명) 입니다.” 콘솔 창에 출력
		System.out.println("검색할 곡 명 :");
		String title = sc.next();
		
		Music result = mc.searchMusic(title);
		System.out.println(result);
		if(result == null) {
			System.out.println("검색한 곡이 없습니다.");
		}
		
	}
	
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		String title;
		System.out.println("삭제할 곡 명");
		title = sc.next();
		
		Music m = mc.removeMusic(title);
		if(m == null) {
			System.out.println("삭제할 곡이 없습니다.");
			
		}else{
			System.out.println(m);
		}
	}
	
	public void setMusic() {
		String title, retitle, resinger;
		System.out.println("****** 특정 곡 수정 ******");
		System.out.println("검색할 곡 명 :");
		title = sc.next();
		System.out.println("수정할 곡 명 :");
		retitle = sc.next();
		System.out.println("수정할 가수 명 :");
		resinger = sc.next();
		
		Music music = new Music(retitle,resinger);
		Music result = mc.setMusic(title, music);
		System.out.println(result);
		
		if(result ==null) {
			System.out.println("수정할 곡이 없습니다.");
		}else {
			System.out.println(result + "값이 변경되었습니다.");
		}
		
		
	}
	
	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		int result = mc.ascTitle();
		if(result == 1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
		
	}
	
	public void descSinger() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
		int result = mc.descSinger();
		if(result == 1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
		
	}
	

}
