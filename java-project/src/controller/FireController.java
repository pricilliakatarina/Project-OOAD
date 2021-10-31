package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import view.EmployeFireView;
import view.LoginForm;

public class FireController {
	
	private EmployeFireView view;
	private Employee model;
	
	public FireController(EmployeFireView view, Employee model) {
		super();
		this.view = view;
		this.model = model;	 
	 }
	
	public void ListEmployee(ArrayList<Employee> employees) {
		DefaultTableModel table = (DefaultTableModel) view.getModelEmployee();
			
		table.setRowCount(0);
			
		for (int i = 0; i < employees.size(); i++) {
			Employee e = employees.get(i);
			table.addRow(new Object[] {e.getEmployeeID(), e.getPositionID(), e.getName(), e.getStatus(), e.getSalary(), e.getUsername(), e.getPassword()});
		}
	 }
	
	public void getAllEmployees() {
		ArrayList<Employee> employees = model.getAllEmployees();
		ListEmployee(employees);
	}
	
	public static void getFrame() {	
		new EmployeFireView();
	}
	
	public void insertEmployee(String name, int positionID, int salary, String username, String password) {	
		if(name != "" && salary > 0 && username != "" ) {
			model.insertEmployee(positionID, username, "active", salary, username, password);
			getAllEmployees();
			JOptionPane.showMessageDialog(null, "Insert Employee Successfully");
		}else {
			JOptionPane.showMessageDialog(null, "Invalid Input!!!");
		}
		
	}
	
	public void deleteEmployee(int ID) {
		if(ID != 0) {
			 model.fireEmployee(ID);
			 getAllEmployees();
			 JOptionPane.showMessageDialog(null, "Delete Employee Successfully");
		}else {
			JOptionPane.showMessageDialog(null, "You must input the ID!!!");
		}
	}
	
	public void updateEmployee(int employeeID, String name, int salary, String username, String password) {
		
		if(employeeID != 0) {
			model.updateEmployee(employeeID, name, salary, username, password);
			getAllEmployees();
			JOptionPane.showMessageDialog(null, "Update Employee Successfully");
		}else {
			JOptionPane.showMessageDialog(null, "You must input the ID!!!");
		}
		
	}
	
	public void logOut() {
		new LoginForm();
		view.setVisible(false);
	}

}
