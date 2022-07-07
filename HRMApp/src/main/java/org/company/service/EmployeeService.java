package org.company.service;

import java.util.List;

import org.company.entities.Emp;
import org.company.exceptions.EmployeeNotFoundException;

public interface EmployeeService {
	void insertEmployee(Emp e);
	List<Emp> getEmployees();
	Emp getEmployee(int eno) throws EmployeeNotFoundException;
	void deleteEmployee(int eno);
	void updateEmployee(int eno,Emp e) throws EmployeeNotFoundException;

}
