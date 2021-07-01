package com.excercise.manager.Repository;

import com.excercise.manager.Entity.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends CrudRepository<Employee, Long>{
    
}
