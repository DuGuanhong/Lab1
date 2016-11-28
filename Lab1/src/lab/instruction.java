package lab;

import java.util.Scanner;

public class instruction {
	static private String Final;
	
	
	static String Read() {
		Scanner in = new Scanner(System.in);
		Final = in.nextLine();
		System.out.println(Final);
		return Final;
	}
}
