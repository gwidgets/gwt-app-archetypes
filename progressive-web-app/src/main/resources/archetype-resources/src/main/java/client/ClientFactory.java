package ${package}.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import ${package}.ui.AppElement;



public interface ClientFactory {
     AppElement getMainPageView();
     EventBus getEventBus();
     PlaceController getPlaceController();
}
