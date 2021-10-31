package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.TransactionDetailController;
import model.TransactionItem;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TransactionDetailView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private TransactionItem ti = new TransactionItem(0, 0, 0);
	private TransactionDetailController td = new TransactionDetailController (this, ti);
	private JLabel lblNewLabel_1;
	private JButton btnLogOut;

	
	public void initFrame () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void initComponent() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 60, 525, 165);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Transaction Detail");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 35, 166, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("COFFEE VIBES MANAGER");
		lblNewLabel_1.setBounds(182, 5, 166, 37);
		contentPane.add(lblNewLabel_1);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(447, 19, 111, 23);
		contentPane.add(btnLogOut);
		initListener();
	}
	
	public TransactionDetailView() {
		initFrame();
		initComponent();
		setVisible(true);
		setTable();
		td.getAllTransactionItem();
	}
	
	public void initListener() {
		getBtnLogOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new LoginForm();
            }
        });
	}
	
	private void setTable() {
		// TODO Auto-generated method stub
		model = new DefaultTableModel(new String[] {
				"TransactionID", "DetailProductID","DetailQuantity"
		}, 0);
		
		table.setModel(model);
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public void setBtnLogOut(JButton btnLogOut) {
		this.btnLogOut = btnLogOut;
	}

	

}
