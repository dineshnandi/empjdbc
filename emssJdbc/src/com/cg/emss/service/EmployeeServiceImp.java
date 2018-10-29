package com.cg.emss.service;

import java.util.HashSet;
import java.util.regex.Pattern;

import com.cg.emss.dao.EmployeeDao;
import com.cg.emss.dao.EmployeeImp;
import com.cg.emss.dto.Employee;
import com.cg.emss.exception.EmployeeException;

public class EmployeeServiceImp implements EmployeeService {
	EmployeeDao empDao=null;
	public EmployeeServiceImp(){
		empDao = new EmployeeImp();
	}
	@Override
	public int addEmployee(Employee ee) throws EmployeeException {
		
		return empDao.addEmployee(ee);
	}

	@Override
	public HashSet<Employee> fetchallEmp() {
	
		return empDao.fetchallEmp();
	}

	@Override
	public Employee getEmpId(int empId) {
		
		return empDao.getEmpId(empId);
	}

	@Override
	public HashSet<Employee> searchEmpByName(String name) {
		// TODO Auto-generated method stub
		return empDao.searchEmpByName(name);
	}

	@Override
	public int deleteEmp(int empId) {
		// TODO Auto-generated method stub
		return empDao.deleteEmp(empId);
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {
		return empDao.updateEmp(empId, newName, newSal);
	}

	@Override
	public boolean validateDigit(String num) throws EmployeeException {
		
		String digitPattern = "[0-9]+";
		if(Pattern.matches(digitPattern, num)){
			return true;
		}
		else{
			throw new EmployeeException("Invalid input!! only digits are allowed eg.98832");
		}
		
	}

	@Override
	public boolean validateName(String name) throws EmployeeException {
		String namePattern = "[A-Z][a-z]+";
		if(Pattern.matches(namePattern, name)){
			return true;
		}
		else{
			throw new EmployeeException("Invalid Name!! Only characters are allowed eg.Dinesh");
		}
		
	}
	@Override
	public boolean validateDigit(int num) throws EmployeeException {
		// TODO Auto-generated method stub
		return false;
	}

}
