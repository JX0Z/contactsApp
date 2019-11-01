package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contact {
	private SimpleStringProperty firstName;
	private SimpleStringProperty middleName;
	private SimpleStringProperty lastName;

	private SimpleStringProperty company;

	private SimpleStringProperty email;
	
	private static File file = new File("src/application/data.txt");

	public Contact(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.middleName = new SimpleStringProperty("");
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty("");
		this.company = new SimpleStringProperty("");
	}

	public Contact(String firstName, String middleName, String lastName, String company, String email) {
		this.firstName = new SimpleStringProperty(firstName);
		this.middleName = new SimpleStringProperty(middleName);
		this.lastName = new SimpleStringProperty(lastName);
		this.company = new SimpleStringProperty(company);
		this.email = new SimpleStringProperty(email);
	}

	public static ObservableList<Contact> loadCSV() throws Exception {
		ObservableList<Contact> list = FXCollections.observableArrayList();
		BufferedReader br = new BufferedReader(new FileReader(Contact.file));
		String line = br.readLine();
		while (line != null) {
			String[] fields = line.split(",");
			Contact contact = new Contact(fields[0], fields[1], fields[2], fields[3], fields[4]);
			list.add(contact);
			line = br.readLine();
		}
		br.close();
		return list;
	}

	public static void saveCSV(ObservableList<Contact> list) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(Contact.file));
		for (int i = 0; i<list.size(); i++) {
			bw.write(
				list.get(i).getFirstName() +"," +
				list.get(i).getMiddleName() +"," +
				list.get(i).getLastName() +"," +
				list.get(i).getCompany() +"," +
				list.get(i).getEmail() +",\n"
			);
		}
		bw.flush();
		bw.close();
	}

	public String getFirstName() {
		return (this.firstName.get());
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public String getLastName() {
		return (this.lastName.get());
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public String getMiddleName() {
		return (this.middleName.get());
	}

	public void setMiddleName(String middleName) {
		this.middleName.set(middleName);
	}

	public String getEmail() {
		return (this.email.get());
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public String getCompany() {
		return (this.company.get());
	}

	public void setCompany(String company) {
		this.company.set(company);
	}
}