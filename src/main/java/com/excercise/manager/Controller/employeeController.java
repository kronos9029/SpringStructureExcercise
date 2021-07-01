package com.excercise.manager.Controller;

import java.util.List;
import java.util.Map;

import com.excercise.manager.Entity.Employee;
import com.excercise.manager.Service.employeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class employeeController {
    private final employeeService employeeService;

    @Autowired
    public employeeController(com.excercise.manager.Service.employeeService employeeService) {
        this.employeeService = employeeService;
    }

        //Get All Product
        @GetMapping("/employees")
        public List<Employee> getAllEmployees(){
            return (List<Employee>) employeeService.getAllEmp();
        }
    
        //Get Product By ID
        @GetMapping("/employees/{id}")
        public ResponseEntity<Employee> getEmpById(@PathVariable(value = "id") Long id) {
            return employeeService.getEmpById(id);
        }
    
        //Save Product
        @PostMapping("/employees")
        public Employee createProduct(@RequestBody Employee newEmp){
            return employeeService.createEmployee(newEmp);
        }
    
        //Update Product
        @PutMapping("/employees/{id}")
        public ResponseEntity<Employee> updateEmployee(@RequestBody Employee empDetail, @PathVariable(value = "id") Long id){
            return employeeService.updateEmployee(empDetail, id);
        }
        
        //Delete Product
        @DeleteMapping("/employees/{id}")
        public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id){
            return employeeService.deleteEmployee(id);
        }

    
}
