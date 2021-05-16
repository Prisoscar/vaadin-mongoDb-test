package com.example.application.views.helloworld;

import com.example.application.views.mainviews.MainTemplate1View;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 * A Designer generated component for the stub-tag template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Route(value = "hello", layout = MainTemplate1View.class)
@RouteAlias(value = "", layout = MainTemplate1View.class)
@PageTitle("Hello Word")
@Tag("hello-world-view")
@JsModule("./views/helloworld/hello-world-view.ts")
public class HelloWorldView extends LitTemplate {

    @Id
    private TextField name;

    @Id
    private Button sayHello;

    public HelloWorldView() {
        //super();
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }
}
