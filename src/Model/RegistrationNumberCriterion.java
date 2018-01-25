package Model;

public class RegistrationNumberCriterion implements Criterion<Car> {
   private String registrationNumber;
    public RegistrationNumberCriterion(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }
    @Override
    public boolean isSatisfiedBy(Car c) { return c.getRegistrationNumber().equals(this.registrationNumber);}

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
