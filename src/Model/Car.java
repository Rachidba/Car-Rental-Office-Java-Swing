package Model;

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