package lab;

public class Check {
	static String preStr(String s) {  //忽略乘号
		String tmp = "";
		boolean jud = true;
		while (jud) {
			tmp = "";
			int flag = -1;
			for (int i = 0; i < s.length(); i++) {
				if (i == 0 || i == s.length() - 1) continue;
				if (s.charAt(i) == '*') {
					if (Character.isDigit(s.charAt(i - 1)) && Character.isDigit(s.charAt(i + 1))) {
						flag = i;
						break;
					}
				}
			}//找到这样的乘号，乘号两边是数字
			if (flag == -1) break;
			int fn = 0, fg = s.length() - 1;
			for (int i = flag - 1; i >= 0; i--) {
				if (!Character.isDigit(s.charAt(i))) {
					fn = i + 1; break;
				}
			}
			for (int i = flag + 1; i < s.length() - 1; i++) {
				if (!Character.isDigit(s.charAt(i))) {
					fg =  i - 1; break;
				}
			}//离乘号左右最近的非数字
			String s1 = "", s2 = "";
			for (int i = fn; i < flag; i++) s1 += s.charAt(i);
			for (int i = flag + 1; i <= fg; i++) s2 += s.charAt(i);
			int now = Integer.parseInt(s1);
			now *= Integer.parseInt(s2);//数字存入，转int
			for (int i = 0; i < fn; i++) tmp += s.charAt(i);
			tmp += String.valueOf(now);
			for (int i = fg + 1; i < s.length(); i++) tmp += s.charAt(i);
			s = tmp;//其余的元素照原样复制
		}
		tmp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '*') tmp += s.charAt(i);
		}//删除所有乘号
		return tmp;
	}//效果：将所有digit×digit类型的子串合并为一个数字，并且删除所有乘号
	static boolean Judge(String s) {  //判断表达式是否为0
		String tmp = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				tmp += s.charAt(i);
			} else {
				if (!tmp.equals("")) {
					if (Integer.parseInt(tmp) == 0) {
						return true;
					}
				} 
				tmp = "";
			}
		}
		if (!tmp.equals("")) {
			if (Integer.parseInt(tmp) == 0) {
				return true;
			}
		}
		return false;
	}
	static int Pre(String ori, node s[]) {  //预处理分割+号
		int n = 0;
		String tmp = "";
		for (int i = 0; i < ori.length(); i++) {
			if (ori.charAt(i) != '+') {
				tmp += ori.charAt(i);
			} else {
				s[++n] = new node(1, tmp);
				tmp = "";
			}
		}//基于+号分割表达式，存入结构体数组中的String
		if (!tmp.equals("")) {
			s[++n] = new node(1, tmp);
			tmp = "";
		}//处理末尾的一个子项
		return n;
	}//效果：将子项放入结构体数组中
	
	static boolean Check(String ori) {  //查看表达式是否合法
		for (int i = 0; i < ori.length(); i++) {
			if (ori.charAt(i) >= '0' && ori.charAt(i) <= '9') continue;
			if (ori.charAt(i) >= 'a' && ori.charAt(i) <= 'z') continue;
			if (ori.charAt(i) == '+' || ori.charAt(i) == '*') continue;
			return true;// 合法字符检查
		}
		if (ori.charAt(0) == '+' || ori.charAt(ori.length() - 1) == '+') return true;
		if (ori.charAt(0) == '*' || ori.charAt(ori.length() - 1) == '*') return true;
		for (int i = 0; i < ori.length() - 1; i++) {
			if (ori.charAt(i) == '+' || ori.charAt(i) == '*') {
				if (ori.charAt(i + 1) == '+' || ori.charAt(i + 1) == '*') return true;
			}
		}//+ *位置判断表达式正误
		if (Judge(ori)) return true;//表达式中不能有0
		return false;
	}
}
