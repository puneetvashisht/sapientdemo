package test.com.sapient;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.sapient.MathUtils;

@RunWith (Parameterized.class)
public class TestWithParams {
	
//	@Parameters(name = "{index} Item : Run #Square of : {0}^2={1}")
	@Parameters//(name = "{index} Item : Run #Square of : {0}^2={1}")
	public static Iterable<Object [] > data(){
		return Arrays.asList(new Object [][]{ {1,1}, {2,14}, {3,9}, {4,16}, {5,25} });
	}
	
	private final int input;
	private final int resultExpected;
	
	public TestWithParams(final int input, final int result){
		this.input = input;
		this.resultExpected = result;
	}
	
	@Test
	public void testSquaresList(){
		assertEquals(resultExpected, MathUtils.square(input));
	}


}
