package br.sefaz.com.massa;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Rule;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class LeitorMassaDados {
    
	@Rule
	static JSONParser parser = new JSONParser();

    public static JSONObject leitorMassa(String jsonFileName, String dataGroup) {
        jsonFileName = osAdaptFileName(jsonFileName);
        JSONObject massaDados = null;
        try {
            Object jsonFileObject = null;
			try {
				jsonFileObject = parser.parse(new FileReader(System.getProperty("user.dir") + File.separator + "src" +
				        File.separator + "test" + File.separator + "evidencias" + File.separator + "massa" + File.separator + jsonFileName));
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			massaDados = (JSONObject) jsonFileObject;
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert massaDados != null;
        return (JSONObject) massaDados.get(dataGroup);
     }

    private static String osAdaptFileName(String baseFileName) {
        if (System.getProperty("os.name").startsWith("Windows")) {
            baseFileName += ".json";
        }
        return baseFileName;
    }

   	    protected String getJsonDataProperty(JSONObject jsonData, String jsonProperty){
        return new String(jsonData.get(jsonProperty).
                toString().getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
    }
}
