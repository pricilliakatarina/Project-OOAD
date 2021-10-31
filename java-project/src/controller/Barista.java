package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.CartHandler;
import model.Product;
import model.Voucher;
import view.BaristaView;
import view.CartForm;
import view.LoginForm;

public class Barista {
	
	private CartForm viewCart;
	private Login loginView;
	private BaristaView view;
	private Voucher vModel = new Voucher(0, null, 0);
	private Product model = new Product();
	ArrayList<CartHandler> cart = new ArrayList<CartHandler>();
	
	public Barista(BaristaView view, Product model) {
		super();
		this.view = view;
		this.model = model;
	}
	
	public void showListProduct(ArrayList<Product> products) {
		DefaultTableModel listProductTable = (DefaultTableModel) view.getModel();
		
		listProductTable.setRowCount(0);
		
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			listProductTable.addRow(new Object[] {p.getID(), p.getName(), p.getDescription(), p.getPrice(), p.getStock()});
		}
		
	}

	public void getAllProduct() {
		ArrayList<Product> products = model.getAllProducts();
		showListProduct(products);
	}
	
	public void addToCart(int id, int qty) {
		Product p = null;
		p = model.getProduct(id);
		int price = 0, quantity = qty;
		if (p != null) {
			if (p.getStock() == 0) {
				JOptionPane.showMessageDialog(null, "Out of Stock.");
			}else if (qty > p.getStock()) {
				JOptionPane.showMessageDialog(null ,"Not Enough Stock.");
			} else {
				price = p.getPrice() * qty;
				cart.add(new CartHandler(p.getID(), quantity, price, p.getName()));
				JOptionPane.showMessageDialog(null ,"Success At to Cart.");
			}						
		} else {
			JOptionPane.showMessageDialog(null , "Product not Found");
		}
	}
	
//	public void refreshData() {
//		cart = getCart();
//		DefaultTableModel cartModel = (DefaultTableModel) viewCart.getModel();
//		
//		for (CartHandler ch : cart) {
//			cartModel.addRow(new Object[] {ch.getiD(), ch.getName(), ch.getQuantity(), ch.getPrice()});
//		}
//	}
//	
//	public void updateTotalPrice() {
//		cart = getCart();
//		int totalPrices = 0;
//		for (CartHandler cartHandler : cart) {
//			totalPrices += cartHandler.getPrice();
//		}
//		viewCart.getTotalPrice().setText(String.valueOf(totalPrices));
//		
//	}
//	
	public void useVoucher(int id) {
		Voucher v = vModel.getVoucher(id);
		int discount = v.getDiscount();
	}

	
	public void clearCart() {
		cart.clear();
	}
	
	public void updateProduct() {
		
	}
	
	 public static void baristaView() {
		 new BaristaView();
	 }
	 
	 public static void viewCart(Barista controller) {
		 new CartForm(controller);
	 }
	 
	 public static void loginView() {
		 new LoginForm();
	 }

	public ArrayList<CartHandler> getCart() {
		return cart;
	}

	public void setCart(ArrayList<CartHandler> cart) {
		this.cart = cart;
	}
	 
}
