package opdracht2.REST;
//HIER WORDT EEN JSON BESTAND MEEGEGEVEN DIE FOUTIEVE DATA BEVAT
 
public class FoutGasClient2 {
	public static void main(String[] args) {
		new Service("src/main/java/opdracht2/REST/FOUT.txt","http://localhost:8040/REST/gaskostenPM");
	}
}