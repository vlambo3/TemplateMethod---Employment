public class Employee {

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

    //inner class
    static class Effective extends Employee {
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

    static class Contractor extends Employee {
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

    static class Calculate extends RuntimeException {

        public Calculate(String message) {
            super(message);
        }

        String calculateTotalSalary(Employee employee) {

            String response = "La liquidación no pudo ser calculada";

            Double sueldo = calculateSalary(employee);

            if (sueldo < 0) {
                throw new ClassCastException("La liquidación no pudo ser calculada");
            }

            //emitimos recibo porque el sueldo es mayor a 0
            String paycheck = sendPaycheck(employee);

            //pisamos la respuesta con un nuevo String
            response = "La liquidación generada es: " + paycheck + " Saldo a liquidar: " + sueldo;

            //deposito solo porque lo pide el enunciado
            String payment = depositarSueldo(employee);

            return response;
        }


        //1 calcular sueldo
        Double calculateSalary(Employee employee) {
            return 0d;
        };

        //2 imprimir recibo
        String sendPaycheck(Employee employee) {
            return "string return";
        }

        //3 depositarlo
        private String depositarSueldo(Employee employee) {
            return "Se depositó a la cuenta de: " + employee.getAccountNumber();
        }

        static class CalculateEffective extends Calculate {

            Double response = 0d;

            public CalculateEffective() {
                super("La liquidación no pudo ser calculada");
            }

            protected Double calculateSalary(Employee employee) {
                if (employee instanceof Effective effective) {
                    response = effective.getBasicSalary() + effective.getBonus() - effective.getDiscounts();
                }
                return response;
            }

            protected String sendPaycheck(Employee employee) {
                return "un documento impreso.";
            }
        }

        static class CalculateContractor extends Calculate {

            Double response = 0d;

            public CalculateContractor() {
                super("Error en el cálculo del salario del empleado contratado");
            }

            protected Double calculateSalary(Employee employee) {
                if (employee instanceof Contractor contractor) {
                    response = contractor.getHoursWorked() * contractor.getRate();
                }
                return response;
            }

            protected String sendPaycheck(Employee employee) {
                return "un documento impreso";
            }
        }
    }


//    public static void main(String[] args) {
//        System.out.println("Work Phil!");

//        var e = Employee.effectiveEmployee("Juan",
//                "Perez",
//                "aaa123",
//                100d,
//                10d,
//                60d);
//
//        System.out.println(e.employee().getName());

//    }


}
