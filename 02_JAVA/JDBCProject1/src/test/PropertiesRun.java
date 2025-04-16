package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Properties 특징 -MAP 계열 컬렉션(Key- value형식으로 저장)
		 * setProperty(key, value)
		 * getProperty(key) : value
		 * 
		 * -주로 외부파일(.properties / .xml를 사용해서 입출력할 때 보다 편하게 변환해주는 객체
		 * */
		
		Properties prop = new Properties();
		
		/*
		prop.setProperty("C", "INSERT");
		prop.setProperty("R",  "SELECT");
		prop.setProperty("U",  "UPDATE");
		prop.setProperty("D", "DELETE");
		
		try {
			prop.store(new FileOutputStream("resources/driver.properties"), "Properties Test");
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "Properties Test");
		
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		*/
		
		//파일로부터 값을 읽어오기
		/*
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			System.out.println(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
			System.out.println(prop.getProperty("insert"));
			System.out.println(prop.getProperty("select"));
			System.out.println(prop.getProperty("update"));
			System.out.println(prop.getProperty("delete"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
