import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeDA {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeDA(String empNo, Double salary) {
        try (Scanner employeeFile = new Scanner(new FileReader("emp.csv"))) {
            employeeFile.nextLine();

            while (employeeFile.hasNext()) {
                String employeeLineData = employeeFile.nextLine();
                String[] employeeLineDataSpecific = new String[3];
                employeeLineDataSpecific = employeeLineData.split(",");

                if (empNo.equals(employeeLineDataSpecific[0])) {
                    employee = new Employee();
                    employee.setEmpNo(employeeLineDataSpecific[0]);
                    employee.setLastName(employeeLineDataSpecific[1]);
                    employee.setFirstName(employeeLineDataSpecific[2]);
                    employee.setSalary(salary);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
