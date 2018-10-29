package com.cg.emss.service;

import java.util.HashSet;

import com.cg.emss.dto.Employee;
import com.cg.emss.exception.EmployeeException;

public interface EmployeeService {
	public int addEmployee(Employee ee)throws EmployeeException;
	public HashSet<Employee> fetchallEmp();
	public Employee getEmpId(int empId);
	public HashSet<Employee> searchEmpByName(String name);
	public int deleteEmp(int empId);
	public Employee updateEmp(int empId,String newName, float newSal);
	public boolean validateDigit(int num)throws EmployeeException;
	public boolean validateName(String name)throws EmployeeException;
	boolean validateDigit(String num) throws EmployeeException;
}
