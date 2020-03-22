package com.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "employee_profile")
public class EmployeeProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_profile_id")
    private Integer id;

    @Column(name = "profile_name")
    private String profileName;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Employee employee;

}
