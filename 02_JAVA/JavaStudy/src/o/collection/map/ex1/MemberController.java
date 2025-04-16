package o.collection.map.ex1;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class MemberController {
	private HashMap map = new HashMap();

	public boolean joinMembership(String id, Member m) {
		if(map.get(id) == null) {
			map.put(id, m);
			return true;
		}
		return false;
	}
	public String login(String id, String password) {
		Member m = (Member)map.get(id);
		if(m != null) {
			if(m.getPassword().equals(password)) {
				return m.getName();
			}

		}
		return null;
		
	}
	public boolean changPassword(String id, String oldPw, String newPw) {
		Member m = (Member)map.get(id);
		if(m != null && m.getPassword().equals(oldPw)) {
			m.setPassword(newPw);
			return true;
		}
		return false;
		
	}
	
	public void changeName(String id, String newName) {
		Member m = (Member)map.get(id);
		if(m != null) {
			m.setName(newName);
		}
		
	}
	public TreeMap sameName(String name) {
		TreeMap result = TreeMap((o1, o2) -> ((String)o1).compareTo((String)o2));
		Set keys = map.keySet();
		for(Object id : keys) {
			Member m = (Member)map.get(id);
			if(m.getName().equals(name)) {
				result.put(id, m.getName());
				
			}
		}
		return result;
		
	}


}
