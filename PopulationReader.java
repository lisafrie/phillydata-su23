import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationReader {
	
	protected String file;
	
	public PopulationReader(String file) {
		this.file = file;
	}
	
	public Map<String, Integer> readPopulation() {
		if (file == null || file.isBlank()) { 
			throw new IllegalArgumentException("Invalid file name");
		}
		
		Map<String, Integer> map = new HashMap<>();
		
		try (Scanner in = new Scanner(new File(file))) {
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] tok = line.split(" ");
				String zip = tok[0];
				int population = Integer.parseInt(tok[1]);
				map.put(zip, population);
			}
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
		return map;
	}

}
