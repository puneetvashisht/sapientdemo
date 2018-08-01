package test.com.sapient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sapient.Calc;

public class TestCalc {
	
	private static Calc calc;
	
	@BeforeClass
	public static void setUpOnce(){
		System.out.println("Just once");
		calc = new Calc();
	}

	@Before
	public void setUp(){
		System.out.println("Before every test case");
//		calc = new Calc();
	}

	@Test
	public void testAdd() {
//		fail("Not yet implemented");
		
		int result = calc.sum(1,2,3);
		assertEquals(6, result);
	}
	
	@Test
	public void testMultiply() {
//		fail("Not yet implemented");
//		Calc calc = new Calc();
		int result = calc.mul(1,2,3);
		assertEquals(6, result);
	}
	
	@Test
	public void testMultiplyWithNegativeValues() {
//		fail("Not yet implemented");
//		Calc calc = new Calc();
		int result = calc.mul(-1,-2,-3);
		assertEquals(-6, result);
	}
	
	@Test
	public void divide(){
		int result = calc.divide(4,2);
		assertEquals(2, result);
		
	}
	@Test
	public void divideWithNegativeValues(){
		int result = calc.divide(-4,-2);
		assertEquals(2, result);
		
	}
	@Test
	public void divideWithDecimalValules(){
		double result = calc.divide(4.4,2);
		assertEquals(2.2, result, 0.001);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void divideWithZeroDivisor(){
		int result = calc.divide(4,0);
		assertTrue(true);
		
	}
	
//	@Test
	public void testAssertions() {
		String first = new String("Ginger");
		String second = new String("Ginger");
		assertThat(first, not(equalTo("Honey")));
	}

}
