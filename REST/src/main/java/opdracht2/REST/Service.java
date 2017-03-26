package opdracht2.REST;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Service {
	public Service(String path, String URL) {
		JSONParser parser = new JSONParser();  		
		String line;
			try {
				Object obj = parser.parse(new FileReader(path));
				JSONObject jsonObject = (JSONObject) obj;
				URL url = new URL(URL);
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = in.readLine()) != null) {
					System.out.print(line);
				}
				in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Het opgegeven bestand kan niet gevonden worden.");
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println("Er is iets fout gegaan: ");
            e.printStackTrace();
        } catch (ParseException e) {
        	System.out.println("Het opgegeven bestand is niet valide.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
        	System.out.println("Het opgegeven bestand bevat niet de goede datatypen (Het moet een nummer zijn, en niet een woord)");

            e.printStackTrace();
        }
	}
}