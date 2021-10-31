package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;

public class Position {
	private int positionID;
	private String name;
	
	public Position() {
		
	}
	
	public Position(int positionID, String name) {
		super();
		this.positionID = positionID;
		this.name = name;
	}
	
	public ArrayList<Position> getAllPositions() {
		ArrayList<Position> positions = new ArrayList<Position>();
		String query = "SELECT * FROM position";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				positions.add(new Position(
						rs.getInt("positionID"),
						rs.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return positions;
	}
	
	public Position getPosition(int positionID) {
		Position p = null;
		String query = "SELECT * FROM position WHERE position = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			p = new Position(
					rs.getInt("positionID"),
					rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
