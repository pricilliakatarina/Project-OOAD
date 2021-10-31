package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Product;
import model.Voucher;
import view.ProductManagementForm;

public class ProductHandler {

	ProductManagementForm view;
	Product model;
	Voucher vModel;
	ArrayList<Voucher> vouchers = new ArrayList<Voucher>();
	
	public ProductHandler(ProductManagementForm view, Product model) {
		super();
		this.view = view;
		this.model = model;
	}
	
	public ProductHandler(ProductManagementForm view, Voucher vModel) {
		super();
		this.view = view;
		this.vModel = vModel;
	}
	
	public void insertProduct() {
		model.insertNewProduct(view.getProductNameField().getText(), view.getDescriptionField().getText(), Integer.parseInt(view.getPriceField().getText()), Integer.parseInt(view.getPriceField().getText()));
		getAllProduct();
	}
	
	public void deleteProduct() {
		model.deleteProduct(Integer.parseInt(view.getProductIDField().getText()));
		getAllProduct();
	}
	
	public void updateProduct() {
		model.updateProduct(Integer.parseInt(view.getProductIDField().getText()), view.getProductNameField().getText(), view.getDescriptionField().getText(), Integer.parseInt(view.getPriceField().getText()), Integer.parseInt(view.getStockField().getText()));
		getAllProduct();
	}
	
	public void insertVoucher() {
		vModel.insertVoucher(Integer.parseInt(view.getDiscountField().getText()), view.getStatusField().getText());
		getAllVoucher();
	}
	
	
	public void deleteVoucher() {
		vModel.deleteVoucher(Integer.parseInt(view.getVoucherIDField().getText()));
		getAllVoucher();
	}
	
	public void showListVoucher(ArrayList<Voucher> vouchers) {
		DefaultTableModel voucherTable = (DefaultTableModel) view.getModel1();
		
		voucherTable.setRowCount(0);
		
		for (int i = 0; i < vouchers.size(); i++) {
			Voucher v = vouchers.get(i);
			voucherTable.addRow(new Object[] {v.getID(), v.getDiscount(), v.getStatus()});
		}
	}
	
	public void getAllVoucher() {
		vouchers = vModel.getAllVouchers();
		showListVoucher(vouchers);
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
}
