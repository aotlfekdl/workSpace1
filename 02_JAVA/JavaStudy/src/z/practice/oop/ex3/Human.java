package z.practice.oop.ex3;

public class Human {
	String name;
	int money;
	public Human() {
		super();
	}
	
	public void buy() {
		
		System.out.printf("%s 와 %d",name,money);
	}
	public Human(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	

	

}
