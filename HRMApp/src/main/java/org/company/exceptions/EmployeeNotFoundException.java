package org.company.exceptions;

public class EmployeeNotFoundException extends Exception
{
	public EmployeeNotFoundException(String desc)
	{
		super(desc);
	}
}
