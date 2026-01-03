package com.ankit.emsBackEnd.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

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
}
