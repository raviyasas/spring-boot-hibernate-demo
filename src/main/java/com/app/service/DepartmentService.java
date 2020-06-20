package com.app.service;

import com.app.entity.Department;
import com.app.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public Optional<Department> getDepartment(Integer id) {
        return departmentRepository.findById(id);
    }
}
