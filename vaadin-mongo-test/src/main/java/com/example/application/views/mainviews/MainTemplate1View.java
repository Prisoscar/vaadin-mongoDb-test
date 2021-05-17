package com.example.application.views.mainviews;

import com.example.application.views.UserGridView;
import com.example.application.views.about.AboutView;
import com.example.application.views.helloworld.HelloWorldView;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

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
    private Button menuButton = new Button("Menu");
    private boolean visible = true;

    public MainTemplate1View() {
    	System.out.println("Constructor called");
    	VerticalLayout headerPlusBodyLayout = new VerticalLayout(
                createHeader(),
                content
                );
    	headerPlusBodyLayout.setPadding(false);
    	headerPlusBodyLayout.setAlignItems(Alignment.START);
    	HorizontalLayout navMenuPlusHeaderPlusBodyLayout = new HorizontalLayout(
        		createNavigationMenu(),
        		headerPlusBodyLayout
        		);
    	
    	menuButton.addClickListener(click -> {
    		visible = !visible;
    		navMenuPlusHeaderPlusBodyLayout.getComponentAt(0).setVisible(visible);
    	});
    	
    	navMenuPlusHeaderPlusBodyLayout.setPadding(false);
    	navMenuPlusHeaderPlusBodyLayout.setAlignItems(Alignment.START);
    	navMenuPlusHeaderPlusBodyLayout.setId("navMenuPlusHeaderPlusBodyLayout");
        VerticalLayout mainLayout = new VerticalLayout(
        		navMenuPlusHeaderPlusBodyLayout,
        		createFooter()
        		);
        headerPlusBodyLayout.setPadding(false);
        navMenuPlusHeaderPlusBodyLayout.setWidthFull();
        mainLayout.setPadding(false);
        headerPlusBodyLayout.setMinWidth(80, Unit.PERCENTAGE);
        mainLayout.setHeightFull();
        mainLayout.setId("mainLayout");
        content.setId("contentDiv");
        content.setMinHeight(80, Unit.PERCENTAGE);
        getContent().add(mainLayout);
        getContent().add(createSubFooter());

    }

    //add here manually new Routes
    private Component createNavigationMenu() {
		VerticalLayout navMenu = new VerticalLayout();
		navMenu.add(createMenu());
		navMenu.setId("navMenu");
		return navMenu;
	}

	private Component createSubFooter() {
        VerticalLayout subFooter = new VerticalLayout();
        subFooter.getThemeList().set("dark", true);
        subFooter.setId("subFooterDiv");
        subFooter.setPadding(false);
        return subFooter;
    }
	
	private Tab[] createMenu() {
		Tab[] menu = new Tab[] {
				createTab("About", AboutView.class),
				createTab("Hello", HelloWorldView.class),
				createTab("User Grid", UserGridView.class)
		};
		return menu;
	}

    private Tab createTab(String tabName, Class<? extends Component> navigationTarget) {
		Tab tab = new Tab();
		tab.add(new RouterLink(tabName, navigationTarget));
		return tab;
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
        footer.setPadding(false);
        return footer;
    }

    private Component createHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setId("header");
        header.setSizeFull();
        header.getThemeList().set("dark", true);
        header.setWidthFull();
        //header.setSpacing(false);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.add(menuButton);
        header.add(new H1("Test UI"));
        //header.setPadding(false);
        return header;
    }
}
