package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class Employee {
	private int employeeID, positionID, salary;
	private String name, status, username, password;
	
	public Employee() {
		
	}
	
	public Employee(int employeeID, int positionID, int salary, String name, String status, String username,
			String password) {
		super();
		this.employeeID = employeeID;
		this.positionID = positionID;
		this.salary = salary;
		this.name = name;
		this.status = status;
		this.username = username;
		this.password = password;
	}
	
	public Employee insertEmployee(int positionID, String name, String status, int salary, String username, String password) {
		String query = "INSERT INTO employee (positionID, name, status, salary, username, password) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setInt(1, positionID);
			ps.setString(2, name);
			ps.setString(3, status);
			ps.setInt(4, salary);
			ps.setString(5, username);
			ps.setString(6, password);
			ps.executeUpdate();
			return this;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String query = "SELECT * from employee";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				employees.add(new Employee(
						rs.getInt("employeeID"),
						rs.getInt("positionID"),
						rs.getInt("salary"),
						rs.getString("name"),
						rs.getString("status"),
						rs.getString("username"),
						rs.getString("password")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}
	
	public Employee getEmployee(String username) {
		Employee em = null; 
		String query = "SELECT * FROM employee WHERE username = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			em = new Employee(
					rs.getInt("employeeID"),
					rs.getInt("positionID"),
					rs.getInt("salary"),
					rs.getString("name"),
					rs.getString("status"),
					rs.getString("username"),
					rs.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return em;
	}
	
	public Employee updateEmployee(int employeeID, String name, int salary, String username, String password) {
		String query = "UPDATE employee SET name = ?, salary = ?, username = ?, password = ? WHERE employeeID = ?";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, salary);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setInt(5, employeeID);
			ps.executeUpdate();
			return this;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public boolean fireEmployee(int ID) {
		String query = "DELETE FROM employee WHERE employeeID = ?";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setInt(1, ID);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
