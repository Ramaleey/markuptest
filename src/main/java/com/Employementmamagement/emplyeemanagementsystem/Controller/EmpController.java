package com.Employementmamagement.emplyeemanagementsystem.Controller;


import Model.Employee;
import com.Employementmamagement.emplyeemanagementsystem.Exception.ResourceNotFoundException;
import com.Employementmamagement.emplyeemanagementsystem.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")

public class EmpController {
    @Autowired
    private EmpRepository empRepository;
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return empRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return empRepository.save(employee);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Exist with Id :" + id));
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
        Employee employee = empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Exist With Id :" + id));

        empRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
