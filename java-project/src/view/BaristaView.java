package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Barista;
import model.Product;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BaristaView extends JFrame {

	private JPanel contentPane;
	private JTable listProductTable;
	private JTextField productIDField;
	private JTextField quantityField;
	private JButton addToCartBtn;
	private JButton viewCartBtn;
	private JButton logOutBtn;
	private DefaultTableModel model;
	private Product products = new Product();
	private Barista controller = new Barista(this, products);

	public void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 389);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void initComponent() {
		logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(568, 23, 89, 23);
		contentPane.add(logOutBtn);
		JLabel lblNewLabel_2 = new JLabel("List Product");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(265, 11, 141, 52);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 647, 230);
		contentPane.add(scrollPane);
		
		listProductTable = new JTable();
		model = new DefaultTableModel(new String[] {
				"Product ID", "Name", "Description", "Price", "Stock"
		}, 0);
		listProductTable.setModel(model);
		scrollPane.setViewportView(listProductTable);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 295, 647, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product ID");
		lblNewLabel.setBounds(21, 13, 62, 14);
		panel.add(lblNewLabel);
		
		productIDField = new JTextField();
		productIDField.setBounds(93, 10, 86, 20);
		productIDField.setColumns(10);
		panel.add(productIDField);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setBounds(218, 13, 62, 14);
		panel.add(lblNewLabel_1);
		
		quantityField = new JTextField();
		quantityField.setBounds(278, 10, 86, 20);
		quantityField.setColumns(10);
		panel.add(quantityField);
		
		addToCartBtn = new JButton("Add to Cart");
		addToCartBtn.setBounds(407, 9, 111, 23);
		panel.add(addToCartBtn);
		
		viewCartBtn = new JButton("View Cart");
		viewCartBtn.setBounds(548, 9, 89, 23);
		panel.add(viewCartBtn);
		initListener();
	}
	
	public BaristaView() {
		initFrame();
		initComponent();
		setVisible(true);
		controller.getAllProduct();
	}
	
	public void  initListener() {
		getLogOutBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Barista.loginView();
			}
		});
		
		getViewCartBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Barista.viewCart(controller);
			}
		});
		
		getLogOutBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		getAddToCartBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getProductIDField().getText().equals("") || getQuantityField().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "All Fields are required");
				} else {
					controller.addToCart(Integer.parseInt(getProductIDField().getText()), Integer.parseInt(getQuantityField().getText()));
					productIDField.setText("");
					quantityField.setText("");
				}
			}
		});
	}
	
	public JTable getListProductTable() {
		return listProductTable;
	}

	public void setListProductTable(JTable listProductTable) {
		this.listProductTable = listProductTable;
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

	public JTextField getQuantityField() {
		return quantityField;
	}

	public void setQuantityField(JTextField quantityField) {
		this.quantityField = quantityField;
	}

	public JButton getAddToCartBtn() {
		return addToCartBtn;
	}

	public void setAddToCartBtn(JButton addToCartBtn) {
		this.addToCartBtn = addToCartBtn;
	}

	public JButton getViewCartBtn() {
		return viewCartBtn;
	}

	public void setViewCartBtn(JButton viewCartBtn) {
		this.viewCartBtn = viewCartBtn;
	}

	public JButton getLogOutBtn() {
		return logOutBtn;
	}

	public void setLogOutBtn(JButton logOutBtn) {
		this.logOutBtn = logOutBtn;
	}
	
}
