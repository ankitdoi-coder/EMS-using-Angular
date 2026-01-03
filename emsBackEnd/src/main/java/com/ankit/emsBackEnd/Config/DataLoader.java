package com.ankit.emsBackEnd.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ankit.emsBackEnd.Entity.Employee;
import com.ankit.emsBackEnd.Service.EmployeeService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        // Add sample data if no employees exist
        if (employeeService.getAllEmp().isEmpty()) {
            Employee emp1 = new Employee(null, "John Doe", "john@example.com", 28, 50000.0, "Developer");
            Employee emp2 = new Employee(null, "Jane Smith", "jane@example.com", 32, 60000.0, "Manager");
            Employee emp3 = new Employee(null, "Mike Johnson", "mike@example.com", 25, 45000.0, "Analyst");
            
            employeeService.saveEmployee(emp1);
            employeeService.saveEmployee(emp2);
            employeeService.saveEmployee(emp3);
            
            System.out.println("Sample data loaded successfully!");
        }
    }
}