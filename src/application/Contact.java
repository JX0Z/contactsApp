package application;

public class Contact {
	private simpleStringProperty firstName;
	private SimpleStringProperty middleName;
	private SimpleStringProperty lastName;
	
	private SimpleStringProperty company;
	
	private SimpleStringProperty email;
	
	public contact(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}
	public contact(String firstName, String lastName, String email) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty(email);
	}
	
	public contact(String firstName, String lastName, String email) {
		this.firstName = new SimpleStringProperty(firstName);
		this.middleName = new SimpleStringProperty(middleName);
		this.lastName = new SimpleStringProperty(lastName);
		this.company = new SimpleStringProperty(company);
		this.email = new SimpleStringProperty(email);
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
