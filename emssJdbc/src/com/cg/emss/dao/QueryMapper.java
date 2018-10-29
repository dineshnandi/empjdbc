package com.cg.emss.dao;

public interface QueryMapper 
{
	public static final String SELECTQRY=
			"SELECT * FROM emp112081";
	public static final String SELECTQRY2=
			"SELECT * FROM emp112081 WHERE emp_id=333";
	public static final String INSERTQRY1=
			"INSERT INTO emp112081 VALUES(222,'Sunil',34000,'12-Jan-2018')";
	public static final String INSERTQRY2=
			"INSERT INTO emp112081(emp_id,emp_name,emp_sal) "+
					" VALUES(333,'Amit',60000)";
	public static final String INSERTQRY3=
			"INSERT INTO emp112081(emp_id,emp_name,emp_sal) "+
					" VALUES(?,?,?)";
	public static final String UPDATEQRY=
			"UPDATE emp112081 set emp_name=?,emp_sal=? where emp_id=?";
	public static final String DELETEQRY=
			"DELETE from emp112081 where emp_id IN ?";
}
