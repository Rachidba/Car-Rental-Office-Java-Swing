package Model;


/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:27 PM
 */
public class BrandCriterion implements Criterion<Car> {

	private String brand;

	public BrandCriterion(String brand){
		this.brand = brand;
	}

	public void finalize() throws Throwable {

	}

	@Override
	public boolean isSatisfiedBy(Car c) {
		return c.getBrand().equals(this.brand);
	}

	public String getBrand() {
		return brand;
	}
}