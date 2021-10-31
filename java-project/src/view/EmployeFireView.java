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

import controller.FireController;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class EmployeFireView extends JFrame {

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
	private JTextField name;
	private JTextField salary;
	private JTextField username;
	private JTextField password;
	
	private JTable table_1;
	private JLabel lblNote;
	private JLabel lblInsert;
	private JLabel lblStatus;
	private JTextField textField;
	private JLabel lblDelete;
	private JLabel lblUpdateEmployeeInput;
	
	private Employee employ = new Employee();
	private FireController fc = new FireController(this, employ);
	
	DefaultTableModel modelEmployee;
	
	private JButton btnLogOut ;
	private JButton btnDeleteEmployee;
	private JButton btnBack_1 ;
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
		
		employeeID = new JTextField();
		employeeID.setBounds(106, 210, 242, 20);
		contentPane.add(employeeID);
		employeeID.setColumns(10);
		
		
		btnDeleteEmployee = new JButton("Fire Employee");
		btnDeleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeleteEmployee.setBounds(418, 296, 120, 23);
		contentPane.add(btnDeleteEmployee);
		 
		  btnLogOut = new JButton("Log Out");
		  btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		  btnLogOut.setBounds(854, 521, 120, 33);
		  contentPane.add(btnLogOut);
		  
		  btnBack_1 = new JButton("Back");
		  btnBack_1 .setFont(new Font("Tahoma", Font.PLAIN, 13));
		  btnBack_1 .setBounds(33, 521, 120, 33);
		  contentPane.add(btnBack_1);

		  initListener();
		  
		  
		  
	}

	/**
	 * View.
	 */
	
	public EmployeFireView() {
		
		initFrame();
		initComponent();
		setTableEmployee();
		fc.getAllEmployees();
		setVisible(true);
		
	}
	
	public void initListener() {
		getBtnDeleteEmployee().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fc.deleteEmployee(Integer.parseInt(getEmployeeID().getText()));
            }
        });
		
		getBtnLogOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new LoginForm();
            }
        });
		

		getBtnBack_1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new ManagerView();
            }
        });
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
	

	
	/**
	 * Setters and Getters.
	 */
	
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public void setBtnLogOut(JButton btnLogOut) {
		this.btnLogOut = btnLogOut;
	}

	public DefaultTableModel getModelEmployee() {
		return modelEmployee;
	}

	public void setModelEmployee(DefaultTableModel modelEmployee) {
		this.modelEmployee = modelEmployee;
	}

	public JButton getBtnDeleteEmployee() {
		return btnDeleteEmployee;
	}

	public void setBtnDeleteEmployee(JButton btnDeleteEmployee) {
		this.btnDeleteEmployee = btnDeleteEmployee;
	}

	public JTextField getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(JTextField employeeID) {
		this.employeeID = employeeID;
	}

	public JButton getBtnBack_1() {
		return btnBack_1;
	}

	public void setBtnBack_1(JButton btnBack_1) {
		this.btnBack_1 = btnBack_1;
	}
		
}
