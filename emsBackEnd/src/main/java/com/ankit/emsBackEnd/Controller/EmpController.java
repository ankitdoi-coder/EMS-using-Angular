package com.ankit.emsBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.ankit.emsBackEnd.Entity.*;
import com.ankit.emsBackEnd.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmpController {
    @Autowired
    EmployeeService empService;
    

    @GetMapping("/get-all")
    public ResponseEntity<List<Employee>> getAllEmp(){
        List<Employee> employees=empService.getAllEmp();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/save-emp")
    public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee){
        Employee savedEmployee = empService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }
}
