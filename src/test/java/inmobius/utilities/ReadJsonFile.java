package inmobius.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;



public class ReadJsonFile {

	public void read_datafrom_json() throws IOException {
		String currentDir = System.getProperty("user.dir");
		String filePath = currentDir + File.separator + "sample1.json";
		System.out.println(filePath);         

		String content = new String(Files.readAllBytes(Paths.get(filePath)));
		System.out.println(content); 
                             
		JSONObject jsonObject = new JSONObject(content);
		String string = jsonObject.getString("fruit");
		System.out.println(string);
	}
}
