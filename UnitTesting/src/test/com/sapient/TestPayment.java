package test.com.sapient;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sapient.Payment;
import com.sapient.Sms;
import com.sapient.TransactionRepo;

@RunWith(MockitoJUnitRunner.class)
public class TestPayment {
	
	@Mock Sms smsMock;
	@Mock TransactionRepo repoMock;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFundsTransfer() {
		
//		Sms smsMock = mock(Sms.class);
//		TransactionRepo repo = new TransactionRepoStub();
//		TransactionRepo repoMock = mock(TransactionRepo.class);
		when(smsMock.sendMessage(anyString()))
		   .thenReturn(true);
		
		when(repoMock.transact(anyInt(), anyDouble()))
		   .thenReturn(true);
		
		Payment payment = new Payment(repoMock, smsMock);
		boolean result = payment.fundsTransfer(123, 456, 10000);
		
		verify(smsMock, times(1)).sendMessage(anyString());
		verify(repoMock, times(2)).transact(anyInt(), anyDouble());
		
		System.out.println(result);
		assertTrue(result);
	}

}
