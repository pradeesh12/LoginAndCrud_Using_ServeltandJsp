package org.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.company.entities.User;
import org.company.util.DbUtil;

public class UserDao {
	public boolean validateUser(User user)
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean isValidUser=false;
		try
		{
			con=DbUtil.getConnection();
			pst=con.prepareStatement("select * from user where username=? and password=?");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				isValidUser=true;
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		return isValidUser;
	}

}
