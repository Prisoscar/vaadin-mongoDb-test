package com.example.application.views.mainviews;

import java.util.List;

import com.example.application.data.document.UserDocument;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;

public class GridView extends MainTemplate1View {

	private static Grid<UserDocument> userGrid = new Grid<>();

	public GridView() {
		super();
		headerPlusBodyLayout.addComponentAtIndex(1, userGrid);
		userGrid.setId("userGrid");
		headerPlusBodyLayout.addComponentAtIndex(1, new H3("User Grid"));
		initializeGrid();
	}

	private void initializeGrid() {
		userGrid.removeAllColumns();
		userGrid.addColumn(UserDocument::getUsername).setHeader("username");
		userGrid.addColumn(UserDocument::getNome).setHeader("name");
		userGrid.addColumn(UserDocument::getEta).setHeader("età");
	}

	public static void populateGrid(List<UserDocument> userList) {
		userGrid.setItems(userList);
	}
}
