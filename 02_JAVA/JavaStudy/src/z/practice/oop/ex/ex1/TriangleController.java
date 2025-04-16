package z.practice.oop.ex.ex1;

public class TriangleController {
	Shape s = new Shape();
	
	
	
	public double calcArea(double height, double width) {
		s = new Shape(1, height, width);
		return s.getHeight()* s.getWidth()/2;
	}

	public void paintColor(String color) {
		this.s.getColor();
	}
	
	public String print() {
		
		return "삼각형"+ s.information();
	}
}
