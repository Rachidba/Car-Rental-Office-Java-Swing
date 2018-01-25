package Model;

public class FnameCriterion implements Criterion<Client> {
    private String Fname;

    public FnameCriterion(String Fname){
        this.Fname = Fname;
    }

    public void finalize() throws Throwable {

    }

    @Override
    public boolean isSatisfiedBy(Client c) {
        return c.getFirstName().equals(this.Fname);
    }

    public String getFname() {
        return Fname;
    }
}
