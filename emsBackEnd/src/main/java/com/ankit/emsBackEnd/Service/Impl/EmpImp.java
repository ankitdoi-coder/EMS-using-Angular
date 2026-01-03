package com.ankit.emsBackEnd.Service.Impl;
import com.ankit.emsBackEnd.Entity.Employee;
import com.ankit.emsBackEnd.DAO.EmployeeDao;
import com.ankit.emsBackEnd.Service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
}
