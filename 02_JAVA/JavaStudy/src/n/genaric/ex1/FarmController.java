package n.genaric.ex1;

import java.util.ArrayList;
import java.util.HashMap;

public class FarmController {
	HashMap<Farm, Integer> hMap = new HashMap<>();
	ArrayList<Farm> list = new ArrayList<>();
	
	
	
	public boolean addNewKind(Farm f, int amount) {
		hMap.put(f, amount);
		if(hMap != null) {
			return true;
		}
		hMap.put(f, amount);
		return false;
	}
	
	public boolean removeKind(Farm f) {
		return false;
	}
	
	public boolean changeAmount(Farm f, int amount) {
		return false;
	}
	
	public HashMap<Farm, Integer> printFarm(){
		return null;
	}
	
	public boolean buyFarm(Farm f) {
		
		return false;
	}
	public boolean removeFarm(Farm f) {
		return false;
	}
	
	public ArrayList<Farm> printBuyFarm(){
		return null;
	
	
	}

}
