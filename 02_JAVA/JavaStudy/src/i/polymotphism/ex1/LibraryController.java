package i.polymotphism.ex1;

public class LibraryController {
	Member mem = null;
	Book[] bList = new Book[10];
	

	
	public LibraryController() {
		super();
		
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
			
	}
	public void insertMember(Member mem){
		this.mem = mem;
		
	}
	public int insertBook(Book b) {
		for(int i =0; i<bList.length; i++) {
			if(bList[i] == null) {
				bList[i] = b;
				return i;
			}
		}
		
		return -1;
			
		
		
	}
	
	public Member myInfo() {
		
	System.out.println(mem);
		
		return mem;
		
	}
	public Book[] selectAll() {
		
		
		
		return bList;
	}
	
	

	    
	public Book[] searchBook(String keyword) {
		/*
		 * 문자열에 특정 문자가 포함되어 있는지 검사하는 방법
		 * 문자열.index("찾고자하는 문자열") true, false로 반환
		 * 문자열.indexOf("찾고자하는 문자열")-> index값 반환 /못찾으면 -1 반환
		 * int num = "안녕하세요 홍승민입니다.".indexOf("세요"); => 3 
		 * -> 문자열에서 찾고자하는 문자열이 몇번째 index에 포함되어 있는지 찾고싶을 떄 사용
		 * 
		 * 문자열.contains("찾고자하는 문자열") -> 찾고자 하는 문자열이 포함되어 있는지를 검사
		 * 찾고자하는 문자열이 포함되어 있다면 true, 포함되어 있지 않다면 false 반환
		 * 
		 * */
		//for(int i = 0; i.bList.length ** bList[i] != null; i++){
		//	break;
		//	}
			//if(bList[i].getTitle().indexOf(keyword) != -1) {
				
		//	}
		
		
		
		Book[] result = new Book[10];
		int count = 0;
		for(Book b1 : bList) {
			if (b1.getTitle().contains(keyword) && count < 10) {
			result[count++] =  b1;
			//System.out.println(result);
			}
			
		}


		for(int i = 0; i < result.length; i++) {
			if(result[i] != null) {
			System.out.println(result[i]);
			}
		}
			
		
		return result;
		}
	
	public void deleteBook(int dechoice) {
		bList[dechoice] = null;
	}
	
/*		for(int i= 0; i <bList.length; i++)
	}
	
	
	public boolean deleteBook(int dechoice) {
		for(int i = dechoice; i< bList.length; i++) {
			if(i = bList.length-1) {
				bList[i] = (i ==bList.length -1) ? null ? bList[i+1];
			}
			bList[i] = bList[i+1];
		}
		*/
		
	
	
	public int rentBook(int index) {
		Member m1 = new Member();
		AniBook n1 = new AniBook();
		int result = 0;
		Book bk = bList[index];
		
		if(bk instanceof AniBook) {
			int accessAge = ((AniBook)bk).getAccessAge();//여기서 다운캐스팅함
			int memberAge = mem.getAge();
			if(accessAge > memberAge) {
				result =1;
			}
				
		}else if(bk instanceof CookBook) {
			if(((CookBook)bk).isCoupon()){//여기서도 다운캐스팅 함
				mem.setCouponCount(mem.getCouponCount()+1);
				result = 2;
			}
		}

		
		return result;
	}
	public boolean isInsertBook() {
		for(Book b: bList) {
			if(b == null) {
				return true;
			}
		}return false;
	}
}
