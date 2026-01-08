package com.ankit.emsBackEnd.Service;
import java.util.List;
import java.util.Map;

import com.ankit.emsBackEnd.Entity.Employee;

public interface  EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmp();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    Map<String, Object> getAllEmpPaginated(int page, int size);
}
