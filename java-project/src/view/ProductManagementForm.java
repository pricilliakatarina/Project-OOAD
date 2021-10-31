package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Barista;
import controller.ProductHandler;
import model.Product;
import model.Voucher;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProductManagementForm extends JFrame {

	private JPanel contentPane;
	private JTable listProductTable;
	private DefaultTableModel model;
	private JTextField productIDField;
	private JTextField productNameField;
	private JTextField descriptionField;
	private JTextField priceField;
	private JTextField stockField;
	private JButton logOutButton;
	private JButton updateButton;
	private JButton insertButton;
	private JButton deleteButton;
	private Product products = new Product();
	private Voucher vouchers = new Voucher(0, null, 0);
	private ProductHandler displayProduct = new ProductHandler(this, products);
	private ProductHandler controller = new ProductHandler(this, vouchers);
	private JScrollPane scrollPane_1;
	private JTable voucherTable;
	private DefaultTableModel model1;
	private JLabel lblNewLabel_5;
	private JTextField voucherIDField;
	private JLabel lblNewLabel_6;
	private JTextField discountField;
	private JTextField statusField;
	private JButton insertButton_1;
	private JButton deleteButton_1;
	private JButton insertButton_2;
	
	public void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void initComponent() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 972, 236);
		contentPane.add(scrollPane);
		
		listProductTable = new JTable();
		model = new DefaultTableModel(new String[] {
				"Product ID", "Name", "Description", "Price", "Stock"
		}, 0);
		listProductTable.setModel(model);
		scrollPane.setViewportView(listProductTable);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 354, 972, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product ID");
		lblNewLabel.setBounds(36, 38, 74, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setBounds(36, 85, 98, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(34, 140, 76, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(36, 185, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setBounds(34, 227, 46, 14);
		panel.add(lblNewLabel_4);
		
		productIDField = new JTextField();
		productIDField.setBounds(120, 35, 226, 20);
		panel.add(productIDField);
		productIDField.setColumns(10);
		
		productNameField = new JTextField();
		productNameField.setBounds(120, 82, 226, 20);
		panel.add(productNameField);
		productNameField.setColumns(10);
		
		descriptionField = new JTextField();
		descriptionField.setColumns(10);
		descriptionField.setBounds(120, 137, 226, 20);
		panel.add(descriptionField);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(120, 182, 226, 20);
		panel.add(priceField);
		
		stockField = new JTextField();
		stockField.setColumns(10);
		stockField.setBounds(120, 224, 226, 20);
		panel.add(stockField);
		
		insertButton = new JButton("Insert");
		insertButton.setBounds(405, 81, 89, 23);
		panel.add(insertButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(405, 136, 89, 23);
		panel.add(updateButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(405, 181, 89, 23);
		panel.add(deleteButton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(540, 11, 422, 143);
		panel.add(scrollPane_1);
		
		voucherTable = new JTable();
		model1 = new DefaultTableModel(new String[] {
				"Voucher ID", "Discount", "Status"
		}, 0);
		voucherTable.setModel(model1);
		scrollPane_1.setViewportView(voucherTable);
		
		lblNewLabel_5 = new JLabel("voucherID");
		lblNewLabel_5.setBounds(540, 185, 89, 14);
		panel.add(lblNewLabel_5);
		
		voucherIDField = new JTextField();
		voucherIDField.setBounds(689, 182, 86, 20);
		panel.add(voucherIDField);
		voucherIDField.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Discount");
		lblNewLabel_6.setBounds(540, 227, 74, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Status");
		lblNewLabel_7.setBounds(540, 272, 46, 14);
		panel.add(lblNewLabel_7);
		
		discountField = new JTextField();
		discountField.setText("");
		discountField.setBounds(689, 224, 86, 20);
		panel.add(discountField);
		discountField.setColumns(10);
		
		statusField = new JTextField();
		statusField.setBounds(689, 269, 86, 20);
		panel.add(statusField);
		statusField.setColumns(10);
		
		insertButton_1 = new JButton("Insert");
		insertButton_1.setBounds(815, 223, 89, 23);
		panel.add(insertButton_1);
		
		deleteButton_1 = new JButton("Delete");
		deleteButton_1.setBounds(815, 263, 89, 23);
		panel.add(deleteButton_1);
		
		logOutButton = new JButton("Log Out");
		logOutButton.setBounds(893, 42, 89, 23);
		contentPane.add(logOutButton);
		initListener();
	}
	
	public ProductManagementForm() {
		setTitle("Product Admin");
		initFrame();
		initComponent();
		setVisible(true);	
		displayProduct.getAllProduct();
		controller.getAllVoucher();
	}
	
	public void initListener() {
		getDeleteButton_1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteVoucher();
			}
		});
		
		getInsertButton_1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.insertVoucher();
			}
		});
		getLogOutButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LoginForm();
			}
		});
		getDeleteButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayProduct.deleteProduct();
			}
		});
		
		getUpdateButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayProduct.updateProduct();
			}
		});
		
		getInsertButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayProduct.insertProduct();
			}
		});
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JTextField getProductIDField() {
		return productIDField;
	}

	public void setProductIDField(JTextField productIDField) {
		this.productIDField = productIDField;
	}

	public JTextField getProductNameField() {
		return productNameField;
	}

	public void setProductNameField(JTextField productNameField) {
		this.productNameField = productNameField;
	}

	public JTextField getDescriptionField() {
		return descriptionField;
	}

	public void setDescriptionField(JTextField descriptionField) {
		this.descriptionField = descriptionField;
	}

	public JTextField getPriceField() {
		return priceField;
	}

	public void setPriceField(JTextField priceField) {
		this.priceField = priceField;
	}

	public JTextField getStockField() {
		return stockField;
	}

	public void setStockField(JTextField stockField) {
		this.stockField = stockField;
	}

	public JButton getLogOutButton() {
		return logOutButton;
	}

	public void setLogOutButton(JButton logOutButton) {
		this.logOutButton = logOutButton;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}

	public JButton getInsertButton() {
		return insertButton;
	}

	public void setInsertButton(JButton insertButton) {
		this.insertButton = insertButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JTable getVoucherTable() {
		return voucherTable;
	}

	public void setVoucherTable(JTable voucherTable) {
		this.voucherTable = voucherTable;
	}

	public DefaultTableModel getModel1() {
		return model1;
	}

	public void setModel1(DefaultTableModel model1) {
		this.model1 = model1;
	}

	public JTable getListProductTable() {
		return listProductTable;
	}

	public void setListProductTable(JTable listProductTable) {
		this.listProductTable = listProductTable;
	}

	public JTextField getVoucherIDField() {
		return voucherIDField;
	}

	public void setVoucherIDField(JTextField voucherIDField) {
		this.voucherIDField = voucherIDField;
	}

	public JTextField getDiscountField() {
		return discountField;
	}

	public void setDiscountField(JTextField discountField) {
		this.discountField = discountField;
	}

	public JTextField getStatusField() {
		return statusField;
	}

	public void setStatusField(JTextField statusField) {
		this.statusField = statusField;
	}

	public JButton getInsertButton_1() {
		return insertButton_1;
	}

	public void setInsertButton_1(JButton insertButton_1) {
		this.insertButton_1 = insertButton_1;
	}

	public JButton getDeleteButton_1() {
		return deleteButton_1;
	}

	public void setDeleteButton_1(JButton deleteButton_1) {
		this.deleteButton_1 = deleteButton_1;
	}
	
	
}
