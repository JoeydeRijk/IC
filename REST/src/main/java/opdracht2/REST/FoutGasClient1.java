package opdracht2.REST;
//HIER WORDT EEN JSON BESTAND MEEGEGEVEN DIE NIET BESTAAT
 
public class FoutGasClient1 {
	public static void main(String[] args) {
		new Service("src/main/java/opdracht2/REST/FO.txt","http://localhost:8040/REST/gaskostenPM");
	}
}