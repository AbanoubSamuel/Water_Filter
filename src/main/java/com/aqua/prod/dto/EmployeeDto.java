package com.aqua.prod.dto;

import com.aqua.prod.deserializer.GenderDeserializer;
import com.aqua.prod.entity.Employee;
import com.aqua.prod.entity.Gender;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.aqua.prod.entity.Employee}
 */
@Value
public class EmployeeDto implements Serializable {

    @NotNull
    @Size(max = 200)
    String name;
    @NotNull
    @Size(max = 100)
    String nationalNb;
    @NotNull
    @JsonDeserialize(using = GenderDeserializer.class)
    Gender gender;
    @Size(max = 1000)
    String address;
    @NotNull
    LocalDate hiringDate;
    @Size(max = 1000)
    String remarks;

    public static Employee convertDtoToEmployee(EmployeeDto employeeDto, Employee employee)
    {
        employee.setName(employeeDto.getName());
        employee.setNationalNb(employeeDto.getNationalNb());
        Gender gender = new Gender();
        gender.setId(employee.getId());
        employee.setGender(gender);
        employee.setAddress(employeeDto.getAddress());
        employee.setHiringDate(employeeDto.getHiringDate());
        employee.setRemarks(employeeDto.getRemarks());
        return employee;
    }
}