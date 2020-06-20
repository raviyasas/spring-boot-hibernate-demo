package com.app.controller;

import com.app.entity.Department;
import com.app.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable Integer id){
        return departmentService.getDepartment(id);
    }
}
