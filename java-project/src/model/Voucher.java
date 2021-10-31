package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class Voucher {
	private String status;
	private int ID, discount;
	
	public Voucher(int iD, String status, int discount) {
		super();
		ID = iD;
		this.status = status;
		this.discount = discount;
	}
	
	public ArrayList<Voucher> getAllVouchers() {
		ArrayList<Voucher> vouchers = new ArrayList<Voucher>();
		String query = "SELECT * FROM voucher";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vouchers.add(new Voucher(
						rs.getInt("voucherID"),
						rs.getString("status"),
						rs.getInt("discount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return vouchers;
	}
	
	public Voucher generateVoucher() {
		return null;
	}
	
	public boolean insertVoucher(int discount, String status) {
		String query = "INSERT INTO voucher (discount, status) VALUES(?, ?)";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setInt(1, discount);
			ps.setString(2, status);
			
			return ps.executeUpdate() == 1;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Voucher getVoucher(int ID) {
		Voucher v = null;
		String query = "SELECT * FROM product WHERE productID = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setInt(1, ID);
			rs = ps.executeQuery();
			while (rs.next()) {
				v = new Voucher(
						rs.getInt("voucherID"),
						rs.getString("status"),
						rs.getInt("discount"));								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
	public boolean deleteVoucher(int ID) {
		String query = "DELETE FROM voucher WHERE voucherID = ?";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setInt(1, ID);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
