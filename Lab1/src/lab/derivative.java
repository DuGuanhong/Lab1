package lab;

public class derivative {
	public String derivative(String now) {  //求导\
		String ori = "1*x*y+2*x";
		int all = 9;
		int len = now.length();
		if (len <= 5 || len >= 7) {
			return "Error";
		}
		char c = now.charAt(5);
		int flag = 0;
		for (int i = 0; i < all; i++) {
			if (ori.charAt(i) == c) flag++;
		}
		if (flag == 0) return "Error";
		String tmp = "";
		for (int i = 0; i < all; i++) {
			if (ori.charAt(i) == c) {
				tmp += '1';
			} else {
				tmp += ori.charAt(i);
			}
		}
		if (flag >= 1)
		System.out.println(tmp);
		return tmp;
	}
}
