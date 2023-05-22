
public class Property {
	
	public String zipCode;
	public String area;
	public String value;
	
	public Property (String zipCode, String area, String value) {
		this.zipCode = zipCode;
		this.area = area;
		this.value = value;
	}
	
	public Property () {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj instanceof Property == false) return false;
		Property other = (Property)obj;
		return other.zipCode.equals(this.zipCode) 
				&& other.area.equals(this.area)
				&& other.value.equals(this.value);
	}
	
	@Override
	public int hashCode() {
		int hashcode = 0;
		if (zipCode != null) hashcode += zipCode.hashCode();
		if (area != null) hashcode += area.hashCode();
		if (value != null) hashcode += value.hashCode();
		return hashcode;
	}
	
	@Override
	public String toString() {
		return "zipCode: " + zipCode + ", area: " + area + ", value: " + value;
	}

}
