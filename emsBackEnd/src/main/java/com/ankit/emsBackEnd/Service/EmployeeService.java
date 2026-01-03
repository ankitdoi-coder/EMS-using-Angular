package com.ankit.emsBackEnd.Service;
import java.util.List;

import com.ankit.emsBackEnd.Entity.Employee;

public interface  EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmp();
}
