import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class lab1Test1 {


	@Test
	public void testCheck1() {
		lab1 test=new lab1();
			boolean result=test.Check("1+3x");
			boolean True=false;
			assertEquals(True,result);
	}
	
	@Test
	public void testCheck2() {
		lab1 test=new lab1();
			boolean result=test.Check("1+3xYz");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck3() {
		lab1 test=new lab1();
			boolean result=test.Check("1+30x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck4() {
		lab1 test=new lab1();
			boolean result=test.Check("1+3*x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck5() {
		lab1 test=new lab1();
			boolean result=test.Check("1.0+3*x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck6() {
		lab1 test=new lab1();
			boolean result=test.Check("1-x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck7() {
		lab1 test=new lab1();
			boolean result=test.Check("1@#$”?");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck8() {
		lab1 test=new lab1();
			boolean result=test.Check("2+3^x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck9() {
		lab1 test=new lab1();
			boolean result=test.Check("2/3+x");
			boolean True=false;
			assertEquals(True,result);
	}
	
	@Test
	public void testCheck10() {
		lab1 test=new lab1();
			boolean result=test.Check("2+(x)");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck11() {
		lab1 test=new lab1();
			boolean result=test.Check("1+parameter");
			boolean True=false;
			assertEquals(True,result);
	}

}
