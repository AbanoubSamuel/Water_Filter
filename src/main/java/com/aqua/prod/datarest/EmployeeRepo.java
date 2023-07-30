package com.aqua.prod.datarest;

import com.aqua.prod.entity.Employee;
import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeRepo extends ListCrudRepository<Employee, Long> {

}