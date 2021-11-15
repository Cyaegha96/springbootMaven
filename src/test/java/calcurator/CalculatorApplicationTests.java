package calcurator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class CalculatorApplicationTests {
	

	
	@Autowired
	private Calculator calculator;
	
	@Test(expected = IllegalArgumentException.class)
	public void doingDivisionShouldFail() {
		calculator.calcurate(12, 13, '/');
	}
}
