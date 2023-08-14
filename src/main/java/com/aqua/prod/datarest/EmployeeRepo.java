package com.aqua.prod.datarest;

import com.aqua.prod.common.GenericRepo;
import com.aqua.prod.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends GenericRepo<Employee, Long> {

}