package h.inherit.ex1;

public class Man {
	private String name;

	

	public Man(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void tellYourName() {
		System.out.println("my name is "+this.name);
	}

}
