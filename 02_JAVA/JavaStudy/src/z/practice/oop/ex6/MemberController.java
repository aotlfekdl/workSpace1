package z.practice.oop.ex6;

public class MemberController {
	public static final int SIZE = 10;
	private Member[] m= new Member[SIZE];
	
	
	public MemberController() {
		super();
		m[0] = new Member("user01", "김지원","pass01","1dfsa@q3wtr", 'f', 24);
		m[1] = new Member("user02", "김지원1","pass012","1dfsa@q3wtr1", 'f', 25);
		m[2] = new Member("user03", "김지원2","pass013","1dfsa@q3wtr2", 'f', 26);
		m[3] = new Member("user04", "김지원3","pass014","1dfsa@q3wtr3", 'f', 27);
	}
	
	
	public int existMemberNum() {
		int count= 0;
		for(int i = 0; i<m.length; i++) {
			if(m[i] !=null) {
				count++;
				
			}else {
				break;
			}
			
		}
		
		
		return count;
	}
	
	//check하고자하는 id를 넘겨받아 배열 m에 해당 id를 사용하는 Member가 있는지 검사
	//중복된 아이디가 있을경우 사용불가이기 때문에 return false
	//중복된 아이디가 없을경우 사용가능이기 때문에 return true
	public Boolean checkId(String inputId) {
		for(Member mem : m) {
			if(mem ==null) { //null이 나올떄까지 찾았는데 몾찾음
				return true;
			}
			if(mem.getId().equals(inputId)){
				return false;
			}
		}
		return true;

			
	
	
	}
	
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		for(int i =0; i<m.length; i++) {
			if(m[i] ==null) {//빈공간 체크
				m[i] = new Member(id, name, password, email, gender, age); // 회원 추가
				return;
			}
		}
		
	}
	
	
	
	// 존재하면 검색된 회원의 정보를 return
	public String searchId(String id) {
		
		for(Member mem : m) {
			
			if(mem == null) {
				return null;
			}else if(mem.getId().equals(id)) {
				
				return mem.inform();
				
			}
		
		}
		return null;
	}
		
	
	//존재하면 검색된 회원의 정보를 return
	public Member[] searchName(String name) {
		Member[] mArr = new Member[SIZE];
		int index = 0;
		
		for(Member mem : m) {
			if(mem == null) {
				break;
			}
			if(mem.getName().equals(name)) { // 동일한 이름을 찾음
				
				mArr[index++] = mem;
				
			}
		}
		return mArr;
	}
	
	
	public Member[] searchEmail(String email) {
		Member[] mArr = new Member[SIZE];
		int Index = 0;
		for(Member mem : m) {
			if(mem == null) {
				break;
			}else if(mem.getEmail().equals(email)) {
				mArr[Index++] = mem;
				}
			}
		return null;
	}
	
	//변경성공하면 true
	//변경 실패하면 false
	public Boolean updatePassword(String id, String password) {
		for(Member mem : m) {
			if(mem ==null) { //null이 나올떄까지 찾았는데 몾찾음
				return false;
			}else if(mem.getId().equals(id)) {
				mem.setPassword(password);
				return true;
			
			}
		}
		return false;

		
	}
	public Boolean updateName(String id, String name) {
		return null;
	}
	public Boolean updateEmail(String id, String email) {
		return null;
	}
	
	//특정 아이디를 찾아서 삭제
	//id를 못찾으면 return false
	public Boolean delete(String id) {
		for(int i = 0; i<m.length; i++) {
			if(m[i] ==null) { //null이 나올떄까지 찾았는데 몾찾음
				return false;
			}else if(m[i].getId().equals(id)) {
				
				
				//i 요소의 null이 대입되었기 때문에 뒤에있는 요소에는 값이 있으면 안됨.
				//그래서 i요소에 null을 넣는 것이 아니라 뒤에 요소를 하나씩 앞으로 당겨준다.
				//발견한요소~맨 마지막 요소까지(null이 아닌 요소)
				for(int j=i; j<m.length;j++) {
					if(j == m.length-1) {//마지막 요소는 다음요소가 없기 때문에 null을 직접 대입한다.
						m[j] = m[j+1];
						break;
					}else if(m[j] == null) {
						break;
					}
						m[j] = m[j+1];
						
					}
				
				}
				return true;
			
			}
		
		return false;

		
	}

	
	public void delete() {
		this.m = new Member[SIZE];
	}
	public Member[] printAll() {
		return m;
	
	}
}


