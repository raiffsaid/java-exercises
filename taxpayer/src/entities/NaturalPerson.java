package entities;

public class NaturalPerson extends TaxPayer {

    private Double healthExpenses;

    public NaturalPerson() {
        super();
    }

    public NaturalPerson(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public double tax() {
        double basicTax = (getAnnualIncome() < 20000.0) ?
                getAnnualIncome() * 0.15 : getAnnualIncome() * 0.25;

        basicTax -= getHealthExpenses() * 0.5;

        if (basicTax < 0.0) {
            basicTax = 0.0;
        }

        return basicTax;
    }
}
