package org.company.service;

import java.util.List;

import org.company.dao.EmpDao;
import org.company.dao.EmpDaoImpl;
import org.company.entities.Emp;
import org.company.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService{
	EmpDao dao=new EmpDaoImpl();
	@Override
	public void insertEmployee(Emp e) {
		// TODO Auto-generated method stub
		dao.insert(e);
		
	}

	@Override
	public List<Emp> getEmployees() {
		// TODO Auto-generated method stub
		return dao.getEmployees();
	}

	@Override
	public Emp getEmployee(int eno) throws EmployeeNotFoundException {
		return dao.getEmployee(eno).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
	}

	@Override
	public void deleteEmployee(int eno) {
		dao.delete(eno);
		
	}

	@Override
	public void updateEmployee(int eno, Emp e) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		dao.update(eno, e);
		
	}

}
