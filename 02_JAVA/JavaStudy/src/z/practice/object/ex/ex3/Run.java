package z.practice.object.ex.ex3;
public class Run {
	public static void main(String[] args) {
		Student James = new Student("제임스", 2, 40000);
		Texi Texi100 = new Texi("T100");
		James.takeTexi(Texi100);
		James.showInfo();
		
		Texi100.showInfo();
	}
}
//