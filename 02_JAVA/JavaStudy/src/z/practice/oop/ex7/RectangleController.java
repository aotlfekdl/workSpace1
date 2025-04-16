package z.practice.oop.ex7;

public class RectangleController {
	Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int Area = height * width;
		
		
		return "면적 :"+r.toString()+ Area;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
	
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		
		int Perimeter = (height + width)*2;
		
		return "너비 : " + r.toString()+Perimeter;
		
	}

}
