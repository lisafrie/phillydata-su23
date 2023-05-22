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
			
			
			while (in.hasNext()) {
				String line = in.nextLine();
				tok = line.split(",");
				
				Property p = new Property();
				p.zipCode = tok[zipCodeIndex];
				p.area = tok[areaIndex];
				p.value = tok[valueIndex];
				
				properties.add(p);		
				
			}

			
		}
		catch (Exception e) {
		}
		
		return properties;
	}
}
