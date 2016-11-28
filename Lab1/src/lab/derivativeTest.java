package lab;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class derivativeTest {


	@Test
	public void testDerivative1() {
		derivative test=new derivative();
		String result=test.derivative("!d/d x");
		assertEquals("1*1*y+2*1",result);
	}
	@Test
	public void testDerivative2() {
		derivative test=new derivative();
		String result=test.derivative("!d/d y");
		assertEquals("1*x*1+2*x",result);
	}
	
	@Test
	public void testDerivative3() {
		derivative test=new derivative();
		String result=test.derivative("!d/d a");
		assertEquals("Error",result);
	}
	@Test
	public void testDerivative4() {
		derivative test=new derivative();
		String result=test.derivative("!d/d ax");
		assertEquals("Error",result);
	}
}
