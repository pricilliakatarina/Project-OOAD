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
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ManagerController;
import model.Transaction;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ManagerView extends JFrame {

	private JPanel contentPane;
	private JTable table_TransactionH;
	private JTable table_Employee;
	private JTextField textField_5;
	DefaultTableModel model;
	private Transaction trc = new Transaction(0, 0, 0, 0, null);
	private ManagerController mc = new ManagerController(this, trc);
	private JButton btn_viewTD ;
	private JButton btnLogOut;
	private JButton btnFire;
	
	public void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void initComponent() {
		JLabel lblTransactionHeader = new JLabel("Transaction Header");
		lblTransactionHeader.setBounds(26, 43, 151, 21);
		lblTransactionHeader.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblTransactionHeader);
			
		JLabel lblShopName = new JLabel("COFFEE VIBES MANAGER");
		lblShopName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblShopName.setBounds(296, 11, 187, 27);
		contentPane.add(lblShopName);
		
		JScrollPane scrollPane_TH = new JScrollPane();
		scrollPane_TH.setBounds(26, 75, 810, 181);
		contentPane.add(scrollPane_TH);
		
		table_TransactionH = new JTable();
		scrollPane_TH.setViewportView(table_TransactionH);
		btn_viewTD = new JButton("View Detail Transaction");
		btn_viewTD.setBounds(639, 277, 197, 39);
		contentPane.add(btn_viewTD);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.setBounds(718, 31, 89, 23);
		contentPane.add(btnLogOut);
		
		btnFire = new JButton("Fire Employee");
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFire.setBounds(648, 354, 187, 23);
		contentPane.add(btnFire);
		  initListener();
	}
	
	public ManagerView() {
		initFrame ();
		initComponent();
		setVisible (true);
		setTable();
		mc.getAllTransactions();
		
	}
	
	public void initListener() {
		getBtn_viewTD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new TransactionDetailView();
            }
        });
		
		getBtnLogOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new LoginForm();
            }
        });
		
		getBtnFire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new EmployeFireView();
            }
        });
	}
	
	
	private void setTable() {
		// TODO Auto-generated method stub
		model = new DefaultTableModel(new String[] {
				"TransactionID", "PurchaseDate","TransactionVoucherID", "EmployeeID", "TotalPrice"
		}, 0);
		
		table_TransactionH.setModel(model);
		
	}
	public JTable getTable_TransactionH() {
		return table_TransactionH;
	}
	public void setTable_TransactionH(JTable table_TransactionH) {
		this.table_TransactionH = table_TransactionH;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	public JButton getBtn_viewTD() {
		return btn_viewTD;
	}
	public void setBtn_viewTD(JButton btn_viewTD) {
		this.btn_viewTD = btn_viewTD;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	public void setBtnLogOut(JButton btnLogOut) {
		this.btnLogOut = btnLogOut;
	}
	public JButton getBtnFire() {
		return btnFire;
	}
	public void setBtnFire(JButton btnFire) {
		this.btnFire = btnFire;
	}
	
	

}

