package test.com.sapient;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sapient.Atm;

public class TestAtm {
	
	Atm atm;

	@Before
	public void setUp() throws Exception {
		atm = new Atm();
	}

	@Test(timeout=2000)
	public void test() {
		double result = atm.cashWithdraw();
		assertEquals(2000.00, result, 0.1);
	}

}
