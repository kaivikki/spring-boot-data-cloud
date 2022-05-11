package com.kaivikki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kaivikki.entities.componentmapping.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
