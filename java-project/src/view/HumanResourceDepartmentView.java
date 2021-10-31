package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import model.Position;

import controller.EmployeeController;
import controller.PositionController;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class HumanResourceDepartmentView extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JTable table;
	private JLabel lblEmployeeID;
	private JLabel lblPositionID;
	private JLabel lblName;
	private JLabel lblSalary;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField employeeID;
	private JTextField positionID;
	private JTextField names;
	private JTextField salary;
	private JTextField username;
	private JTextField password;
	
	private JTable table_1;
	private JLabel lblNote;
	private JLabel lblInsert;
	private JLabel lblStatus;
	private JTextField status;
	private JLabel lblDelete;
	private JLabel lblUpdateEmployeeInput;
	
	private Employee employ = new Employee();
	private EmployeeController ec = new EmployeeController(this, employ);
	
	private Position posi = new Position();
	private PositionController pc = new PositionController(this, posi);
	
	DefaultTableModel modelEmployee;
	DefaultTableModel modelPosition;
	
	
	private JButton btnInsertEmployee;
	private JButton btnDeleteEmployee;
	private JButton btnUpdateEmployee;
	private JButton btnLogOut;
	
	/**
	 * Create the frame.
	 */
	
	
	public void initFrame(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	
	/**
	 * Create the component.
	 */
	
	
	public void initComponent() {

		lblTitle = new JLabel("\t\t\t\t\t\t\t\tCoffee Vibes Employees");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitle.setBounds(413, 11, 164, 28);
		contentPane.add(lblTitle);
		
		JLabel lblEmployeeTable = new JLabel("Employee");
		lblEmployeeTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeTable.setBounds(10, 61, 72, 20);
		contentPane.add(lblEmployeeTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 964, 85);
		contentPane.add(scrollPane);
		
		table = new JTable();	
		scrollPane.setViewportView(table);
		
		lblEmployeeID = new JLabel("EmployeeID");
		lblEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmployeeID.setBounds(10, 213, 64, 14);
		contentPane.add(lblEmployeeID);
		
		lblPositionID = new JLabel("PositionID");
		lblPositionID.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPositionID.setForeground(new Color(0, 0, 0));
		lblPositionID.setBounds(10, 241, 64, 20);
		contentPane.add(lblPositionID);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(10, 272, 46, 14);
		contentPane.add(lblName);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSalary.setBounds(10, 300, 46, 14);
		contentPane.add(lblSalary);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(10, 362, 64, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(10, 393, 46, 14);
		contentPane.add(lblPassword);
		
		employeeID = new JTextField();
		employeeID.setBounds(106, 210, 242, 20);
		contentPane.add(employeeID);
		employeeID.setColumns(10);
		
		positionID = new JTextField();
		positionID.setBounds(106, 241, 242, 20);
		contentPane.add(positionID);
		positionID.setColumns(10);
		
		names = new JTextField();
		names.setBounds(106, 269, 242, 20);
		contentPane.add(names);
		names.setColumns(10);
		
		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(106, 297, 242, 20);
		contentPane.add(salary);
		
		username = new JTextField();
		username.setBounds(106, 359, 242, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(106, 390, 242, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		btnInsertEmployee = new JButton("Insert Employee");
		btnInsertEmployee.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInsertEmployee.setBounds(418, 229, 120, 23);
		contentPane.add(btnInsertEmployee);
		
		btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeleteEmployee.setBounds(418, 296, 120, 23);
		contentPane.add(btnDeleteEmployee);
		
		btnUpdateEmployee = new JButton("Update Employee");
		btnUpdateEmployee.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUpdateEmployee.setBounds(418, 358, 120, 23);
		contentPane.add(btnUpdateEmployee);
		
		JLabel lblPositionTable = new JLabel("Position");
		lblPositionTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPositionTable.setBounds(614, 202, 64, 20);
		contentPane.add(lblPositionTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(614, 232, 360, 85);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		lblNote = new JLabel("Note:");
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNote.setBounds(10, 465, 46, 14);
		contentPane.add(lblNote);
		
		lblInsert = new JLabel("Insert Employee: Input Name, PositionID, Salary, Username, and Password only.");
		lblInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInsert.setBounds(10, 490, 528, 14);
		contentPane.add(lblInsert);
		
		lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStatus.setBounds(10, 325, 46, 28);
		contentPane.add(lblStatus);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(106, 328, 242, 20);
		contentPane.add(status);
		
		lblDelete = new JLabel("Delete Employee: Input EmployeeID only.");
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDelete.setBounds(10, 515, 528, 14);
		contentPane.add(lblDelete);
		
		lblUpdateEmployeeInput = new JLabel("Update Employee: Input EmployeeID, Name, Salary, Username and Password only.");
		lblUpdateEmployeeInput.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUpdateEmployeeInput.setBounds(10, 540, 528, 14);
		contentPane.add(lblUpdateEmployeeInput);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogOut.setBounds(854, 521, 120, 33);
		contentPane.add(btnLogOut);
		
		initListener();
		
	}

	
	/**
	 * View.
	 */
	
	
	public HumanResourceDepartmentView() {
		
		initFrame();
		initComponent();
		setTableEmployee();
		setTablePosition();
		ec.getAllEmployees();
		pc.getAllPositions();
		setVisible(true);
		
	}
	
	
	/**
	 * Tables.
	 */
	
	
	private void setTableEmployee() {
		modelEmployee = new DefaultTableModel (new String[] {
			"EmployeeID", "PositionID", "Name", "Status", "Salary", "Username", "Password"

		}, 0);
		
		table.setModel(modelEmployee);
	}
	
	private void setTablePosition() {
		modelPosition = new DefaultTableModel (new String[] {
			"PositionID", "Position Name"

		}, 0);
		
		table_1.setModel(modelPosition);
	}
	
	public void initListener() {
	
		getBtnInsertEmployee().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ec.insertEmployee(getNames().getText(), Integer.parseInt(getPositionID().getText()), Integer.parseInt(getSalary().getText()), getUsername().getText(), getPassword().getText());
				
			}
		});
		
		
		getBtnDeleteEmployee().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ec.deleteEmployee(Integer.parseInt(getEmployeeID().getText()));
				
			}
		});
		
		getBtnUpdateEmployee().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ec.updateEmployee(Integer.parseInt(getEmployeeID().getText()), getNames().getText(), Integer.parseInt(getSalary().getText()), getUsername().getText(), getPassword().getText());
				
			}
		});
		
		getBtnLogOut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ec.logOut();
			}
		});

	}
	
	
	/**
	 * Setters and Getters.
	 */
	
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public DefaultTableModel getModelEmployee() {
		return modelEmployee;
	}

	public void setModelEmployee(DefaultTableModel modelEmployee) {
		this.modelEmployee = modelEmployee;
	}

	public DefaultTableModel getModelPosition() {
		return modelPosition;
	}

	public void setModelPosition(DefaultTableModel modelPosition) {
		this.modelPosition = modelPosition;
	}


	public JButton getBtnInsertEmployee() {
		return btnInsertEmployee;
	}


	public void setBtnInsertEmployee(JButton btnInsertEmployee) {
		this.btnInsertEmployee = btnInsertEmployee;
	}


	public JButton getBtnDeleteEmployee() {
		return btnDeleteEmployee;
	}


	public void setBtnDeleteEmployee(JButton btnDeleteEmployee) {
		this.btnDeleteEmployee = btnDeleteEmployee;
	}


	public JButton getBtnUpdateEmployee() {
		return btnUpdateEmployee;
	}


	public void setBtnUpdateEmployee(JButton btnUpdateEmployee) {
		this.btnUpdateEmployee = btnUpdateEmployee;
	}


	public JButton getBtnLogOut() {
		return btnLogOut;
	}


	public void setBtnLogOut(JButton btnLogOut) {
		this.btnLogOut = btnLogOut;
	}


	public JTextField getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(JTextField employeeID) {
		this.employeeID = employeeID;
	}


	public JTextField getPositionID() {
		return positionID;
	}


	public void setPositionID(JTextField positionID) {
		this.positionID = positionID;
	}


	public JTextField getSalary() {
		return salary;
	}


	public void setSalary(JTextField salary) {
		this.salary = salary;
	}


	public JTextField getUsername() {
		return username;
	}


	public void setUsername(JTextField username) {
		this.username = username;
	}


	public JTextField getPassword() {
		return password;
	}


	public void setPassword(JTextField password) {
		this.password = password;
	}


	public JTextField getStatus() {
		return status;
	}


	public void setStatus(JTextField status) {
		this.status = status;
	}


	public JTextField getNames() {
		return names;
	}


	public void setName(JTextField names) {
		this.names = names;
	}

	
	
}
