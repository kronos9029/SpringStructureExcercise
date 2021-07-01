package com.excercise.manager.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.excercise.manager.Entity.Employee;
import com.excercise.manager.Exception.ProductNotFoundException;
import com.excercise.manager.Repository.employeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class employeeService {
    
    private final employeeRepository employeeRepository;

    @Autowired
    public employeeService(com.excercise.manager.Repository.employeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmp(){
        return (List<Employee>) this.employeeRepository.findAll();
    }

    public ResponseEntity<Employee> getEmpById(Long id) 
            throws ProductNotFoundException{
        Employee emp = employeeRepository.findById(id)
                                        .orElseThrow(() -> new ProductNotFoundException(id));
        
        return ResponseEntity.ok().body(emp);
    }

    public Employee createEmployee(Employee newEmp){
        return this.employeeRepository.save(newEmp);
    }

    public ResponseEntity<Employee> updateEmployee(Employee empDeatail, Long id){
        Employee emp = employeeRepository.findById(id)
                                        .orElseThrow(() -> new ProductNotFoundException(id));
                
        emp.setFullName(empDeatail.getFullName());

        return ResponseEntity.ok(this.employeeRepository.save(emp));
    }

    public Map<String, Boolean> deleteEmployee(Long id){
        Employee emp = employeeRepository.findById(id)
                                        .orElseThrow(() -> new ProductNotFoundException(id));
        this.employeeRepository.delete(emp);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }
    
}
