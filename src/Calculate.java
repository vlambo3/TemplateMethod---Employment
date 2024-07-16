public abstract class Calculate extends RuntimeException {

    public Calculate(String message) {
        super(message);
    }

    public String calculateTotalSalary(Employee employee) {

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
    protected abstract Double calculateSalary(Employee employee);


    //2 imprimir recibo
    protected abstract String sendPaycheck(Employee employee);

    //3 depositarlo
    private String depositarSueldo(Employee employee) {
        return "Se depositó a la cuenta de: " + employee.getAccountNumber();
    }
}
