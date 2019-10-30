package application;

public class contact {
	private simpleStringProperty firstName;
	private SimpleStringProperty middleName;
	private SimpleStringProperty lastName;
	
	private SimpleStringProperty company;
	
	private SimpleStringProperty email;
	
	public contact(SimpleStringProperty firstName, SimpleStringProperty lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public contact(SimpleStringProperty firstName, SimpleStringProperty lastName, SimpleStringProperty email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
	
	public SimpleStringProperty getFirstName() {
		return(this.firstName);
	}
    	public void setFirstName(SimpleStringProperty firstName) {
        	this.firstName = firstName;
   	}
	public SimpleStringProperty getlastName() {
		return(this.lastName);
	}
 	public void setLastName(SimpleStringProperty lastName) {
        	this.lastName = lastName;
	}
	public SimpleStringProperty getMiddleName() {
		return(this.middleName);
	}
 	public void setMiddleName(SimpleStringProperty middleName) {
        	this.middleName = middleName;
	}
	public SimpleStringProperty getEmail() {
		return(this.email);
	}
	public void setEmail(SimpleStringProperty email) {
		this.email = email;
	}
	public SimpleStringProperty getCompany() {
		return(this.company);
	}
	public void setCompany(SimpleStringProperty company) {
		this.company = company;
	}
}
