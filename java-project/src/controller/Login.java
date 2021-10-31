package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Employee;
import view.BaristaView;
import view.HumanResourceDepartmentView;
import view.LoginForm;
import view.ManagerView;
import view.ProductManagementForm;

public class Login {

	private LoginForm view;
	private Employee model;
	
	public Login(LoginForm view, Employee model) {
		super();
		this.view = view;
		this.model = model;
	}
	
	public void validate(String username, String password) {
		System.out.println("Hello World!");
		ArrayList<Employee> e = new ArrayList<Employee>();
		e = model.getAllEmployees();
		boolean found = false;
		int position = 0;
		for (Employee employee : e) {
			if (employee.getUsername().equals(username)) {
				if (employee.getPassword().equals(password)) {
					position = employee.getPositionID();
					found = true;
				} else {
					break;
				}
			} 
		}
		if (found) {
			if (position == 1) {
				new BaristaView();
			} else if (position == 2) {
				new ManagerView();
			} else if (position == 3) {
				new HumanResourceDepartmentView();
			} else if (position == 4) {
				new ProductManagementForm();
			}
		} else {
			JOptionPane.showMessageDialog(null ,"Wrong Username or Password.");
		}
	}
	
	public static void Login() {
		new LoginForm();
	}
}
