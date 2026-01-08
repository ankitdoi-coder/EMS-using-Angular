package com.ankit.emsBackEnd.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.emsBackEnd.Entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Employee getById(Long id) {
        return entityManager.find(Employee.class, id);
    }
    
    @Override
    public List<Employee> getAll(){
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public void delete(Long id) {
       Employee employee = entityManager.find(Employee.class, id);
       if(employee != null){
        entityManager.remove(employee);
       }
    }

    @Override
    public Map<String, Object> getAllPaginated(int page, int size) {
        // Get total count
        TypedQuery<Long> countQuery = entityManager.createQuery("SELECT COUNT(e) FROM Employee e", Long.class);
        long totalElements = countQuery.getSingleResult();
        
        // Get paginated data
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        List<Employee> employees = query.getResultList();
        
        // Create response
        Map<String, Object> response = new HashMap<>();
        response.put("employees", employees);
        response.put("totalElements", totalElements);
        response.put("totalPages", (int) Math.ceil((double) totalElements / size));
        response.put("currentPage", page);
        response.put("pageSize", size);
        
        return response;
    }
}
