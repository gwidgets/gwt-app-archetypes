package ${package}.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import ${package}.places.*;
import com.vaadin.polymer.Polymer;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.iron.IronPagesElement;
import com.vaadin.polymer.paper.PaperDrawerPanelElement;
import com.vaadin.polymer.paper.PaperMenuElement;
import com.vaadin.polymer.paper.widget.PaperMenu;

public class MainPage extends Composite {

	@UiField
	PaperMenuElement menu;

	@UiField
	PaperMenuElement subMenu;

	@UiField
	PaperDrawerPanelElement mainDrawer;

	@UiField
	IronPagesElement ironPages;

	@UiField
	AnchorElement homeLink;

	@UiField
	AnchorElement usersLink;

	@UiField
	AnchorElement contactLink;

	private static MainPageUiBinder uiBinder = GWT.create(MainPageUiBinder.class);

	interface MainPageUiBinder extends UiBinder<Widget, MainPage> {
	}

	public MainPage() {
		initWidget(uiBinder.createAndBindUi(this));
		mainDrawer.setForceNarrow(true);
	}

	public void initializeEvents(PlaceController controller) {
		Event.sinkEvents(usersLink, Event.ONCLICK);
		Event.sinkEvents(homeLink, Event.ONCLICK);
		Event.sinkEvents(contactLink, Event.ONCLICK);

		// go to home page on launch
		controller.goTo(new HomePlace("home"));
		// add home page sub menu's links
		SubMenuLinks.getLinks("home").forEach(m -> {
			subMenu.appendChild(m);

			String id = m.getAttribute("id");

			m.addEventListener("click", l -> {
				ironPages.select(id);
			});
		});

		// select home sub section 1 on launch
		//ironPages.select("home_sub1");

		Event.setEventListener(contactLink, e -> {
			if (Event.ONCLICK == e.getTypeInt()) {
				ironPages.select("contact_sub1");
				menu.select("contact");
				controller.goTo(new ContactPlace("contact_sub1"));

				removeChildren(subMenu);

				SubMenuLinks.getLinks("contact").forEach(m -> {

					String id = m.getAttribute("id");

					m.addEventListener("click", l -> {
						ironPages.select(id);
						menu.select("contact");
						controller.goTo(new ContactPlace(id));
					});

					subMenu.appendChild(m);
				});

			}
		});

		Event.setEventListener(homeLink, e -> {
			if (Event.ONCLICK == e.getTypeInt()) {
				ironPages.select("home_sub1");
				menu.select("home");
				controller.goTo(new HomePlace("home_sub1"));

				removeChildren(subMenu);

				SubMenuLinks.getLinks("home").forEach(m -> {
					String id = m.getAttribute("id");

					m.addEventListener("click", l -> {
						ironPages.select(id);
						menu.select("home");
						controller.goTo(new HomePlace(id));

					});

					subMenu.appendChild(m);
				});
			}
		});

		Event.setEventListener(usersLink, e -> {
			if (Event.ONCLICK == e.getTypeInt()) {
				ironPages.select("users_sub1");
				menu.select("users");
				controller.goTo(new UsersPlace("users_sub1"));

				removeChildren(subMenu);

				SubMenuLinks.getLinks("users").forEach(m -> {
					String id = m.getAttribute("id");

					m.addEventListener("click", l -> {
						ironPages.select(id);
						menu.select("users");
						controller.goTo(new UsersPlace(id));
					});
					subMenu.appendChild(m);

				});

			}
		});

	}

	public IronPagesElement getIronPagesElement() {

		return ironPages;
	}

	public PaperMenuElement getPaperMenu() {

		return menu;
	}

	public interface Presenter {
		// handles clicking on back and forward buttons of the browser
		public void placeChangeWithoutClickEvent(String placeName);
	}

	private void removeChildren(PaperMenuElement menu) {
		Element element = (Element) menu;
		element.removeAllChildren();
	}

}
