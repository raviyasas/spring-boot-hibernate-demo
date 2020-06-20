package com.app;

import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.entity.EmployeeProfile;
import com.app.entity.Role;
import com.app.repository.DepartmentRepository;
import com.app.repository.EmployeeProfileRepository;
import com.app.repository.EmployeeRepository;
import com.app.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDB(EmployeeRepository employeeRepository,
                                    DepartmentRepository departmentRepository,
                                    RoleRepository roleRepository,
                                    EmployeeProfileRepository employeeProfileRepository){

        return args -> {
//            Role roleAdmin = new Role();
//            roleAdmin.setRoleName("ADMIN");
//            roleRepository.save(roleAdmin);
//
//            Role roleUser = new Role();
//            roleUser.setRoleName("USER");
//            roleRepository.save(roleUser);
//
//            Set<Role> adminRole = new HashSet<>();
//            adminRole.add(roleAdmin);
//            adminRole.add(roleUser);
//
//            Set<Role> userRole = new HashSet<>();
//            userRole.add(roleUser);

            Department departmentHR = new Department();
            departmentHR.setDepartmentName("HR");
            departmentHR.setDepartmentHead("Ann");
            departmentRepository.save(departmentHR);

            Department departmentAcc = new Department();
            departmentAcc.setDepartmentName("ACCOUNT");
            departmentAcc.setDepartmentHead("Lisa");
            departmentRepository.save(departmentAcc);

            Employee employee = new Employee();
            employee.setFirstName("John");
            employee.setLastName("Lin");
            employee.setEmail("john@live.com");
            employee.setMobileNumber("019201821");
            employee.setDepartment(departmentHR);
//            employee.setRoles(adminRole);

            Employee employee2 = new Employee();
            employee2.setFirstName("BBB");
            employee2.setLastName("XXX");
            employee2.setEmail("XXX@live.com");
            employee2.setMobileNumber("23232323");
            employee2.setDepartment(departmentHR);
//            employee2.setRoles(adminRole);

            Employee employee3 = new Employee();
            employee3.setFirstName("CCC");
            employee3.setLastName("FFF");
            employee3.setEmail("iii@live.com");
            employee3.setMobileNumber("22222222");
            employee3.setDepartment(departmentAcc);
//            employee2.setRoles(userRole);

            employeeRepository.save(employee);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);

            EmployeeProfile profile1 = new EmployeeProfile();
            profile1.setProfileName("Pro1");
            profile1.setEmployee(employee);
            employeeProfileRepository.save(profile1);

            EmployeeProfile profile2 = new EmployeeProfile();
            profile2.setProfileName("Pro2");
            profile2.setEmployee(employee3);
            employeeProfileRepository.save(profile2);
        };
    }
}
