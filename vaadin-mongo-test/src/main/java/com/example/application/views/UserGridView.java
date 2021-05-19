package com.example.application.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.application.data.document.UserDocument;
import com.example.application.service.UserService;
import com.example.application.views.mainviews.GridView;
import com.example.application.views.mainviews.MainTemplate1View;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@Route(value = "userGrid", layout = GridView.class)
@PageTitle("User Grid")
@Tag("user-grid-view")
@JsModule("./views/usergrid/user-grid-view.ts")
public class UserGridView extends LitTemplate {

	@Autowired
	private UserService userservice;

	@Id
	private TextField username;
	@Id
	private PasswordField password;
	@Id
	private TextField name;
	@Id
	private IntegerField eta;

	@Id
	private Button aggiungiUtente;

	Binder<UserDocument> userBinder = new Binder<>();
	
	@PostConstruct
	public void init(){
		/*try {
			GridView.populateGrid(userservice.getAll());
		} catch (NullPointerException e) {
			Notification.show("NullPointerException");
		}*/
		userBinder.forField(username).bind(UserDocument::getUsername, UserDocument::setUsername);
		userBinder.forField(password).bind(UserDocument::getPassword, UserDocument::setPassword);
		userBinder.forField(eta).bind(UserDocument::getEta, UserDocument::setEta);
		aggiungiUtente.addClickListener(click -> {
			/*if (username.getValue().equals("") || password.getValue().equals("") || name.getValue().equals("") || eta.getValue() == null){
				Notification.show("Insert all values", 1500, Position.MIDDLE);
				return;
			}*/
			try {

				//userBinder.validate();
			} catch (Exception e) {
				Notification.show("Errore sopraggiunto", 2500, Position.MIDDLE);
			}
			userservice.add(userBinder.getBean());
			Notification.show("Utente Aggiunto", 2500, Position.MIDDLE);
			clearForm();
			GridView.populateGrid(userservice.getAll());
		});
	}

	/*private void getElements() {
		System.out.println("Try to get Elements");
		userGrid.addColumn(UserDocument::getUsername);
		userGrid.addColumn(UserDocument::getNome);
		userGrid.addColumn(UserDocument::getEta);
		userGrid.setItems(userservice.getAll());
	}*/
	
	private void clearForm() {
       /* username.setValue("");
        password.setValue("");
        name.setValue("");
        eta.setValue(null);*/
		userBinder.removeBean();
    }

}
