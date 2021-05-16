package com.example.application.views.mainviews;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

import java.util.Objects;

/**
 * A Designer generated component for the stub-tag template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
public class MainTemplate1View extends Composite<Div> implements RouterLayout {

    //https://vaadin.com/learn/tutorials/nested-layouts-in-flow
    private Div content = new Div();

    private final VerticalLayout layout = new VerticalLayout(
            createHeader(),
            content ,
            createFooter()
    );

    public MainTemplate1View() {
        /*add(createHeader());
        add(createLayoutInnerPage());
        add(createFooter());*/
        /*sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });*/
        layout.setPadding(false);
        layout.setHeightFull();
        layout.setId("mainLayout");
        content.setId("contentDiv");
        getContent().add(layout);
        getContent().add(createSubFooter());

    }

    private Component createSubFooter() {
        VerticalLayout subFooter = new VerticalLayout();
        subFooter.getThemeList().set("dark", true);
        subFooter.setId("subFooterDiv");
        return subFooter;
    }

    @Override
    public void showRouterLayoutContent(HasElement hasElement) {
        //System.out.println("showRouterLayoutContent - MainLayout");
        Objects.requireNonNull(hasElement);
        Objects.requireNonNull(hasElement.getElement());
        content.removeAll();
        content.getElement().appendChild(hasElement.getElement());
    }

    private Component createFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        //Footer footer = new Footer();
        footer.setId("footer");
        footer.setSizeFull();
        footer.getThemeList().set("dark", true);
        footer.setWidthFull();
        footer.setAlignItems(FlexComponent.Alignment.CENTER);
        footer.add(new Paragraph("P.Iva: 00000000000"));
        return footer;
    }

    private Component createHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setId("header");
        header.setSizeFull();
        header.getThemeList().set("dark", true);
        header.setWidthFull();
        header.setSpacing(false);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.add(new H1("Test UI"));
        return header;
    }
}
