package entities;

public class LegalPerson extends TaxPayer {

    private Integer numberOfEmployees;

    public LegalPerson() {
        super();
    }

    public LegalPerson(String name, Double annualIncome, Integer employeesNumber) {
        super(name, annualIncome);
        numberOfEmployees = employeesNumber;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer employeesNumber) {
        numberOfEmployees = employeesNumber;
    }

    @Override
    public double tax() {
        return (numberOfEmployees > 10) ?
                getAnnualIncome() * 0.14 : getAnnualIncome() * 0.16;
    }
}
