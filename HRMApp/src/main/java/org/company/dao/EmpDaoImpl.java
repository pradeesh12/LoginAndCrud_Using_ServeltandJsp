package org.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.company.entities.Emp;
import org.company.exceptions.EmployeeNotFoundException;
import org.company.util.DbUtil;

public class EmpDaoImpl implements EmpDao{

	@Override
	public void insert(Emp e) {
		Connection con=null;
		PreparedStatement pst=null;
		try
		{
			con=DbUtil.getConnection();
			pst=con.prepareStatement("insert into emp values(?,?,?)");
			pst.setInt(1, e.getEno());
			pst.setString(2,e.getName());
			pst.setString(3, e.getAddress());
			pst.executeUpdate();
			con.close();
		}catch(Exception e2)
		{
			e2.printStackTrace();
		}
		
	}

	@Override
	public List<Emp> getEmployees() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		List<Emp> employee=new ArrayList<Emp>();
		try
		{
			con=DbUtil.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from emp");
			while(rs.next())
			{
				employee.add(new Emp(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			con.close();
		}catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return employee;
	}

	@Override
	public void delete(int eno) {
		Connection con=null;
		PreparedStatement pst=null;
		try
		{
			con=DbUtil.getConnection();
			pst=con.prepareStatement("delete from emp where eno=?");
			pst.setInt(1, eno);
			pst.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(int eno, Emp e) throws EmployeeNotFoundException{
		Connection con=null;
		PreparedStatement pst=null;
		try
		{
			con=DbUtil.getConnection();
			pst=con.prepareStatement("update emp set name=? and address=? where eno=?");
			pst.setString(1, e.getName());
			pst.setString(2, e.getAddress());
			pst.setInt(3, e.getEno());
			pst.executeUpdate();
			con.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}

	@Override
	public Optional<Emp> getEmployee(int eno) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Emp e=null;
		try
		{
			con=DbUtil.getConnection();
			pst=con.prepareStatement("select * from emp where eno=?");
			pst.setInt(1, eno);
			rs=pst.executeQuery();
			rs.next();
			e=new Emp(rs.getInt(1),rs.getString(2),rs.getString(3));
			con.close();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return Optional.ofNullable(e);
		}
}
