import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class MarketValuePerCapitaTest {

	@Test
	public void test1() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals((500000+400000)/50000, valuePerCapita, 0);
	}
	
	@Test
	public void test2() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19103", "700", "400000"));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals((500000+400000)/50000, valuePerCapita, 0);
	}
	
	@Test
	public void test3() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "800", "400001"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals((500000+400001)/50000.0, valuePerCapita, 0);
	}

	@Test
	public void test4() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "900", " "));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals((500000+400000)/50000, valuePerCapita, 0);
	}
	
	@Test
	public void test5() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "900", null));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals((500000+400000)/50000, valuePerCapita, 0);
	}
	
	@Test
	public void test6() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "900", "dog"));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals((500000+400000)/50000, valuePerCapita, 0);
	}
	
	@Test
	public void test7() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("191041234", "1000", "500000"));
		p.properties.add(new Property("191045678", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals((500000+400000)/50000, valuePerCapita, 0);
	}
	
	@Test
	public void test8() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "1000", "-300000"));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals((500000+400000)/50000, valuePerCapita, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test9() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.marketValuePerCapita(null);	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test10() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.marketValuePerCapita(" ");	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test11() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.marketValuePerCapita("123");	
	}
	
	@Test(expected=IllegalStateException.class)
	public void test12() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.marketValuePerCapita("19104");	
	}
	
	@Test(expected=IllegalStateException.class)
	public void test13() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.populationMap = new HashMap<>();
		p.marketValuePerCapita("19104");	
	}
	
	@Test
	public void test14() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19103");		
		assertEquals(0, valuePerCapita, 0);
	}
	
	@Test
	public void test15() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19103", 50000);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals(0, valuePerCapita, 0);
	}
	
	@Test
	public void test16() {
		PhillyDataProcessor p = new PhillyDataProcessor();
		p.properties = new HashSet<>();
		p.properties.add(new Property("19104", "1000", "500000"));
		p.properties.add(new Property("19104", "800", "400000"));
		p.populationMap = new HashMap<>();
		p.populationMap.put("19104", 0);
		
		double valuePerCapita = p.marketValuePerCapita("19104");		
		assertEquals(0, valuePerCapita, 0);
	}
}
