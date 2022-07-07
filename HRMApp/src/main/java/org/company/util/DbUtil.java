package org.company.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil 
{
	private static Connection createConnection(String driver,String url,String username,String password)
	{
		Connection con=null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static Connection getConnection()
	{
		Properties properties=getProperties("F:\\java_full_stack\\HRMApp\\resources\\database.properties");
		String driver="com.mysql.jdbc.Driver";
		String url=properties.getProperty("jdbc.url");
		String username=properties.getProperty("jdbc.username");
		String password=properties.getProperty("jdbc.password");
		return createConnection(driver,url,username,password);
	}
	private static Properties getProperties(String filepath)
	{
		Properties p=null;
		try
		{
			FileInputStream fis=new FileInputStream(filepath);
			p=new Properties();
			p.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return p;
	}
}
