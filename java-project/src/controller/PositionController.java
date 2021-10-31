package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Position;
import view.HumanResourceDepartmentView;

public class PositionController {

	private HumanResourceDepartmentView view;
	private Position model;
	 
	 public PositionController(HumanResourceDepartmentView view, Position model) {
		super();
		this.view = view;
		this.model = model;
		 
	 }
	
	 public void ListPosition(ArrayList<Position> positions) {
		DefaultTableModel table_1 = (DefaultTableModel) view.getModelPosition();
			
		table_1.setRowCount(0);
			
		for (int i = 0; i < positions.size(); i++) {
			Position posi = positions.get(i);
			table_1.addRow(new Object[] {posi.getPositionID(), posi.getName()});
		}
	 }
	 
	 public void getAllPositions() {
		 
		 ArrayList<Position> positions = model.getAllPositions();
		 ListPosition(positions);
	 }
	 
	 public static void getFrame() {
		 new HumanResourceDepartmentView();
	 }
}
