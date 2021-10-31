package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Transaction;
import model.TransactionItem;
import view.ManagerView;
import view.TransactionDetailView;

public class TransactionDetailController {
	
	private TransactionDetailView view;
	private TransactionItem model;
	
	 
	 public TransactionDetailController (TransactionDetailView view, TransactionItem model) {
		 super();
		 this.view=view;
		 this.model = model;
	 }
	 
	 public TransactionDetailController(){
		 
	 }
	 
	 public void showListTransactionItem (ArrayList<TransactionItem> transactions) {
		 DefaultTableModel listTransactionItemTable = (DefaultTableModel) view.getModel();
			
			listTransactionItemTable.setRowCount(0);
			
			for (int i = 0; i < transactions.size(); i++) {
				TransactionItem ti = transactions.get(i);
				listTransactionItemTable.addRow(new Object[] {ti.getTransactionID(), ti.getProductID(),ti.getQuantity()});
			}
	 }
	 
	 public void getAllTransactionItem() {
		ArrayList<TransactionItem> transactions = model.getAllTransactionItem();
		showListTransactionItem(transactions);
	 }
	 
	 public static void getFrame() {
			new TransactionDetailView ();
		}
	
}
