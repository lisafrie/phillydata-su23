import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhillyDataProcessor {
	
	protected PropertiesReader propertiesReader;
	protected PopulationReader populationReader;
	
	protected Set<Property> properties;
	protected Map<String, Integer> populationMap;
	
	public PhillyDataProcessor(String file1, String file2) {
		
		propertiesReader = new PropertiesReader(file1);
		List<Property> propertiesList = propertiesReader.readProperties();
		// convert List to Set in order to remove duplicates
		properties = new HashSet<>();
		for (Property p: propertiesList) {
			properties.add(p);
		}
		
		populationReader = new PopulationReader(file2);
		populationMap = populationReader.readPopulation();
		
	}
	
	public PhillyDataProcessor() {
		
	}

	
	public double marketValuePerCapita(String zip) {
		
		if (zip == null || zip.length() != 5) {
			throw new IllegalArgumentException("Illegal zip code");
		}
		if (properties == null) {
			throw new IllegalStateException();
		}
		if (populationMap == null) {
			throw new IllegalStateException();
		}
		
		double total = 0;
		
		for (Property p : properties) {
			if (p.zipCode != null && p.zipCode.length() >= 5 && p.zipCode.substring(0, 5).equals(zip)) {
				if (p.value != null && p.value.isBlank() == false) {
					try {
						double value = Double.parseDouble(p.value);
						if (value > 0) {
							total += value;
						}
					} catch (NumberFormatException e) {

					}
				} 

			}
			
		}

		Integer population = populationMap.get(zip);
		if (population == null || population == 0) {
			return 0.0;
		}
	
		return total / population;
		
	}
}
