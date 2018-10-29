package com.cg.emss.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;



import com.cg.emss.dto.Employee;
import com.cg.emss.exception.EmployeeException;
import com.cg.emss.util.DBUtil;

public class EmployeeImp implements EmployeeDao {

	Connection con=null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	@Override
	public int addEmployee(Employee ee) throws EmployeeException 
	{
		try
		{
		con=DBUtil.getCon();
		pst=con.prepareStatement(QueryMapper.INSERTQRY3);
		pst.setInt(1, ee.getEmpId());
		pst.setString(2, ee.getEmpName());
		pst.setFloat(3, ee.getEmpSal());
		int data=pst.executeUpdate();
		if(data==1){
			return ee.getEmpId();
		}
		else{
			return 0;
		}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		finally{
			
		}
		
	}
	@Override
	public HashSet<Employee> fetchallEmp() 
	{
		HashSet<Employee> empSet = new HashSet<Employee>();
		try {
			con=DBUtil.getCon();
			st=con.createStatement();
			rs=st.executeQuery(QueryMapper.SELECTQRY);
			while(rs.next()){
				int eid = rs.getInt("emp_id");
				String enm = rs.getString("emp_name");
				float sl = rs.getFloat("emp_sal");
				empSet.add(new Employee(eid,enm,sl));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return empSet;
	}

	@Override
	public Employee getEmpId(int empId) {
		return null;
		
		
	}

	@Override
	public HashSet<Employee> searchEmpByName(String name) {

	
		return null;
	}

	@Override
	public int deleteEmp(int empId) {
		int flag=0;
		
		try {
			con=DBUtil.getCon();
			st=con.createStatement();
			rs=st.executeQuery(QueryMapper.SELECTQRY);
			while(rs.next()){
				if(rs.getInt("emp_id")==empId){
					pst = con.prepareStatement(QueryMapper.DELETEQRY);
					pst.setInt(1, empId);
					int data = pst.executeUpdate();
					flag=empId;
				}
				else{
					flag=0;
				}
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return empId;
		
			
			
		}
		
		
		
	

	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {
		return null;
		
		
	}

}
