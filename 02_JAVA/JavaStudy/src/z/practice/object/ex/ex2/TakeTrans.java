package z.practice.object.ex.ex2;

public class TakeTrans {

	public static void main(String[] args) {

		Student James = new Student("제임스", 4, 10000);
		Student Tomas = new Student("토마스", 2, 50000);
		

		Bus bus100 = new Bus(100);
		James.takeBus(bus100);
		James.showInfo();
		bus100.showInfo();
		
		
		Subway subwayGreen = new Subway("2호선");
		Tomas.takeSubway(subwayGreen);
		Tomas.showInfo();
		subwayGreen.showInfo();
		

	}

}
