
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contact {
	private SimpleStringProperty firstName;
	private SimpleStringProperty middleName;
	private SimpleStringProperty lastName;
	
	private SimpleStringProperty company;
	
	private SimpleStringProperty email;
	
	public Contact(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}
	public Contact(String firstName, String lastName, String email) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty(email);
	}
	
	public Contact(String firstName, String middleName, String lastName, String company, String email) {
		this.firstName = new SimpleStringProperty(firstName);
		this.middleName = new SimpleStringProperty(middleName);
		this.lastName = new SimpleStringProperty(lastName);
		this.company = new SimpleStringProperty(company);
		this.email = new SimpleStringProperty(email);
	}
	
	private static File file = new File ("src/application/data.txt");
	
	public static ObservableList<Contact> loadCSV() throws Exception {
		ObservableList<Contact> list = FXCollections.observableArrayList();
		BufferedReader br = new BufferedReader(new FileReader(Contact.file));
		String line = br.readLine();
		while (line != null) {
			String[] fields = line.split(",");
			Contact contact = new Contact(fields[0],fields[1],fields[2],fields[3],fields[4]);
			list.add(contact);
			line = br.readLine();
		}
		return list;
	}
	
	public static void saveCSV(ObservableList<Contact> list) {
		//To Do: Complete this method to write list to Contact.file
	}
	public SimpleStringProperty getFirstName() {
		return(this.firstName);
	}
	public void setFirstName(String firstName) {
    	this.firstName.set(firstName);
	}
	public SimpleStringProperty getlastName() {
	return(this.lastName);
	}
	public void setLastName(String lastName) {
    	this.lastName.set(lastName);
	}
	public SimpleStringProperty getMiddleName() {
		return(this.middleName);
	}
	public void setMiddleName(String middleName) {
    	this.middleName.set(middleName);
	}
	public SimpleStringProperty getEmail() {
		return(this.email);
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	public SimpleStringProperty getCompany() {
		return(this.company);
	}
	public void setCompany(String company) {
		this.company.set(company);
}
}