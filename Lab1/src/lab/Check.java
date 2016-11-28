package lab;

public class Check {
	static String preStr(String s) {  //���Գ˺�
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
			}//�ҵ������ĳ˺ţ��˺�����������
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
			}//��˺���������ķ�����
			String s1 = "", s2 = "";
			for (int i = fn; i < flag; i++) s1 += s.charAt(i);
			for (int i = flag + 1; i <= fg; i++) s2 += s.charAt(i);
			int now = Integer.parseInt(s1);
			now *= Integer.parseInt(s2);//���ִ��룬תint
			for (int i = 0; i < fn; i++) tmp += s.charAt(i);
			tmp += String.valueOf(now);
			for (int i = fg + 1; i < s.length(); i++) tmp += s.charAt(i);
			s = tmp;//�����Ԫ����ԭ������
		}
		tmp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '*') tmp += s.charAt(i);
		}//ɾ�����г˺�
		return tmp;
	}//Ч����������digit��digit���͵��Ӵ��ϲ�Ϊһ�����֣�����ɾ�����г˺�
	static boolean Judge(String s) {  //�жϱ��ʽ�Ƿ�Ϊ0
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
	static int Pre(String ori, node s[]) {  //Ԥ����ָ�+��
		int n = 0;
		String tmp = "";
		for (int i = 0; i < ori.length(); i++) {
			if (ori.charAt(i) != '+') {
				tmp += ori.charAt(i);
			} else {
				s[++n] = new node(1, tmp);
				tmp = "";
			}
		}//����+�ŷָ���ʽ������ṹ�������е�String
		if (!tmp.equals("")) {
			s[++n] = new node(1, tmp);
			tmp = "";
		}//����ĩβ��һ������
		return n;
	}//Ч�������������ṹ��������
	
	static boolean Check(String ori) {  //�鿴���ʽ�Ƿ�Ϸ�
		for (int i = 0; i < ori.length(); i++) {
			if (ori.charAt(i) >= '0' && ori.charAt(i) <= '9') continue;
			if (ori.charAt(i) >= 'a' && ori.charAt(i) <= 'z') continue;
			if (ori.charAt(i) == '+' || ori.charAt(i) == '*') continue;
			return true;// �Ϸ��ַ����
		}
		if (ori.charAt(0) == '+' || ori.charAt(ori.length() - 1) == '+') return true;
		if (ori.charAt(0) == '*' || ori.charAt(ori.length() - 1) == '*') return true;
		for (int i = 0; i < ori.length() - 1; i++) {
			if (ori.charAt(i) == '+' || ori.charAt(i) == '*') {
				if (ori.charAt(i + 1) == '+' || ori.charAt(i + 1) == '*') return true;
			}
		}//+ *λ���жϱ��ʽ����
		if (Judge(ori)) return true;//���ʽ�в�����0
		return false;
	}
}
