package lab;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckTest {


	@Test
	public void testCheck1() {
		Check test=new Check();
			boolean result=test.Check("1+3x");
			boolean True=false;
			assertEquals(True,result);
	}
	
	@Test
	public void testCheck2() {
		Check test=new Check();
			boolean result=test.Check("1+3xYz");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck3() {
		Check test=new Check();
			boolean result=test.Check("1+30x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck4() {
		Check test=new Check();
			boolean result=test.Check("1+3*x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck5() {
		Check test=new Check();
			boolean result=test.Check("1.0+3*x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck6() {
		Check test=new Check();
			boolean result=test.Check("1-x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck7() {
		Check test=new Check();
			boolean result=test.Check("1@#$¡±?");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck8() {
		Check test=new Check();
			boolean result=test.Check("2+3^x");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck9() {
		Check test=new Check();
			boolean result=test.Check("2/3+x");
			boolean True=false;
			assertEquals(True,result);
	}
	
	@Test
	public void testCheck10() {
		Check test=new Check();
			boolean result=test.Check("2+(x)");
			boolean True=false;
			assertEquals(True,result);
	}
	@Test
	public void testCheck11() {
		Check test=new Check();
			boolean result=test.Check("1+parameter");
			boolean True=false;
			assertEquals(True,result);
	}

}
