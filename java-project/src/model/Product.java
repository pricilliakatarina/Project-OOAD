package model;

import java.io.ObjectInputStream.GetField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class Product {
	
	private String name, description;
	private int ID, price, stock;
	
	public Product(int iD, String name, String description, int price, int stock) {
		super();
		ID = iD;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}
	
	public Product() {
		
	}
	
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "SELECT * FROM product";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				products.add(new Product(
						rs.getInt("productID"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("stock")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return products;
	}
	
	public Product getProduct(int productID) {
		Product p = null;
		String query = "SELECT * FROM product WHERE productID = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new Product(
						rs.getInt("productID"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("stock"));								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public Product insertNewProduct(String name, String description, int price, int stock) {
		String query = "INSERT INTO product (name, description, price, stock) VALUES ?, ?, ?, ?";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setInt(3, price);
			ps.setInt(4, stock);
			ps.executeUpdate();
			return this;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Product updateProduct(int ID, String name, String description, int price, int stock) {
		String query = "UPDATE product SET name = ?,"
				+ "description = ?, price = ?, stock = ? WHERE productID = ?";
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setInt(3, price);
			ps.setInt(4, stock);
			ps.setInt(5, ID);
			ps.executeUpdate();
			return this;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public boolean deleteProduct(int ID) {
		String query = "DELETE FROM product WHERE productID = ?";
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
