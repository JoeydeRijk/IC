package ic2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbMain1 {
	public static void main(String[] args) throws JAXBException {
		File file = new File("C:\\Users\\Joey\\workspace\\jaxb-xml\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		// output mooi uitgelijnd
		
		Map<String,Address> map = new HashMap<String,Address>();
		
		
		
		Customer customer = new Customer();
		customer.setName("name");
		customer.setDateOfBirth("01-01-2001");
		
		Address address1= new Address();
		address1.setCity("city");
		address1.setStreet("street");
		address1.setZip("zip");
		
		Address address2= new Address();
		address2.setCity("city");
		address2.setStreet("street");
		address2.setZip("zip");
		
		map.put("Billing", address1);
		map.put("Shipping", address2);
		
		customer.setAddress(map);
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(customer, file);
	}

}
