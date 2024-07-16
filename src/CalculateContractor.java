public class CalculateContractor extends Calculate {
    Double response = 0d;

    public CalculateContractor() {
        super("Error en el cálculo del salario del empleado contratado");
    }

    @Override
    protected Double calculateSalary(Employee employee) {
        //valido si el empleado que recibo por parametro es una instancia de Empleado contratado
        if (employee instanceof Contractor contractor) {
            //para calcular sueldo empleado contratado: hs x valor hora
            response = contractor.getHoursWorked() * contractor.getRate();
        }
        return response;
    }

    @Override
    protected String sendPaycheck(Employee employee) {
        return "un documento digital";
    }

}
