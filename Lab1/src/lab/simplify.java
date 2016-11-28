package lab;

public class simplify {
	static void Combination(int n, node s[]) {   //把数字合并
		for (int i = 1; i <= n; i++) {
			String digit = "";
			String character = "";
			for (int j = 0; j < s[i].str.length(); j++) {//对于每一个子项
				if (Character.isDigit(s[i].str.charAt(j))) {
					digit += s[i].str.charAt(j);//数字载入
				} else {
					character += s[i].str.charAt(j);//字母载入
					if (!digit.equals(""))
						s[i].now *= Integer.parseInt(digit);//每次遇到一次非数字，预处理数字和原值相乘
					digit = "";
				}
			}
			if (!digit.equals("")) {
				s[i].now *= Integer.parseInt(digit);//最后一个项目可能是数字
			}
			s[i].str = character;//字母放最后
		}
	}//效果：表达式形式转为：digit （*）character
	static void simplify(String Choice, int n, node s[]) {   //表达式求值
		int k = 10;
		while (k < Choice.length() - 1) {
			char c = Choice.charAt(k);
			String tn = "";
			k += 2;
			for (int i = k; i < Choice.length(); i++) {
				k = i + 1;
				if (Character.isDigit(Choice.charAt(i))) {
					tn += Choice.charAt(i);
				} else {
					break;
				}
			} //截取数字
			int now = Integer.parseInt(tn);
			for (int i = 1; i <= n; i++) {
				String tmp = "";
				for (int j = 0; j < s[i].str.length(); j++) {
					if (s[i].str.charAt(j) == c) {
						s[i].now *= now;
					} else {
						tmp += s[i].str.charAt(j);
					}
				}//字符相等替换，并且数字相乘
				s[i].str = tmp;
			}
		}
	}
	
	static void Print(int n, node s[]) { //输出
		for (int i = 1; i <= n; i++) {
			if (i != 1) System.out.print("+");
			if (s[i].now == 0) continue;
			System.out.print(s[i].now);
			boolean [] vis = new boolean[300];
			for (int j = 0; j < s[i].str.length(); j++) {
				char c = s[i].str.charAt(j);
				if (vis[c]) continue;
				vis[c] = true;
				int flag = 1;
				for (int k = j + 1; k < s[i].str.length(); k++) {
					if (s[i].str.charAt(k) == c) flag++;
				}
				System.out.print("*" + c);
				if (flag >= 2) {
					System.out.print("^" + flag);
				}//
			}
			
		}
		System.out.print("\n");
	}
}
