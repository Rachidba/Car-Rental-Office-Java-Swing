package Model;

import java.util.Vector;

public class CarCriterionInter {

    private Vector<Criterion<Car>> criterions;
    public CarCriterionInter(){
        this.criterions = new  Vector<Criterion<Car>>();
    }
    public void addCriterion(Criterion<Car> c){
        this.criterions.add(c);
    }
    public Vector<Criterion<Car>> getCriterions() {
        return criterions;
    }
}
