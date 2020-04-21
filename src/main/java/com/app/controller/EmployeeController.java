package com.app.controller;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Integer id) {
        return employeeService.findEmployee(id);

    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        Map<String, Object> response = new HashMap<>();

        if (employee != null) {
            employeeService.saveEmplyee(employee);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        try {
            if (employeeService.findEmployee(id).isPresent()) {
                employeeService.updateEmployee(employeeDTO);
            }
        } catch (Exception e) {
            response.put("Status", "Error");
            response.put("Message", "Error");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/remove/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        if (id != null) {
            employeeService.removeEmployee(id);
        }
    }

    @GetMapping("/getByDepartment/{id}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Integer id) {
        return employeeService.findEmployeeByDepartment(id);
    }

}
