package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class propertiesRun {

	public static void main(String[] args) {
		//Properties
		
		/*
		 * Properties 특징 - Map 계열 컬렉션(key- value 형식으로 저장함)
		 * setProperty(key, value)
		 * getProperty(key) : value
		 * 
		 * -주로 외부파일(.Properties / .xml)을 사용해서 입출력할 때 보다 편하게 변환해주는 객체
		 * */

		//파일로 축력하는 것
		
//		Properties prop = new Properties();
//		prop.setProperty("c", "INSERT");//데이터 생성
//		prop.setProperty("R", "SELECT");//데이터 읽기
//		prop.setProperty("U", "UPDATE");//데이터 수정
//		prop.setProperty("D", "DELETE");//데이터 삭제
//		
//		try {
//			//prop.store(new FileOutputStream("resources/driver.properties"),"Properties Test");
//			prop.storeToXML(new FileOutputStream("resources/query.xml"),"Properties Test");
//		
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}

		
		
		
			
		
		//파일로부터 값을 읽어오기
		
		Properties prop = new Properties();
//		try {
//			prop.load(new FileInputStream("resources/driver.properties"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(prop.getProperty("c"));
//		System.out.println(prop.getProperty("R"));
//		System.out.println(prop.getProperty("D"));
//		System.out.println(prop.getProperty("U"));
//	
//	}
		
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
			System.out.println(prop.getProperty("insetMember"));
			System.out.println(prop.getProperty("selectList"));
			System.out.println(prop.getProperty("deleteMember"));
			System.out.println(prop.getProperty("updateMember"));
			System.out.println(prop.getProperty("selectByuserName"));
			
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


