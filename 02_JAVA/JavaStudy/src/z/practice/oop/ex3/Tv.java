package z.practice.oop.ex3;

public class Tv {
	String brand;
	int year;
	int size;
	int price;
	
	
	public Tv() {
		super();
	}
	public Tv(String brand, int year, int size, int price) {
		super();
		this.brand = brand;
		this.year = year;
		this.size = size;
		this.price = price;
	}
	
	public void show() {
	
		System.out.printf("%s에서 만든 %d년형 %d인치 TV 가격 : %d \n",brand, year, size, price);
		
	}
	public String getbrand() {
		return brand;
	}
	public void setbrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

	
	

}
