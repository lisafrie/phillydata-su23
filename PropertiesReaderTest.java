import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PropertiesReaderTest {

	@Test
	public void test1() {
		PropertiesReader pr = new PropertiesReader("properties.csv");
		List<Property> properties = pr.readProperties();
		
		assertNotNull(properties);
		assertEquals(579721, properties.size());
		assertTrue(properties.contains(new Property("191310000", "1152.0", "48200.0")));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test2() {
		PropertiesReader pr = new PropertiesReader(null);
		pr.readProperties();
	}

	@Test(expected=IllegalArgumentException.class)
	public void test3() {
		PropertiesReader pr = new PropertiesReader(" ");
		pr.readProperties();
	}
	
	@Test(expected=IllegalStateException.class)
	public void test4() {
		PropertiesReader pr = new PropertiesReader("i don't exist");
		pr.readProperties();
	}

	@Test
	public void test5() {
		PropertiesReader pr = new PropertiesReader("properties-reorder.csv");
		List<Property> properties = pr.readProperties();
		
		assertNotNull(properties);
		assertEquals(2, properties.size());
		assertTrue(properties.contains(new Property("19104", "800", "300000")));
	}
	
	@Test(expected=IllegalStateException.class)
	public void test6() {
		// missing total_livable_area header
		PropertiesReader pr = new PropertiesReader("properties-bad1.csv");
		pr.readProperties();
	}
	
	@Test(expected=IllegalStateException.class)
	public void test7() {
		// missing zip_code header
		PropertiesReader pr = new PropertiesReader("properties-bad2.csv");
		pr.readProperties();
	}
	
	@Test(expected=IllegalStateException.class)
	public void test8() {
		// missing market_value header
		PropertiesReader pr = new PropertiesReader("properties-bad3.csv");
		pr.readProperties();
	}
	
	@Test
	public void test9() {
		// one row does not have all the values
		PropertiesReader pr = new PropertiesReader("properties-bad4.csv");
		List<Property> properties = pr.readProperties();
		
		assertNotNull(properties);
		assertEquals(2, properties.size());
		assertTrue(properties.contains(new Property("19104", "800", "300000")));
	}

}
