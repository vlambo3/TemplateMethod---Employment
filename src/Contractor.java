public class Contractor extends Employee {

    private Double hoursWorked;
    private Double rate;

    public Contractor(String name, String lastname, String accountNumber, Double hoursWorked, Double rate) {
        super(name, lastname, accountNumber);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    public Contractor() {
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}
