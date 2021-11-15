package calcurator;

import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorTest{
	
	private Calculator calculator;
	private Operation mockOperation;
	
	@Before
	public void setup() {
		mockOperation = Mockito.mock(Operation.class);
		calculator = new Calculator(Collections.singletonList(mockOperation));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWhenNoSuitableOperationFound() {
			
			when(mockOperation.handles(anyChar())).thenReturn(false);
			calculator.calcurate(2, 2, '*');
	}
	
	@Test
	public void shouldCallApplyMethodWhenSuitableOperationFound() {
		when(mockOperation.handles(anyChar())).thenReturn(true);
		when(mockOperation.apply(2,2)).thenReturn(4);
		calculator.calcurate(2, 2, '*');
		
		verify(mockOperation, times(1)).apply(2,2);
	}
}