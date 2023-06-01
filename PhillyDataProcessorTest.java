import static org.junit.Assert.*;

import org.junit.Test;

public class PhillyDataProcessorTest {

	@Test
	public void test1() {
		PhillyDataProcessor p = new PhillyDataProcessor("C:/Users/lisaf/Documents/CIS-5730/phillydata-su23/properties.csv", "C:/Users/lisaf/Documents/CIS-5730/phillydata-su23/population.txt");
		double valuePerCapita = p.marketValuePerCapita("19104");
		assertEquals(201930.7, valuePerCapita, 0.1);
	}

}
