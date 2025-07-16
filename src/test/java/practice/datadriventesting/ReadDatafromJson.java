package practice.datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDatafromJson {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//step1:parse JSon Physical file in to Java Object  using JsonParse class
		JSONParser parser =new JSONParser();
Object obj=		parser.parse(new FileReader("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\appCommonData.json"));
//step2 :Convert java Object in to JsonObjext using downcasting
JSONObject map=(JSONObject)obj;
//step3:get the value from json
System.out.println(map.get("url"));
System.out.println(map.get("browser"));
System.out.println(map.get("username"));
System.out.println(map.get("password"));
System.out.println(map.get("timeout"));
		
	}

}
