package test.com.sapient;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MockitoDemo {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		 //You can mock concrete classes, not just interfaces
		 LinkedList mockedList = mock(LinkedList.class);
		 
		 
		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");
		 
		 verify(mockedList, times(4)).add("three times");

		 //stubbing
//		 when(mockedList.get(0)).thenReturn("first");
//		 when(mockedList.get(1)).thenReturn("second");
//		 
//		 when(mockedList.get(2)).thenThrow(new RuntimeException());
//
//		 //following prints "first"
//		 System.out.println(mockedList.get(0));
//
//		 //following throws runtime exception
//		 System.out.println(mockedList.get(1));
//
//		 //following prints "null" because get(999) was not stubbed
//		 System.out.println(mockedList.get(99));

		 //Although it is possible to verify a stubbed invocation, usually it's just redundant
		 //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
		 //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
//		 verify(mockedList).get(0);
//		 verify(mockedList).get(1);
	}

}
