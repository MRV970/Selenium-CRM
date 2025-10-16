package RestAssuredPractice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson_Deserialization {
	public static void main(String args []) throws StreamReadException, DatabindException, IOException {
		ObjectMapper om=new ObjectMapper();
	Book bDes=	om.readValue(new File("./Book.json"), Book.class);
		System.out.println(bDes.getName());
		System.out.println(bDes.getPages());
		System.out.println(bDes.getPrice());
		System.out.println(bDes.getColor());
		
		
	}

}
