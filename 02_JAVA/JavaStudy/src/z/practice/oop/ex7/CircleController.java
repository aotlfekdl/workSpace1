package z.practice.oop.ex7;

public class CircleController {
	Circle c =  new Circle();
	
		
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);

		double Area;
		Area = radius*radius*Math.PI;
		
		return "넓이 :"+c.toString()+"/"+Area;
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double circum;
		circum = radius *2 * Math.PI;
		
		
		return "둘레 :"+c.toString()+"/"+circum;
	}

	

}
