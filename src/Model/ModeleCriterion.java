package Model;


/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:29 PM
 */
public class ModeleCriterion implements Criterion<Car> {
	private String model;

	public ModeleCriterion(String model){
		this.model = model;
	}

	public void finalize() throws Throwable {

	}

	@Override
	public boolean isSatisfiedBy(Car c) {
		return c.getModel().equals(this.model);
	}

	public String getModel() {
		return model;
	}
}