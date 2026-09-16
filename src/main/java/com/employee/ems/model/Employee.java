package com.employee.ems.model;


import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee code required.")
    @Column(name = "EMPLOYEE_CODE", nullable = false, unique = true)
    private String employeeCode;

    @NotBlank(message = "First name is required.")
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid Email")
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone No is required.")
    @Pattern(
            regexp = "^03\\d{9}$",
            message = "Phone number must be in the format 03XXXXXXXXX"
    )
    @Column(name = "PHONE", nullable = false, unique = true)
    private String phone;

    @NotNull(message = "Salary is required.")
    @Positive(message = "Salary must be greater than zero")
    @Column(name = "EMPLOYEE_SALARY", nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

    @NotBlank(message = "Designation is required.")
    @Column(name = "DESIGNATION", nullable = false)
    private String designation;

    @NotNull(message = "Joining date is required.")
    @PastOrPresent(message = "Joining date cannot be in the future.")
    @Column(name = "JOINING_DATE",  nullable = false)
    private LocalDate joiningDate;

    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private EmployeeStatus status;

}
