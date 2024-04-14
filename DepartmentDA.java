import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA {

    private HashMap<String, Employee> employeeMap;

    public HashMap<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public DepartmentDA() {
        try (Scanner departmentFile = new Scanner(new FileReader("dep.csv"))) {
            employeeMap = new HashMap<>();
            departmentFile.nextLine();

            while (departmentFile.hasNext()) {
                String[] departmentLineData = departmentFile.nextLine().split(",");

                Department department = new Department();
                department.setDepCode(departmentLineData[0].trim());
                department.setDepName(departmentLineData[1].trim());

                readDepEmp(department);
                department.setEmployeeMap(employeeMap);

                Double salary = 0.00;
                for (Map.Entry<String, Employee> entryMap : department.getEmployeeMap().entrySet()) {
                    salary += entryMap.getValue().getSalary();
                }
                department.setDepTotalSalary(salary);

                printDepartment(department);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void readDepEmp(Department department) {
        try (Scanner deptEmpFile = new Scanner(new FileReader("deptemp.csv"))) {
            employeeMap.clear();
            deptEmpFile.nextLine();

            Integer key = 0;
            while (deptEmpFile.hasNext()) {
                String deptEmpRow = deptEmpFile.nextLine();
                String[] departmentLineDataSpecific = deptEmpRow.split(",");

                if (department.getDepCode().equals(departmentLineDataSpecific[0])) {
                    EmployeeDA employeeDA = new EmployeeDA(departmentLineDataSpecific[1].trim(), Double.parseDouble(departmentLineDataSpecific[2].trim()));
                    employeeMap.put(departmentLineDataSpecific[1].trim() + key, employeeDA.getEmployee());
                    key++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void printDepartment(Department department) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        System.out.println("Department code: " + department.getDepCode());
        System.out.println("Department name: " + department.getDepName());
        System.out.println("Department total salary: " + df.format(department.getDepTotalSalary()));
        System.out.println("---------------------Details-------------------------");
        System.out.println("EmpNo\t\tEmployee Name\t\tSalary");

        for (Map.Entry<String, Employee> entryMap : department.getEmployeeMap().entrySet()) {
            Employee employee = entryMap.getValue();
            String employeeName = employee.getLastName() + "," + employee.getFirstName();

            System.out.printf("%-8s%-24s%-2s%n", employee.getEmpNo(), employeeName, df.format(employee.getSalary()));
        }
        System.out.println();
    }
}
