import static org.junit.Assert.*;

import org.junit.Test;

public class PhillyDataProcessorTest {

	@Test
	public void test1() {
		PhillyDataProcessor p = new PhillyDataProcessor("properties.csv", "population.txt");
		double valuePerCapita = p.marketValuePerCapita("19104");
		assertEquals(201930.7, valuePerCapita, 0.1);
	}

}
