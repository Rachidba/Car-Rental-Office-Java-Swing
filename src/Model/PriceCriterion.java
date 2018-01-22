package Model;


/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:30 PM
 */
public class PriceCriterion implements Criterion {
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
}