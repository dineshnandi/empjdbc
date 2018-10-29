package com.cg.emss.ui;

import java.util.HashSet;
import java.util.TreeSet;

import com.cg.emss.dto.Employee;

public class TestHashSetDemo {

	public static void main(String[] args) {
		System.out.println("***hashset***equals******");
		HashSet<Employee> emps=new HashSet<Employee>();
		emps.add(new Employee(101,"Dinesh",1000.0F));
		emps.add(new Employee(102,"Rahul",2000.0F));
		emps.add(new Employee(103,"bapan",500.0F));
		emps.add(new Employee(103,"Karan",200.0F));
		System.out.println(emps);
		
		System.out.println("***treeset***");
		TreeSet<String> cities = new TreeSet<String>();
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Mumbai");
		cities.add("Hyderabad");
		System.out.println(cities);
		
		System.out.println("***treeset***compareTo******");
		TreeSet<Employee> emp2=new TreeSet<Employee>();
		emp2.add(new Employee(101,"Dinesh",1000.0F));
		emp2.add(new Employee(102,"Rahul",2000.0F));
		emp2.add(new Employee(103,"bapan",500.0F));
		emp2.add(new Employee(103,"Karan",200.0F));
		System.out.println(emp2);
		
	}

}
