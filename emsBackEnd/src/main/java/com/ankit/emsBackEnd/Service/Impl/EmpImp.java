package com.ankit.emsBackEnd.Service.Impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.emsBackEnd.DAO.EmployeeDao;
import com.ankit.emsBackEnd.Entity.Employee;
import com.ankit.emsBackEnd.Service.EmployeeService;

@Service
public class EmpImp implements EmployeeService {

    @Autowired
    EmployeeDao empDao;

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee=empDao.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getAllEmp() {
        return empDao.getAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return empDao.getById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = empDao.getById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPosition(employee.getPosition());
            return empDao.save(existingEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        empDao.delete(id);
    }

    @Override
    public Map<String, Object> getAllEmpPaginated(int page, int size) {
        return empDao.getAllPaginated(page, size);
    }
    
}
