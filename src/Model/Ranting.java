package Model;


/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:23 PM
 */
public class Ranting {

	private Car car;
	private Client client;
	private boolean isReturned;
	private String rentalDate;
	private String returnDate;

	public Ranting(Car car, Client client, boolean isReturned, String rentalDate, String returnDate){
		this.car = car;
		this.client = client;
		this.isReturned = isReturned;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;

	}

	public Car getCar() {
		return car;
	}

	public Client getClient() {
		return client;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public String getRentalDate() {
		return rentalDate;
	}

	public String getReturnDate() {
		return returnDate;
	}


	public void finalize() throws Throwable {

	}

}