package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Barista;
import model.CartHandler;
import model.Product;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CartForm extends JFrame {

	private JPanel contentPane;
	private JTable cartTable;
	private JTextField idField;
	private JButton checkOutBtn;
	private JButton backBtn;
	private JButton useBtn;
	private JButton logOutBtn;
	private JButton removeBtn;
	private DefaultTableModel model;
	private Barista controller; 
	private ArrayList<CartHandler> cart;
	private JTextField voucherField;
	private JLabel totalPrice;
	

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void initComponent() {		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(10, 24, 89, 23);
		contentPane.add(backBtn);
		JLabel lblNewLabel = new JLabel("Cart");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(303, 24, 65, 31);
		contentPane.add(lblNewLabel);
		
		logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(571, 34, 89, 23);
		contentPane.add(logOutBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 650, 230);
		contentPane.add(scrollPane);
		
		cartTable = new JTable();
		model = new DefaultTableModel(
			new String[] {
				"ID", "Name", "Quantity", "Price"
			}, 0);
		cartTable.setModel(model);
		scrollPane.setViewportView(cartTable);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 296, 650, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 18, 11, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		idField = new JTextField();
		idField.setBounds(31, 15, 86, 20);
		panel.add(idField);
		idField.setColumns(10);
		
		removeBtn = new JButton("Remove");
		removeBtn.setBounds(145, 14, 89, 23);
		panel.add(removeBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 338, 289, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Voucher");
		lblNewLabel_3.setBounds(10, 18, 72, 14);
		panel_1.add(lblNewLabel_3);
		
		useBtn = new JButton("Use");
		useBtn.setBounds(199, 14, 72, 23);
		panel_1.add(useBtn);
		
		voucherField = new JTextField();
		voucherField.setBounds(83, 15, 86, 20);
		panel_1.add(voucherField);
		voucherField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(436, 338, 224, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Total");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 9, 65, 25);
		panel_2.add(lblNewLabel_4);
		
		totalPrice = new JLabel("0");
		totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPrice.setBounds(54, 11, 160, 25);
		panel_2.add(totalPrice);
		
		checkOutBtn = new JButton("Check Out");
		checkOutBtn.setBounds(516, 392, 110, 23);
		contentPane.add(checkOutBtn);
		initListener();
	}
	
	public CartForm(Barista contoller) {
		this.controller = contoller;
		initFrame();
		initComponent();
		setVisible(true);
		refreshData();
		updateTotalPrice();
	}
	
	private void refreshData() {
		cart = controller.getCart();
		
		model.setRowCount(0);
		
		for (CartHandler ch : cart) {
			model.addRow(new Object[] {ch.getiD(), ch.getName(), ch.getQuantity(), ch.getPrice()});
		}
	}
	
	private void removeProduct(int id) {
		cart= controller.getCart();
		boolean found = false;
		for (CartHandler cartHandler : cart) {
			if (cartHandler.getiD() == id) {
				cart.remove(cartHandler);
				found = true;
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null ,"Product not Found.");
		}
	}
	
	private void updateTotalPrice() {
		cart = controller.getCart();
		int totalPrices = 0;
		for (CartHandler cartHandler : cart) {
			totalPrices += cartHandler.getPrice();
		}
		totalPrice.setText(String.valueOf(totalPrices));
		
	}
	
	public void initListener() {
		getRemoveBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeProduct(Integer.parseInt(getIdField().getText()));
				refreshData();
				getIdField().setText("");
			}
		});
		getUseBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					controller.useVoucher(Integer.parseInt(getVoucherField().getText()));			
			}
		});
		getCheckOutBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateProduct();
				controller.clearCart();
				Barista.baristaView();
			}
		});
		
		getLogOutBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				controller.loginView();
			}
		});
		
		getBackBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Barista.baristaView();
			}
		});
	}
	

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getVoucherField() {
		return voucherField;
	}

	public void setVoucherField(JTextField voucherField) {
		this.voucherField = voucherField;
	}

	public JButton getCheckOutBtn() {
		return checkOutBtn;
	}

	public void setCheckOutBtn(JButton checkOutBtn) {
		this.checkOutBtn = checkOutBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	public JButton getUseBtn() {
		return useBtn;
	}

	public void setUseBtn(JButton useBtn) {
		this.useBtn = useBtn;
	}

	public JButton getLogOutBtn() {
		return logOutBtn;
	}

	public void setLogOutBtn(JButton logOutBtn) {
		this.logOutBtn = logOutBtn;
	}

	public JButton getRemoveBtn() {
		return removeBtn;
	}

	public void setRemoveBtn(JButton removeBtn) {
		this.removeBtn = removeBtn;
	}

	public JLabel getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(JLabel totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
