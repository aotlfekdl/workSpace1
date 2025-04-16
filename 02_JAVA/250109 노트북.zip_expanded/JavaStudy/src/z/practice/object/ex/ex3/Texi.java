package z.practice.object.ex.ex3;

public class Texi {
	String texiNumber;
	int passengerCount;
	int money;
	public Texi(String texiNumber) {
		super();
		this.texiNumber = texiNumber;
	}

		// TODO Auto-generated constructor stub
	
	public void take(int money) {
		this.money += 10000;
		passengerCount++;
		
	}
	public void showInfo() {
		System.out.println(this.texiNumber+" "+ this.money);
	}
	
	
	

}
