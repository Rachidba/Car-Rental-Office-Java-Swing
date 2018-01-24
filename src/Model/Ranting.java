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
	private java.sql.Date rentalDate;
	private java.sql.Date returnDate;

	public Ranting(Car car, Client client, boolean isReturned, java.sql.Date rentalDate, java.sql.Date returnDate){
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

	public java.sql.Date getRentalDate() {
		return rentalDate;
	}

	public java.sql.Date getReturnDate() {
		return returnDate;
	}


	public void finalize() throws Throwable {

	}

}