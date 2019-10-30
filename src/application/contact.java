package application;

public class contact {
	private String firstName;
	private String lastName;
	
	private String email;
	public contact(String n1, String n2, String e) {
		this.firstName=n1;
		this.lastName=n2;
		this.email=e;
	}
	public String getFirstName() {
		return(this.firstName);
	}
	public String getlastName() {
		return(this.lastName);
	}
	public String getEmail() {
		return(this.email);
	}
}
