package lab;

public class simplify {
	static void Combination(int n, node s[]) {   //�����ֺϲ�
		for (int i = 1; i <= n; i++) {
			String digit = "";
			String character = "";
			for (int j = 0; j < s[i].str.length(); j++) {//����ÿһ������
				if (Character.isDigit(s[i].str.charAt(j))) {
					digit += s[i].str.charAt(j);//��������
				} else {
					character += s[i].str.charAt(j);//��ĸ����
					if (!digit.equals(""))
						s[i].now *= Integer.parseInt(digit);//ÿ������һ�η����֣�Ԥ�������ֺ�ԭֵ���
					digit = "";
				}
			}
			if (!digit.equals("")) {
				s[i].now *= Integer.parseInt(digit);//���һ����Ŀ����������
			}
			s[i].str = character;//��ĸ�����
		}
	}//Ч�������ʽ��ʽתΪ��digit ��*��character
	static void simplify(String Choice, int n, node s[]) {   //���ʽ��ֵ
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
			} //��ȡ����
			int now = Integer.parseInt(tn);
			for (int i = 1; i <= n; i++) {
				String tmp = "";
				for (int j = 0; j < s[i].str.length(); j++) {
					if (s[i].str.charAt(j) == c) {
						s[i].now *= now;
					} else {
						tmp += s[i].str.charAt(j);
					}
				}//�ַ�����滻�������������
				s[i].str = tmp;
			}
		}
	}
	
	static void Print(int n, node s[]) { //���
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
