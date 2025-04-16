package m.api.EX1;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {
	}
	
	public String afterToken(String str) {
		StringTokenizer str1 = new StringTokenizer(str);
		
		String[] arr = str.split(" ");
		for(String st : arr) {
			System.out.print(st);
		}
		System.out.println();
		System.out.println(str1.countTokens());
		
		String str2 = str.toUpperCase();
		
		
		String[] arr2 = str2.split(" ");
		for(String st : arr2) {
			System.out.print(st);
		}
		
		return null;
	}

	public String firstCap(String input) {
		
		char str1=input.toUpperCase().charAt(0);
		
		String str2 = input.substring(1);
		
		
		return str1 + str2;
	}
	public int findChar(String input, char one) {
		
		int count = 0;
		for(char st : input.toCharArray()) {
			if(st ==one){	
				count++;
			}

		
		}
		return count;
	}
}
