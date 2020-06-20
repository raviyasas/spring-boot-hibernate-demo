package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmplyee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();

        if (employeeDTO.getFirstName() != null) {
            employee.setFirstName(employeeDTO.getFirstName());
        }
        if (employeeDTO.getLastName() != null) {
            employee.setLastName(employeeDTO.getLastName());
        }
        if (employeeDTO.getEmail() != null) {
            employee.setEmail(employeeDTO.getEmail());
        }
        if (employeeDTO.getMobileNumber() != null) {
            employee.setMobileNumber(employeeDTO.getMobileNumber());
        }

        employeeRepository.save(employee);
    }

    public void removeEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findEmployeeByDepartment(Integer id) {
        return employeeRepository.findEmployeeByDepartment_Id(id);
    }
}
