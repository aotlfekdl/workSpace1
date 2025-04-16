package h.inherit2.ex2;

public class PersonController {
	Student[] s = new Student[3];
	Employee[] e = new Employee[10];
	
	public int[] personCount() {
		
		//[Student수, EMployee수]
		int[] countArr = new int[2];
		
		for(Student st : s) {
			if(st == null) {
				break;
			}
			countArr[0]++;
			
		}
		for(Employee em : e) {
			if(em == null) {
				break;
			}
			countArr[1]++;
			
		}
	
		
		return countArr;
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for(int i = 0; i<s.length; i++) {
			if(s[i] ==null) {
				Student s = new Student(name, age, height, weight, grade, major);
				
				
				personCount();
			}
		}
	}
	public Student[] printStudent() {
		return null;
	}
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		
	}
	public Employee[] printEmployee(){
		return null;
	}
	

}
