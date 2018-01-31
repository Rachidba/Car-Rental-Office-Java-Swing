package Model;

public class Ranting {

	private int rantID;
	private Car car;
	private Client client;
	private boolean isReturned;
	private java.sql.Date rentalDate;
	private java.sql.Date returnDate;

	public Ranting(int rantID, Car car, Client client, boolean isReturned, java.sql.Date rentalDate, java.sql.Date returnDate){
		this.rantID = rantID;
		this.car = car;
		this.client = client;
		this.isReturned = isReturned;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}
	public Ranting(Car car, Client client, boolean isReturned, java.sql.Date rentalDate, java.sql.Date returnDate){
		//this.rantID = rantID;
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

	public int getRantID() {return rantID;}


	public void finalize() throws Throwable {

	}

}