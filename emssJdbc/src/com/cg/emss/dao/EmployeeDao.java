package com.cg.emss.dao;

import java.util.HashSet;

import com.cg.emss.dto.Employee;
import com.cg.emss.exception.EmployeeException;

public interface EmployeeDao {

	public int addEmployee(Employee ee)throws EmployeeException;
	public HashSet<Employee> fetchallEmp();
	public Employee getEmpId(int empId);
	public HashSet<Employee> searchEmpByName(String name);
	public int deleteEmp(int empId);
	public Employee updateEmp(int empId,String newName, float newSal);
}
