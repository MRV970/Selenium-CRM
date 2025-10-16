package RestAssuredPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {

	public static void main(String args []) throws IOException, ClassNotFoundException {
		FileInputStream fis=new FileInputStream("./File.txt");
		ObjectInputStream oi=new ObjectInputStream(fis);
		A aobj=(A)oi.readObject();
		System.out.println(aobj.Name);
		System.out.println(aobj.No);
		System.out.println(aobj.ph);
			
		
		
		
		
	}
}
