package application;

public class contact {
	private String firstName;
	private String lastName;
	
	private String email;
	public contact(String n1, String n2) {
		this.firstName=n1;
		this.lastName=n2;
	}
	public contact(String n1, String n2, String e) {
		this.firstName=n1;
		this.lastName=n2;
		this.email=e;
	}
	
	public String getFirstName() {
		return(this.firstName);
	}
    public void setFirstName(String n) {
        this.firstName = n;
    }
	public String getlastName() {
		return(this.lastName);
	}
    public void setLastName(String n) {
        this.lastName = n;
    }
	public String getEmail() {
		return(this.email);
	}
	public void setEmail(String e) {
		this.email = e;
	}
}
