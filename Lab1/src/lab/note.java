package lab;

public class note {
	static private int now2;
	static private String str2;
	static private String Final;
	static void node(int now, String str) {
		now2 = now;
		str2 = str;
	}
	static void SaveExpression(String ori) {
		Final = ori;
	}
	static String returnnode() {
		if(Final.length() <= 1) return "";
		
		return Final;
	}
}
