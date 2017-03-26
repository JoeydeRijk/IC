package opdracht2.REST;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
@Path("/")
public class App {
	@POST
	@Path("/kostenPM")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response kostenPM(InputStream incomingData) {
		
		StringBuilder stringbuilder = new StringBuilder();
		JSONParser parser= new JSONParser();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			
			Object object = parser.parse(in);
			
			JSONObject jsonObject = (JSONObject) object;
			 
            Double vastgoedPM = Double.valueOf(jsonObject.get("VastgoedPM").toString());
            Double kostenPerKWH = Double.valueOf(jsonObject.get("KostenPerKWH").toString());
            Double verbruikteKWH = Double.valueOf( jsonObject.get("VerbruikteKWH").toString());
            stringbuilder.append("Prijs per maand voor elektriciteit: " );
            stringbuilder.append(((kostenPerKWH * verbruikteKWH) + vastgoedPM));
            
			
		} catch (Exception e) {
			System.out.println("Error Parsing: - " + e);
		}
		System.out.println("Data Received: " + stringbuilder.toString());
 
		return Response.status(200).entity(stringbuilder.toString()).build();
	}
	@POST
	@Path("/gaskostenPM")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response gasKostenPM(InputStream incomingData) {
		
		StringBuilder stringbuilder = new StringBuilder();
		JSONParser parser= new JSONParser();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			
			Object object = parser.parse(in);
			
			JSONObject jsonObject = (JSONObject) object;
			 
            Double gasVastgoedPM = Double.valueOf(jsonObject.get("GasVastgoedPM").toString());
            Double KostenPerM3 = Double.valueOf(jsonObject.get("KostenPerM3").toString());
            Double VerbruikM3 = Double.valueOf( jsonObject.get("VerbruikM3").toString());
            stringbuilder.append("Prijs per maand voor gas: " );
            stringbuilder.append(Math.round(((KostenPerM3 * VerbruikM3) + gasVastgoedPM) * 100.0) /100.0);
            
			
		} catch (Exception e) {
			System.out.println("Error Parsing: - " + e);
		}
		System.out.println("Data Received: " + stringbuilder.toString());
 
		return Response.status(200).entity(stringbuilder.toString()).build();
	}
	
 
}