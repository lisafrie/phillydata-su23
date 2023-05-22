import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class PopulationReaderTest {

	@Test
	public void test1() {
		
		PopulationReader pr = new PopulationReader("population.txt");
		
		Map<String, Integer> map = pr.readPopulation();
		
		assertNotNull(map);
		assertEquals(48, map.size());
		assertEquals(4705, map.get("19102").intValue());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test2() {
		PopulationReader pr = new PopulationReader(null);
		pr.readPopulation();		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test3() {
		PopulationReader pr = new PopulationReader(" ");
		pr.readPopulation();		
	}
	
	@Test(expected=IllegalStateException.class)
	public void test4() {
		PopulationReader pr = new PopulationReader("i don't exist");
		pr.readPopulation();		
	}
	
	@Test
	public void test5() {
		// this tests the case where a zipcode is missing
		PopulationReader pr = new PopulationReader("population-bad1.txt");
		
		Map<String, Integer> map = pr.readPopulation();
		
		assertNotNull(map);
		assertEquals(2, map.size());
		assertEquals(51808, map.get("19104").intValue());
		
	}
	

	@Test
	public void test6() {
		// this tests the case where a zipcode is non-numeric
		PopulationReader pr = new PopulationReader("population-bad2.txt");
		
		Map<String, Integer> map = pr.readPopulation();
		
		assertNotNull(map);
		assertEquals(2, map.size());
		assertEquals(51808, map.get("19104").intValue());
		
	}


}
