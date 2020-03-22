package com.app.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "emp_first_name")
    private String firstName;

    @Column(name = "emp_last_name")
    private String lastName;

    @Column(name = "emp_email")
    private String email;

    @Column(name = "emp_mobile_number")
    private String mobileNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_department_id", updatable = false)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "employee_roles", joinColumns = {@JoinColumn(name = "employee_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @JsonManagedReference
    private List<Role> roles;

}
