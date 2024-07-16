import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee effectiveEmployee;
    private Employee contractorEmployee;
    private CalculateEffective calculateEffective;
    private CalculateContractor calculateContractor;
    private Employee effectiveEmployeeException;
    private Employee contractorEmployeeException;

    @BeforeEach
    void setUp() {
        effectiveEmployee = new Effective("Juan", "Perez", "aaa111", 400d, 40d, 60d);
        contractorEmployee = new Contractor("Juan", "Perez", "aaa111", 201d, 40d);
        calculateEffective = new CalculateEffective();
        calculateContractor = new CalculateContractor();

        effectiveEmployeeException = new Effective("Juan", "Perez", "123456", 1000.0, 2000.0, 50.0);
        contractorEmployeeException = new Contractor("Pompilia", "Pompini", "654321", -10.0, 100.0);

    }

    @Test
    @DisplayName("Ok calculate Effective")
    void testCalculateEffectiveOk() {
        //arrange
        String expectedResponse = "La liquidación generada es: un documento impreso. Saldo a liquidar: 420.0";

        //act
        String testResponse = calculateEffective.calculateTotalSalary(effectiveEmployee);

        //assert
        assertEquals(expectedResponse, testResponse);
    }

    @Test
    @DisplayName("Error when print")
    void testCalculateEffectiveErrorPrint() {
        //arrange
        String expectedResponse = "La liquidación generada es: un documento digital. Saldo a liquidar: 420.0";

        //act
        String testResponse = calculateEffective.calculateTotalSalary(effectiveEmployee);

        //assert
        assertNotEquals(expectedResponse, testResponse);
    }

    @Test
    @DisplayName("Error when select an employee")
    void testCalculateEffectiveErrorEmployee() {
        //arrange
        String expectedResponse = "La liquidación generada es: un documento impreso. Saldo a liquidar: 420.0";

        //act
        String testResponse = calculateContractor.calculateTotalSalary(effectiveEmployee);

        //assert
        assertNotEquals(expectedResponse, testResponse);
    }

    @Test
    @DisplayName("Error when print")
    void testCalculateContractorErrorPrint() {
        //arrange
        String expectedResponse = "La liquidación generada es: un documento impreso. Saldo a liquidar: 8040.0";

        //act
        String testResponse = calculateContractor.calculateTotalSalary(contractorEmployee);

        //assert
        assertNotEquals(expectedResponse, testResponse);
    }

    @Test
    @DisplayName("Ok calculate Contractor")
    void testCalculateContractor() {
        //arrange
        String expectedResponse = "La liquidación generada es: un documento digital. Saldo a liquidar: 8040.0";

        //act
        String testResponse = calculateContractor.calculateTotalSalary(contractorEmployee);

        //assert
        assertNotEquals(expectedResponse, testResponse);
    }

    @Test
    @DisplayName("Throw exception when calculating salary for Effective Employee")
    void testCalculateSalaryErrorEffective() {
        // Act & Assert
        assertThrows(ClassCastException.class, () -> {
            calculateEffective.calculateTotalSalary(effectiveEmployeeException);
        });
    }

    @Test
    @DisplayName("Throw exception when calculating salary for Contractor Employee")
    void testCalculateSalaryErrorContractor() {
        // Act & Assert
        assertThrows(ClassCastException.class, () -> {
            calculateContractor.calculateTotalSalary(contractorEmployeeException);
        });
    }
}