package com.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Integer id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_head")
    private String departmentHead;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private List<Employee> employees;


}
