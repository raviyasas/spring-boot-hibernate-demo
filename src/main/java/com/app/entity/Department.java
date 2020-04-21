package com.app.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_head")
    private String departmentHead;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private List<Employee> employees;

}
