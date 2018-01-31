package Model;


public class PriceCriterion implements Criterion<Car> {
	private double price;

	public PriceCriterion(double price){
		this.price = price;
	}

	public void finalize() throws Throwable {

	}

	@Override
	public boolean isSatisfiedBy(Car c) {
		return c.getPrice() <= this.price;
	}

	public double getPrice() {
		return price;
	}
}