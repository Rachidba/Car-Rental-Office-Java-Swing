package Model;

public class LnameCriterion implements Criterion<Client> {
    private String Lname;

    public LnameCriterion(String Lname){
        this.Lname = Lname;
    }

    public void finalize() throws Throwable {

    }

    @Override
    public boolean isSatisfiedBy(Client c) {  return c.getLastName().equals(this.Lname); }

    public String getLname() {
        return Lname;
    }
}
