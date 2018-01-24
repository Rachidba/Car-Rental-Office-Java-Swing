package Model;


/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:22 PM
 */
public class Client {

	private String CIN;
	private String firstName;
	private String lastName;

	public Client(String cin, String firstName, String lastName){
		this.CIN = cin;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getCIN() {
		return CIN;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void finalize() throws Throwable {

	}

}