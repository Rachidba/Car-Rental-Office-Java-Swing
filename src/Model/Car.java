package Model;


/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:20 PM
 */
public class Car {

	private String brand;
	private String model;
	private String registrationNumber;
	private double price;

	public double getPrice() {
		return price;
	}

	public Car(String rn, String model, String brand, double price){
		this.brand = brand;
		this.model = model;
		this.registrationNumber = rn;
		this.price = price;
	}

	public void finalize() throws Throwable {

	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}
}