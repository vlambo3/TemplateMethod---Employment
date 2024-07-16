public class Effective extends Employee {
    private Double basicSalary;
    private Double discounts;
    private Double bonus;

    public Effective(String name, String lastname, String accountNumber, Double basicSalary, Double discounts, Double bonus) {
        super(name, lastname, accountNumber);
        this.basicSalary = basicSalary;
        this.discounts = discounts;
        this.bonus = bonus;
    }

    public Effective() {
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Double discounts) {
        this.discounts = discounts;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}
