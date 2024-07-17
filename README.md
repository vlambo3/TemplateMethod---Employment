## Explanation of the Program in the Template Method Branch
In the `template-method` branch, we have implemented the Template Method design pattern to simplify and better structure the salary liquidation process. This pattern allows us to define the skeleton of an algorithm in a base class and delegate the implementation of specific steps to subclasses, promoting code reuse and extensibility.

### 1. Calculate the Corresponding Salary:
- For permanent employees, the salary is calculated based on a basic salary, with applicable discounts and bonuses.
- For contract employees, the salary is calculated based on the number of hours worked and the specific hourly rate.

### 2. Print or Generate Salary Receipts:
- Permanent employees receive a printed salary receipt.
- Contract employees receive a digital salary receipt.

### 3. Deposit the Corresponding Amount:
- Regardless of the employee type, the calculated salary is deposited into the employee's bank account.

In summary, the process we perform is called `calculateTotalSalary()`, which includes the steps of calculation, printing, and depositing the salary. Each employee has a name, surname, and a bank account number used for salary deposits. Permanent employees have additional information such as basic salary, discounts, and bonuses, while contract employees have the number of hours worked and the hourly rate.

### UML Diagram

![UMLDiagram](https://raw.githubusercontent.com/vlambo3/TemplateMethod---Employment/template-method/images/UMLDiagram.png)

