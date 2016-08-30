package ${package}.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import ${package}.ui.AppElement;

public class ClientFactoryImpl implements ClientFactory {
	
	
	EventBus eventBus = new SimpleEventBus();
	PlaceController controller = new PlaceController(eventBus);
	AppElement mainPage = new AppElement();

	
	@Override
	public AppElement getMainPageView() {
		return mainPage;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return controller;
	}

}
