public abstract class Employee {

    private String name;
    private String lastname;
    private String accountNumber;

    public Employee(String name, String lastname, String accountNumber) {
        this.name = name;
        this.lastname = lastname;
        this.accountNumber = accountNumber;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}