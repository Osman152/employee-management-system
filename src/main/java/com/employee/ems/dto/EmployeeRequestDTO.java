package com.employee.ems.dto;

import com.employee.ems.model.EmployeeStatus;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeRequestDTO {

        @NotBlank(message = " Employee code required.")
        private String employeeCode;

        @NotBlank(message = " First name is required.")
        private String firstName;

        private String lastName;

        @NotBlank(message = " Email is required.")
        @Email(message = "Invalid Email")
        private String email;

        @NotBlank(message = " Phone No is required.")
        @Pattern(
                regexp = "^03\\d{9}$",
                message = "Phone number must be in the format 03XXXXXXXXX"
        )
        private String phone;

        @NotNull(message = " Salary is required.")
        @Positive(message = "Salary must be greater than zero")
        private BigDecimal salary;

        @NotBlank(message = "Designation is required.")
        private String designation;

        @NotNull(message = "Joining date is required.")
        @PastOrPresent(message = "Joining date cannot be in the future.")

        private LocalDate joiningDate;

        @NotNull(message = "Status is required.")
        private EmployeeStatus status;

}


