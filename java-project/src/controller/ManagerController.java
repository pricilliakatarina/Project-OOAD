package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Transaction;
import view.ManagerView;

public class ManagerController {
	 private ManagerView view;
	 private Transaction model;
	 
	 public ManagerController (ManagerView view, Transaction model) {
		 super();
		 this.view=view;
		 this.model = model;
	 }
	 
	 public ManagerController(){
		 
	 }
	 
	 public void showListTransaction (ArrayList<Transaction> transactions) {
		 DefaultTableModel listTransactionTable = (DefaultTableModel) view.getModel();
			
			listTransactionTable.setRowCount(0);
			
			for (int i = 0; i < transactions.size(); i++) {
				Transaction tc = transactions.get(i);
				listTransactionTable.addRow(new Object[] {tc.getTransactionID(), tc.getPurchaseDate(),tc.getVoucherID(),tc.getEmployeeID(), tc.getTotalPrice()});
			}
	 }
	 
	 public void getAllTransactions() {
		ArrayList<Transaction> transactions = model.getAllTransactions();
		showListTransaction(transactions);
	 }
	 
	 public static void getFrame() {
			new ManagerView();
		}
}
