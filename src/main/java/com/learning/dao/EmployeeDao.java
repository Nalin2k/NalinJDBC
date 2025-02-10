package com.learning.dao;

import java.sql.SQLException;

import com.learning.entity.Employee;

public interface EmployeeDao {
	public void save (Employee e) throws SQLException;
	
	public void saveByPS (Employee e) throws SQLException;
	
	public void update (Employee e) throws SQLException;
	
	public void delete (int id) throws SQLException;
	
	public void getEmployeeByName(String name) throws SQLException;

	public void getEmployeeById(int id) throws SQLException;
	
	public void getAllEmployees() throws SQLException;
	
	public void updateByPS (Employee e) throws SQLException;
	
	public void createTable() throws SQLException;
	
	public void deleteByPS(int id) throws SQLException;
}
