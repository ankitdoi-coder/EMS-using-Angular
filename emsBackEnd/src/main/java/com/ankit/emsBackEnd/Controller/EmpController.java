package com.ankit.emsBackEnd.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.emsBackEnd.Entity.Employee;
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

    @GetMapping("/get-all-paginated")
    public ResponseEntity<Map<String, Object>> getAllEmpPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){
        Map<String, Object> response = empService.getAllEmpPaginated(page, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = empService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/save-emp")
    public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee){
        Employee savedEmployee = empService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/update-emp/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee updatedEmployee = empService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete-emp/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable Long id){
        empService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
