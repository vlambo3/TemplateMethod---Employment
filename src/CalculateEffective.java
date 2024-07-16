public class CalculateEffective extends Calculate {
    Double response = 0d;

    public CalculateEffective() {
        super("La liquidación no pudo ser calculada");
    }

    @Override
    protected Double calculateSalary(Employee employee) {
        //valido si el empleado que recibo por parametro es una instancia de Empleado efectivo
        if (employee instanceof Effective effective) {
            //para calcular sueldo empleado efectivo: hs x valor hora
            response = effective.getBasicSalary() + effective.getBonus() - effective.getDiscounts();
        }
        return response;
    }

    @Override
    protected String sendPaycheck(Employee employee) {
        return "un documento impreso.";
    }
}
