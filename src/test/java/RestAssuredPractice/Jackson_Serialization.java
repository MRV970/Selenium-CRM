package RestAssuredPractice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;


class Book{
	private String name;       
	private int pages;       
	private double price;    
	private String color;    
	
	private Book() {
		
	}
	

	public Book(String name, int pages, double price, String color) {
		super();
		this.name = name;
		this.pages = pages;
		this.price = price;
		this.color = color;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}

public class Jackson_Serialization {
	public static void main(String args []) throws StreamWriteException, DatabindException, IOException {
		Book bobj=new Book("SQL",500,1000.0,"green");
		ObjectMapper om=new ObjectMapper();
		om.writeValue(new File("./Book.json"),bobj);
		
			
			
	}
	
	

}
