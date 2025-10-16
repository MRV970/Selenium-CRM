package RestAssuredPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A  implements Serializable{
	String Name;
	int No;
	long ph;
	
	public A(String Name,int No, long ph) {
		this.Name=Name;
		this.No=No;
		this.ph=ph;
	}
	
	}
public class SerializationPractice {
	
	public static void main(String args []) throws IOException {
		A a=new A("mrv",12,9087654321l);
		FileOutputStream fos =new FileOutputStream("./File.txt");
		ObjectOutputStream os=new ObjectOutputStream(fos);
		os.writeObject(a);
		
	}

	
}
