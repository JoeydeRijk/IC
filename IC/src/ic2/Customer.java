package ic2;


import java.util.Map;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Customer {
		String name;
		String dateOfBirth;
		Map<String, Address> address;

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	@XmlElement
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Map<String, Address> getAddress() {
		return address;
	}
	@XmlElement
	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
	}

}
