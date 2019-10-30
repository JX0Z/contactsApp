package application;

public class contact {
	private String firstName;
	private String lastName;
	
	private String email;
	public contact(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public contact(String firstName, String lastName, String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
	
	public String getFirstName() {
		return(this.firstName);
	}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
	public String getlastName() {
		return(this.lastName);
	}
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	public String getEmail() {
		return(this.email);
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
