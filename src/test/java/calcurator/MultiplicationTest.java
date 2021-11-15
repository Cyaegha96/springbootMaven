package calcurator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MultiplicationTest {

	private final Multiplication addition = new Multiplication();
	
	@Test
	public void shouldMatchOperation() {
		assertThat(addition.handles('*')).isTrue();
		assertThat(addition.handles('/')).isFalse();
	}
	
	@Test
	public void shouldCorrectApplyFormula() {
		assertThat(addition.apply(2, 2)).isEqualTo(4);
		assertThat(addition.apply(12, 10)).isEqualTo(120);
	}
}
