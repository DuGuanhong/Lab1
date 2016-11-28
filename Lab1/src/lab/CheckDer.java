package lab;



public class CheckDer {

	static boolean CheckSim(String Choice, int n, node s[]) { //查看化简表达式是否合法
		if (Choice.length() < 10) return false;
		String tmp = "";
		for (int i = 0; i <= 9; i++) {
			tmp += Choice.charAt(i);
		}
		if (!tmp.equals("!simplify ")) return false;
		int i = 10;
		while (i < Choice.length()) {
			if (i + 2 >= Choice.length()) return false;
			if (Choice.charAt(i) < 'a' || Choice.charAt(i) > 'z') return false;
			if (Choice.charAt(i + 1) != '=') return false;
			if (Choice.charAt(i + 2) < '0' || Choice.charAt(i + 2) > '9') return false;
			i += 2;
			for (int j = i; j < Choice.length(); j++) {
				i = j + 1; 
				if (Choice.charAt(j) < '0' || Choice.charAt(j) > '9') {
					if (Choice.charAt(j) != ' ') return false;
					break;
				}
			}
		}
		return true;
	}
	
	static boolean CheckDer(String Choice, int n, node s[]) {   //查看求导表达式是否合法
		if (Choice.length() !=  6) return false;
		String tmp = "";
		for (int i = 0; i <= 4; i++) {
			tmp += Choice.charAt(i);
		}
		if (!tmp.equals("!d/d ")) return false;
		boolean flag = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < s[i].str.length(); j++) {
				if (Choice.charAt(5) == s[i].str.charAt(j)) flag = true;//表达式是否有这个元素x
			}
		}
		if (!flag) return false;
		return true;
	}
}
