package com.ankit.emsBackEnd.DAO;

import com.ankit.emsBackEnd.Entity.Employee;
import java.util.List;

public interface EmployeeDao {
    Employee save(Employee employee);
    
    Employee getById(Long id);

    List<Employee> getAll();

    void delete(Long id);
}