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
		String ori = tmp;   //读入表达式
		if (st.Check(ori)) {   //判断表达式是否合法
			System.out.println("Error!");
			return;
		}
		simplify si = new simplify();
		System.out.println("Success!");  
		ori = st.preStr(ori);   //效果：将所有digit×digit类型的子串合并为一个数字，并且删除所有乘号
		node [] s = new node[205];
		int n = st.Pre(ori, s);//预处理分割+号
		si.Combination(n, s);//效果：表达式形式转为：digit （*）character
		CheckDer de = new CheckDer();
		
		derivative der = new derivative();
		Choice ch = new Choice();
		ch.SaveIn(ori, s);
		while (in.hasNext()) {
			String Choice = in.nextLine();
			if (de.CheckDer(Choice, n, s)) {//是否是求导？
				der.derivative(Choice); //求导
			} else if (de.CheckSim(Choice, n, s)) {//是否是求值？
				si.simplify(Choice, n, s);  //求值
			} else {
				System.out.println("Error!");
			}
			expression ex = new expression();
			n = ex.expression(n, s); //化简
			si.Print(n, s);  //输出
		}
	}
}
