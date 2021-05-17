package com.example.application.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.application.data.document.UserDocument;
import com.example.application.service.UserService;
import com.example.application.views.mainviews.MainTemplate1View;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.Converter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the user-grid-view template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Route(value = "userGrid", layout = MainTemplate1View.class)
@PageTitle("User Grid")
@Tag("user-grid-view")
@JsModule("./views/usergrid/user-grid-view.ts")
public class UserGridView extends LitTemplate {

	@Autowired
	UserService userservice;

	@Id
	private Grid<UserDocument> userGrid = new Grid<>(UserDocument.class);

	@Id
	private TextField username;
	@Id
	private PasswordField password;
	@Id
	private TextField name;
	@Id
	private TextField eta;

	@Id
	private Button aggiungiUtente;

	private Binder<UserDocument> binder = new Binder(UserDocument.class);

	public UserGridView() {
		try {
			getElements();
		} catch (NullPointerException e) {
			Notification.show("NullPointerException");
		}
		clearForm();
		System.out.println(binder.toString());
		aggiungiUtente.addClickListener(click -> {
			try {
			Integer.valueOf(eta.toString());
			}catch (Exception e) {
				Notification.show("Invalid Age");
				return;
			}
			binder.forField(username)
			.withValidator(username -> username.toString().length() < 3, "Username should be longer than 3")
			.bind(UserDocument::getUsername, UserDocument::setUsername);
			binder.forField(password)
			.withValidator(password -> password.toString().length() < 3, "Password should be longer than 3")
			.bind(UserDocument::getPassword, UserDocument::setPassword);
			binder.forField(name)
			.withValidator(name -> name.toString().length() < 3, "Name should be longer than 3")
			.bind(UserDocument::getNome, UserDocument::setNome);
			binder.forField(eta)
			.withConverter(new StringToIntegerConverter("Invalid age conversion"))
			.withValidator(eta -> eta < 10 || eta > 100, "Age should be greater than 10 and smaller than 100")
			.bind(UserDocument::getEta, UserDocument::setEta);
			userservice.add(binder.getBean());
			Notification.show(String.valueOf(binder.getBean().getEta()));
			Notification.show("Utente Aggiunto", 2500, Position.MIDDLE);
			getElements();
		});
	}

	private void getElements() {
		System.out.println("Try to get Elements");
		System.out.println(userservice.getAll());
		userGrid.addColumn(UserDocument::getUsername);
		userGrid.addColumn(UserDocument::getNome);
		userGrid.addColumn(UserDocument::getEta);
		userGrid.setItems(userservice.getAll());
	}
	
	private void clearForm() {
        binder.setBean(new UserDocument());
    }

}
