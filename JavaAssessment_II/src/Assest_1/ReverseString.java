package Assest_1;

import java.util.StringTokenizer;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Hello World";
		String[] arrOfStr = name.split(" ");
		for(int i=0;i<arrOfStr.length;i++) {
			StringBuilder input1 = new StringBuilder();
			input1.append(arrOfStr[i]);
			input1.reverse();
			System.out.print(input1);
			System.out.print(" ");
		}
	}

}
