package com.aqua.prod.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserEmployeeDto {
    private RegisterDto user;
    private EmployeeDto employee;
}
