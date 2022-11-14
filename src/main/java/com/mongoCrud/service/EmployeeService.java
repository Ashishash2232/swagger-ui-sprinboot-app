package com.mongoCrud.service;

import com.mongoCrud.model.Employee;
import com.mongoCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveorUpdate(Employee emp) {
        return employeeRepository.save(emp);
    }
}
