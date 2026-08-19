package com.employee.ems.dto;

import com.employee.ems.model.EmployeeStatus;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponseDTO {

    private Long id;

    private String employeeCode;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private BigDecimal salary;

    private String designation;

    private LocalDate joiningDate;

    private EmployeeStatus status;

}
