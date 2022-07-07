package org.company.dao;

import java.util.List;
import java.util.Optional;

import org.company.entities.Emp;
import org.company.exceptions.EmployeeNotFoundException;

public interface EmpDao {
	void insert(Emp e);
	List<Emp> getEmployees();
	void delete(int eno);
	void update(int eno,Emp e) throws EmployeeNotFoundException;
	Optional<Emp> getEmployee(int eno);
	
}
