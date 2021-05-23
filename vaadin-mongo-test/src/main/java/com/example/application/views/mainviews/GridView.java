package com.example.application.views.mainviews;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

import javax.annotation.PostConstruct;

import com.example.application.data.abstractDocument.AbstractUserDocument;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.application.data.document.UserDocument;
import com.example.application.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

//example: https://vaadin.com/components/vaadin-grid/java-examples/grid-editor
public class GridView extends MainTemplate1View {

	@Autowired
	private UserService userService;

	private static Grid<UserDocument> userGrid = new Grid<>();
	private Editor<UserDocument> editor = userGrid.getEditor();
	private Binder<UserDocument> binder = new Binder<>(UserDocument.class);
	private Grid.Column<UserDocument> usernameColumn;
	private Grid.Column<UserDocument> nameColumn;
	private Grid.Column<UserDocument> ageColumn;
	private Grid.Column<UserDocument> editColumn;
	private Grid.Column<UserDocument> deleteColumn;
	private TextField usernameField = new TextField();
	private TextField nameField = new TextField();
	private IntegerField ageField = new IntegerField();
	private Collection<Button> editButtons = Collections.newSetFromMap(new WeakHashMap<>());
	private Collection<Button> deleteButtons = Collections.newSetFromMap(new WeakHashMap<>());
	
	@PostConstruct
	public void init() {

		populateGrid();
		// set editable fields
		// add grid and header to layout
		headerPlusBodyLayout.addComponentAtIndex(1, userGrid);
		userGrid.setId("userGrid");
		headerPlusBodyLayout.addComponentAtIndex(1, new H3("User Grid"));
		//connect editor to bind and set save button behavior
		editor.setBinder(binder);
		editor.setBuffered(true);
		editor.addSaveListener(event -> {
			if (!binder.isValid()) Notification.show("Invalid input", 2500, Notification.Position.MIDDLE);
				userService.add(event.getItem());
				populateGrid();
		});
		// initialize grid columns
		initializeGrid();
		
		usernameColumn.setEditorComponent(usernameField);
		nameColumn.setEditorComponent(nameField);
		ageColumn.setEditorComponent(ageField);
	}

	private void initializeGrid() {
		userGrid.removeAllColumns();
		usernameColumn = userGrid.addColumn(UserDocument::getUsername).setHeader("username");
		nameColumn = userGrid.addColumn(UserDocument::getNome).setHeader("nome");
		ageColumn = userGrid.addColumn(UserDocument::getEta).setHeader("età");
		editColumn = userGrid.addComponentColumn(user -> createEditButton(user)).setHeader("Actions");
		deleteColumn = userGrid.addComponentColumn(user -> createRemoveButton(user));
		// Inside edit button
		Button save = new Button("Save", e -> editor.save());
		save.addClassName("save");
		Button cancel = new Button("Cancel", e -> editor.cancel());
		cancel.addClassName("cancel");
		// if edit button is pressed
		editor.addOpenListener(e -> editButtons.stream().forEach(button -> button.setEnabled(!editor.isOpen())));
		editor.addCloseListener(e -> editButtons.stream().forEach(button -> button.setEnabled(!editor.isOpen())));

		Div buttons = new Div(save, cancel);
		editColumn.setEditorComponent(buttons);

		binder.forField(usernameField).bind("username"/*UserDocument::getUsername, UserDocument::setUsername*/);
		binder.forField(nameField).bind("nome"/*UserDocument::getNome, UserDocument::setNome*/);
		binder.forField(ageField).bind("eta"/*UserDocument::getEta, UserDocument::setEta*/);
	}

	private Button createEditButton(UserDocument user) {
		Button edit = new Button("Edit");
		edit.addClassName("edit");
		edit.addClickListener(e -> {
			editor.editItem(user);
			usernameField.focus();
		});
		edit.setEnabled(!editor.isOpen());
		editButtons.add(edit);
		return edit;
	}

	private Button createRemoveButton(UserDocument user) {
		Button delete = new Button("Delete");
		delete.setClassName("deleteButton");
		delete.addClickListener(click -> {
			userService.delete(user);
			populateGrid();
		});
		return delete;
	}

	// Accessing from this class
	public void populateGrid() {
		userGrid.setItems(userService.getAll());
	}

	// Accessing from userGridView class
	public static void populateGrid(List<UserDocument> users) {
		userGrid.setItems(users);
	}
}
