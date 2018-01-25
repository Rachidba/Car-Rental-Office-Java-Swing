package Model;

public class CINCriterion implements Criterion<Client> {
    private String CIN;
    public CINCriterion(String CIN){ this.CIN = CIN;}

    @Override
    public boolean isSatisfiedBy(Client c) {
        return c.getCIN().equals(this.CIN);
    }

    public String getCIN() {
        return CIN;
    }
}
