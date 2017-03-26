package opdracht2.REST;
//HIER WORDT EEN JSON BESTAND MEEGEGEVEN MET FOUTIEVE DATATYPES
 
public class FoutGasClient3 {
	public static void main(String[] args) {
		new Service("src/main/java/opdracht2/REST/FOUT2.txt","http://localhost:8040/REST/gaskostenPM");
	}
}