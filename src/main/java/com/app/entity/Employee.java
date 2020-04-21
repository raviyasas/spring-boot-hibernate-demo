package com.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "employee")

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "emp_first_name")
    private String firstName;

    @Column(name = "emp_last_name")
    private String lastName;

    @Column(name = "emp_email", nullable = false, unique = true)
    @NaturalId
    private String email;

    @Column(name = "emp_mobile_number")
    private String mobileNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Department department;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmployeeProfile employeeProfile;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "employee_role", joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "emp_id", nullable = false, updatable = false)},
                                       inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Role> roles = new HashSet<>();



}
