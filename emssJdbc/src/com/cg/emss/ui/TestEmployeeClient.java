package com.cg.emss.ui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.emss.dto.Employee;
import com.cg.emss.exception.EmployeeException;
import com.cg.emss.service.EmployeeService;
import com.cg.emss.service.EmployeeServiceImp;

public class TestEmployeeClient {
static Scanner sc = null;
static EmployeeService empSer=null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		empSer=new EmployeeServiceImp();
		
		int c = 0;
		while(true){
			System.out.println(" 1.Add Emp\n 2.Fetch All Emp"
					+ "\n 3.Delete Emp\n 4.Search Emp by Id\n "
					+ "5.Search Emp by name\n 6.Update Emp\n 7.Exit\n");
			System.out.println("Enter your choice:");
			c=sc.nextInt();
			switch(c){
			case 1:
				addEmp();
				break;
			case 2:
				showEmpInfo();
				break;
			case 3:
				delEmp();
			case 4:
				searchEmployee();
				break;
			case 5:
				searchEmpName();
				break;
			case 6:
				updateemp();
				break;
			default:System.exit(0);
			}
		}

	}
	private static void updateemp(){
		System.out.println("Enter Employee ID:");
		int empId = sc.nextInt();
		String newName = sc.next();
		float newSal= sc.nextFloat();
		empSer.updateEmp(empId, newName, newSal);
		System.out.println("Sucessfully Updated!");
	}
	private static void delEmp() {
		System.out.println("Enter Employee Id to be deleted:");
		int epid=sc.nextInt();
		empSer.deleteEmp(epid);
		System.out.println("Sucessfully Deleted!");
		
	}

	private static void searchEmpName() {
		System.out.println("Enter employee name:");
		String name = sc.next();
		HashSet<Employee> has2=empSer.searchEmpByName(name);
		System.out.println(has2);
		
	}
	private static void searchEmployee() {
	
		System.out.println("Enter the employee ID:");
		int newId = sc.nextInt();
		Employee ee= empSer.getEmpId(newId);
		System.out.println(ee);
		
		
	}
	private static void showEmpInfo() {
		
		HashSet<Employee> empSet=empSer.fetchallEmp();
		Iterator<Employee> it = empSet.iterator();
		System.out.println("....................");
		System.out.println("EmpID\tEmpName\tEmpSal");
		while(it.hasNext()){
			Employee ee = it.next();
			System.out.println(ee.getEmpId()+"\t"+ee.getEmpName()+"\t"+ee.getEmpSal()+"\n");
		}
		
	}
	private static void addEmp() {
		
		System.out.println("Enter Employee ID:");
		String eid = sc.next();
		try{
			if(empSer.validateDigit(eid));{
				System.out.println("Enter Employee Name:");
				String nm= sc.next();
				if(empSer.validateName(nm)){
					System.out.println("Enter Salary");
					float sal = sc.nextFloat();
					Employee ee = new Employee(Integer.parseInt(eid),nm,sal);
					int empId = empSer.addEmployee(ee);
					System.out.println(empId+" Added Sucessful");
				}
			}
		}
		catch(EmployeeException e){
			e.printStackTrace();
			
		}
		
		
	}

}
