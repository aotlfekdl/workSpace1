package z.practice.oop.ex6;

public class MemberController {
	public static final int SIZE = 10;
	private Member[] m= new Member[SIZE];
	
	
	public int existMemberNum() {
		return 0;
	}
	public Boolean checkId(String inputId) {
		boolean isDictionary = false;
		for(int i = 0; i < m.length; i++) {
			m[0].getId();
			if(m[++i].getId() == m[i].getId()) {
				isDictionary = true;
				return true;
				
			}else {
				m[i].getId();
				return false;
			}
		}
		return isDictionary;
			
	
	
	}
	
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		Member m = new Member(id, name, password, email, gender, age);
	}
	
	public String searchId(String id) {
		String result = null;
		for(int i = 0; i < m.length; i++) {
			if(this.searchId(id) == m[i].getId()) {
				result = this.searchId(id);
			}else {
				result = "아이디가 조회되지 않습니다.";
			}
		}
		
		return result;
	}
	
	public Member[] searchName() {
		return null;
	}
	
	public Member[] searchEmail(String email) {
		return null;
	}
	public Boolean updatePassword(String id, String password) {
		return null;
	}
	public Boolean updateName(String id, String name) {
		return null;
	}
	public Boolean updateEmail(String id, String email) {
		return null;
	}
	public Boolean delete(String id) {
		return null;
	}
	public void delete() {
	}
	public Member[] printAll() {
		return null;
	
	}
}


