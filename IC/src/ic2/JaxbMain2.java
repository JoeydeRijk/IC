package ic2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbMain2 {

	public static void main(String[] args) throws JAXBException {
		File file = new File("C:\\Users\\Joey\\workspace\\jaxb-xml\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customerIn = (Customer) jaxbUnmarshaller.unmarshal(file);	
		System.out.println(customerIn);
}
}
