package ${package}.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import ${package}.client.ClientFactory;
import ${package}.places.SectionTwoPlace;
import ${package}.places.SectionOnePlace;
import ${package}.places.SectionThreePlace;
import ${package}.ui.AppElement;
import ${package}.ui.SelectionManager;

public class MainPageActivity extends AbstractActivity {

	AppElement mainPage;
	PlaceController controller;
	Place currentPlace;

	public MainPageActivity(ClientFactory factory, Place place) {
		this.mainPage = factory.getMainPageView();
		this.controller = factory.getPlaceController();
		this.currentPlace = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus bus) {
		// panel.setWidget(mainPage);
	}

	public void refreshPlace(Place place) {
		this.currentPlace = place;

		if (place instanceof SectionOnePlace) {
			placeChangeWithoutClickEvent("section1");
		} else if (place instanceof SectionTwoPlace) {
			placeChangeWithoutClickEvent("section2");
		} else if (place instanceof SectionThreePlace) {
			placeChangeWithoutClickEvent("section3");
		}

	}

	public void placeChangeWithoutClickEvent(String placeName) {
		// TODO Auto-generated method stub
		mainPage.getIronPages().select(placeName);
		SelectionManager.getSelectedElement().removeAttribute("class");

		switch (placeName) {

		case "section1":
			mainPage.getSection1Button().setAttribute("class", "selected");
			SelectionManager.select(AppElement.SECTION1_BUTTON_ID);
			break;
		case "section2":
			mainPage.getSection2Button().setAttribute("class", "selected");
			SelectionManager.select(AppElement.SECTION2_BUTTON_ID);
			break;
		case "section3":
			mainPage.getSection3Button().setAttribute("class", "selected");
			SelectionManager.select(AppElement.SECTION3_BUTTON_ID);
			break;
		}

	}

}
