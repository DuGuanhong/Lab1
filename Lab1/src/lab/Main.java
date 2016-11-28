package lab;

import java.util.*;

class node {
	int now;
	String str;
	node(int now, String str) {
		this.now = now;
		this.str = str;
	}
}

public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Check  st= new Check();
		instruction ins = new instruction();
		String tmp = ins.Read();
		String ori = tmp;   //������ʽ
		if (st.Check(ori)) {   //�жϱ��ʽ�Ƿ�Ϸ�
			System.out.println("Error!");
			return;
		}
		simplify si = new simplify();
		System.out.println("Success!");  
		ori = st.preStr(ori);   //Ч����������digit��digit���͵��Ӵ��ϲ�Ϊһ�����֣�����ɾ�����г˺�
		node [] s = new node[205];
		int n = st.Pre(ori, s);//Ԥ����ָ�+��
		si.Combination(n, s);//Ч�������ʽ��ʽתΪ��digit ��*��character
		CheckDer de = new CheckDer();
		
		derivative der = new derivative();
		Choice ch = new Choice();
		ch.SaveIn(ori, s);
		while (in.hasNext()) {
			String Choice = in.nextLine();
			if (de.CheckDer(Choice, n, s)) {//�Ƿ����󵼣�
				der.derivative(Choice); //��
			} else if (de.CheckSim(Choice, n, s)) {//�Ƿ�����ֵ��
				si.simplify(Choice, n, s);  //��ֵ
			} else {
				System.out.println("Error!");
			}
			expression ex = new expression();
			n = ex.expression(n, s); //����
			si.Print(n, s);  //���
		}
	}
}
