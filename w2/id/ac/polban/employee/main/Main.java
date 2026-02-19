package id.ac.polban.employee.main;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
      public static void main(String[] args) {
            Department engineering = new Department("Engineering");
            Department marketing = new Department("Marketing");

            EmploymentType fullTime = new EmploymentType("Full-Time");
            EmploymentType partTime = new EmploymentType("Part-Time");

            EmployeeService service = new EmployeeService();

            service.addEmployee(new Employee(1, "Budi Santoso", engineering, fullTime, 8000000));
            service.addEmployee(new Employee(2, "Ani Wijaya", marketing, fullTime, 7500000));
            service.addEmployee(new Employee(3, "Rudi Hartono", engineering, partTime, 4000000));

            service.raiseSalary(1, 10);

            Employee emp = service.getEmployee(1);
            System.out.println(emp.getName() + " gaji sekarang: " + emp.getSalary());
      
            System.out.println("Total Employee: " + Employee.getTotalEmployee());
      }
}