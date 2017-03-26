package opdracht2.REST;

 
public class GasClient {
	public static void main(String[] args) {
		new Service("src/main/java/opdracht2/REST/GAS.txt","http://localhost:8040/REST/gaskostenPM");
	}
}