package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class TransactionItem {
	private int transactionID, productID, quantity;

	public TransactionItem(int transactionID, int productID, int quantity) {
		super();
		this.transactionID = transactionID;
		this.productID = productID;
		this.quantity = quantity;
	}
	
	public ArrayList<TransactionItem> getAllTransactionItem() {
		ArrayList<TransactionItem> transactions = new ArrayList<TransactionItem>();
		String query = "SELECT * FROM transactionitem";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				transactions.add(new TransactionItem(
						rs.getInt("transactionID"),
						rs.getInt("productID"),
						rs.getInt("quantity")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return transactions;
		
	}
	
	public TransactionItem insertNewTransactionItem() {
		String query = "INSERT INTO transactionitem VALUES(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setInt(1,  transactionID);
			ps.setInt(2, productID);
			ps.setInt(3, quantity);
			
			return this;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}