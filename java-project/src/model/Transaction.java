package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class Transaction {
	private int transactionID, voucherID, employeeID, totalPrice;
	private Date purchaseDate;
	
	public Transaction(int transactionID, int voucherID, int employeeID, int totalPrice, Date purchaseDate) {
		super();
		this.transactionID = transactionID;
		this.voucherID = voucherID;
		this.employeeID = employeeID;
		this.totalPrice = totalPrice;
		this.purchaseDate = purchaseDate;
	}
	
	public ArrayList<Transaction> getAllTransactions() {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		String query = "SELECT * FROM transaction";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				transactions.add(new Transaction(
						rs.getInt("transactionID"),
						rs.getInt("voucherID"),
						rs.getInt("employeeID"),
						rs.getInt("totalPrice"),
						rs.getDate("purchaseDate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return transactions;
	}
	
	public Transaction insertTransaction() {
		String query = "INSERT INTO transaction VALUES(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setInt(1,  transactionID);
			ps.setInt(2, voucherID);
			ps.setInt(3, employeeID);
			ps.setInt(4, totalPrice);
			ps.setDate(5, purchaseDate);
			
			return this;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Transaction getTransactionDetail(int transactionID) {
		Transaction t = null;
		String query = "SELECT * FROM transaction WHERE transactionID = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			t = new Transaction(
					rs.getInt("transactionID"),
					rs.getInt("voucherID"),
					rs.getInt("employeeID"),
					rs.getInt("totalPrice"),
					rs.getDate("purchaseDate"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;		
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getVoucherID() {
		return voucherID;
	}

	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	
}
