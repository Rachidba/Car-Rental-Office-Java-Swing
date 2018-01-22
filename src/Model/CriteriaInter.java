package Model;


import java.util.Vector;

/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:26 PM
 */
public class CriteriaInter implements Criterion {

	private Vector<Criterion> criterions;

	public CriteriaInter(){
		this.criterions = new Vector<>();
	}

	public void addCriterion(Criterion criterion) {
		this.criterions.add(criterion);
	}

	@Override
	public boolean isSatisfiedBy(Car c) {
		for(Criterion elem:criterions) {
			if (!elem.isSatisfiedBy(c)) return false;
		}
		return true;
	}

	public void finalize() throws Throwable {

	}
}
