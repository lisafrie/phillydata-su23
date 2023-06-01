import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class PropertiesReader {
	
	protected String filename;
	
	public PropertiesReader(String filename) {
		this.filename = filename;
	}
	
	public List<Property> readProperties() {

		if (filename == null || filename.isBlank()) {
			throw new IllegalArgumentException("File name is not valid");
		}
		
		List<Property> properties = new LinkedList<>();
		
		
		try (Scanner in = new Scanner(new File(filename))) {
						
			String header = in.nextLine();
			
			String[] tok = header.split(",");
			int zipCodeIndex = -1;
			int areaIndex = -1;
			int valueIndex = -1;
			for (int i = 0; i < tok.length; i++) {
				if (tok[i].equals("zip_code")) {
					zipCodeIndex = i;
				}
				else if (tok[i].equals("total_livable_area")) {
					areaIndex = i;
				}
				else if (tok[i].equals("market_value")) {
					valueIndex = i;
				}
				
			}
			
			if (zipCodeIndex == -1) {
				throw new IllegalStateException("zip_code header missing");
			}
			if (areaIndex == -1) {
				throw new IllegalStateException("area header missing");
			}
			if (valueIndex == -1) {
				throw new IllegalStateException("value header missing");
			}
			
			while (in.hasNext()) {
				String line = in.nextLine();
				tok = line.split(",");
								
				Property p = new Property();
				
				if (tok.length > zipCodeIndex) {
					p.zipCode = tok[zipCodeIndex];
				} else {
					continue;
				}
				
				if (tok.length > areaIndex) {
					p.area = tok[areaIndex];
				} else {
					continue;
				}
				
				if (tok.length > valueIndex) {
					p.value = tok[valueIndex];
				} else {
					continue;
				}
				
				properties.add(p);		
				
			}

			
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
		
		return properties;
	}
}
