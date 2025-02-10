package com.learning.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.learning.entity.Employee;


public class EmployeeDaoImpl implements EmployeeDao {
	
	static Connection con = null;	
	static Statement st = null;
	
	static final String CREATE_QUERY = "CREATE TABLE STUDENT (ROLLNO INT, NAME VARCHAR(25), AGE INT, GENDER VARCHAR(6), MARKS INT, PRIMARY KEY(ROLLNO))";
	static final String INSERT_QUERY = "INSERT INTO EMPLOYEE (ID, NAME, GENDER, SALARY) VALUES (%d, '%s', '%s', %d )";
	static final String UPDATE_QUERY = "UPDATE EMPLOYEE SET NAME = '%s', GENDER = '%s', SALARY = %d WHERE ID = %d";
	static final String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID = %d";
	static final String SELECT_QUERY = "SELECT * FROM EMPLOYEE";
	static final String SELECT_BY_ID_PS_QUERY = "SELECT * FROM EMPLOYEE WHERE ID = ?";
	static final String INSERT_BY_PS_QUERY = "INSERT INTO EMPLOYEE (ID, NAME, GENDER, SALARY) VALUES (?, ?, ?, ?)";
	static final String UPDATE_BY_PS_QUERY = "UPDATE EMPLOYEE SET NAME = ?, GENDER = ?, SALARY = ? WHERE ID = ?";
	static final String DELETE_BY_PS_QUERY = "DELETE FROM EMPLOYEE WHERE ID = ?";
	
	static {
		try {
			//1st 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			
//			2nd Approach
//			Properties ps = new Properties();
//			ps.put("user", "root");
//			ps.put("password", "root");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", ps);

			
			//3rd Approach
//			Properties ps = new Properties();
//			ps.put("user", "root");
//			ps.put("password", "root");
//			Driver d = new com.mysql.cj.jdbc.Driver();
//			con = d.connect("jdbc:mysql://localhost:3306/mydb", ps);
			
			
			st = con.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save (Employee e) throws SQLException {
		st.executeUpdate(String.format(INSERT_QUERY, e.getId(), e.getName(), e.getGender(), e.getSalary()));
		System.out.println(String.format(INSERT_QUERY, e.getId(), e.getName(), e.getGender(), e.getSalary()));

	}
		
	@Override
	public void update(Employee e) throws SQLException {
		 st.executeUpdate(String.format(UPDATE_QUERY, e.getName(), e.getGender(), e.getSalary(), e.getId()));
		 System.out.println(String.format(UPDATE_QUERY, e.getName(), e.getGender(), e.getSalary(), e.getId()));
		
	}
	
	@Override
	public void delete (int id) throws SQLException {
		st.executeUpdate(String.format(DELETE_QUERY, id));
		System.out.println(String.format(DELETE_QUERY, id));
	}

	@Override
	public void getEmployeeById(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_PS_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println("  ID: " + rs.getInt(1) + "  NAME: " + rs.getString(2) + 
					"  GENDER: " + rs.getString(3) + "  SALARY: " + rs.getInt(4));
		}
	}

	@Override
	public void getAllEmployees() throws SQLException{
		ResultSet rs = st.executeQuery(SELECT_QUERY);
		while(rs.next())
		{
			System.out.println("ID: " + rs.getInt(1) + "	NAME: " + rs.getString(2) + 
							"	GENDER: " + rs.getString(3) + "	SALARY: " + rs.getInt(4));
		}
		
		System.out.println(SELECT_QUERY);
	}

	@Override
	public void getEmployeeByName(String name) throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE WHERE NAME = '" + name);
		while(rs.next())
		{
			System.out.println("ID: " + rs.getInt(1) + "	NAME: " + rs.getString(2) + 
							" GENDER: " + rs.getString(3) + "	SALARY: " + rs.getInt(4));
		}
		
		System.out.println();

	}

	@Override
	public void saveByPS(Employee e) throws SQLException {
		PreparedStatement ps = con.prepareStatement(INSERT_BY_PS_QUERY);
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getGender());
		ps.setInt(4, e.getSalary());
		ps.executeUpdate();
		System.out.println("EmployeeDaoImpl.saveByPS()");
	}

	@Override
	public void createTable() throws SQLException {
		st.executeUpdate(CREATE_QUERY);
		System.out.println(CREATE_QUERY);
	}

	@Override
	public void updateByPS(Employee e) throws SQLException {
		PreparedStatement ps = con.prepareStatement(UPDATE_BY_PS_QUERY);
		ps.setString(1, e.getName());
		ps.setString(2, e.getGender());
		ps.setInt(3, e.getSalary());
		ps.setInt(4, e.getId());
		ps.executeUpdate();
		System.out.println("EmployeeDaoImpl.updateByPS()");
	}

	@Override
	public void deleteByPS(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement(DELETE_BY_PS_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	
}
