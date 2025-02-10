package com.learning.Main;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;

import com.learning.dao.EmployeeDaoImpl;
import com.learning.entity.Employee;  

public class App {

	public static void main(String[] args) throws SQLException {
		EmployeeDaoImpl edao = new EmployeeDaoImpl();
//		Employee Rohit = new Employee(6, 45678, "Rohit", "Male");
//		Employee Vikas = new Employee(2, 45678, "Vikas", "Male");
//		Employee Akshat = new Employee(3, 45678, "Akshat", "Male");
//		Employee Anurag = new Employee(4, 56000, "Anurag Sharma", "Male");
//		Employee Payal = new Employee(5, 11000, "Payal", "Female");
		Employee Nalin = new Employee(7,"Nalin", "Male", 25000);
		
		
//		edao.save(Ansh);
//		edao.save(Vikas);
//		edao.save(Akshat);
//		edao.save(Anurag);
		
//		edao.update(Anurag);
		
//		edao.delete(4);
		
//		edao.getAllEmployees();
		
//		edao.getEmployeeByName("Anurag'");
		
//		edao.saveByPS(Rohit);
		
//		edao.getEmployeeById(5);
		
		
//		edao.update();
//		edao.delete(11);

//		edao.createTable();
		
//		edao.updateByPS(Anurag);
		
//		edao.deleteByPS(6);
		
		System.out.println("--------- Transaction Successful!!!! ----------");
		
	}

}
