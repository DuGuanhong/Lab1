package lab;

public class expression {
	static int expression(int n, node s[]) {   //合并同类项
		boolean jud = true;
		while (jud) {
			int flag = -1;
			int ptr = -1;
			for (int i = 1; i <= n; i++) {
				if (s[i].str.equals("")) {
					flag = i;
					break;
				}
			}
			if (flag == -1) break;
			for (int i = flag + 1; i <= n; i++) {
				if (s[i].str.equals("")) {
					ptr = i;
					break;
				}
			}
			if(ptr == -1) break;
			n--;
			s[flag].now += s[ptr].now;
			for (int i = ptr; i <= n; i++) {
				s[i].now = s[i + 1].now; 
				s[i].str = s[i + 1].str;
			}
		}
		return n;//合并常数项
	}
	
}
