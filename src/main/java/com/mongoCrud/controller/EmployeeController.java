package com.mongoCrud.controller;

import com.mongoCrud.model.Employee;
import com.mongoCrud.repository.EmployeeRepository;
import com.mongoCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/get")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> saveOrUpdate(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(employeeService.saveorUpdate(emp), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public Employee createEmployees(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployees(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
