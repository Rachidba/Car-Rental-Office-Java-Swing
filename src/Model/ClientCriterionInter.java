package Model;

import java.util.Vector;

public class ClientCriterionInter {

    private Vector<Criterion<Client>> criterions;
    public ClientCriterionInter(){
        this.criterions = new  Vector<Criterion<Client>>();
    }
    public void addCriterion(Criterion<Client> c){
        this.criterions.add(c);
    }
    public Vector<Criterion<Client>> getCriterions() {
        return criterions;
    }
}
