package Model;


import java.util.Vector;

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
