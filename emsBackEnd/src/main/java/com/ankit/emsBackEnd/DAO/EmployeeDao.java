package com.ankit.emsBackEnd.DAO;

import com.ankit.emsBackEnd.Entity.Employee;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    Employee save(Employee employee);
    
    Employee getById(Long id);

    List<Employee> getAll();

    void delete(Long id);
    
    Map<String, Object> getAllPaginated(int page, int size);
}