package ${package}.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import ${package}.places.ContactPlace;
import ${package}.places.HomePlace;
import ${package}.places.UsersPlace;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.elemental.Function;
import com.vaadin.polymer.elemental.Promise;
import com.vaadin.polymer.iron.IronAjaxElement;
import com.vaadin.polymer.iron.IronPagesElement;
import com.vaadin.polymer.iron.IronRequestElement;
import com.vaadin.polymer.paper.PaperDrawerPanelElement;
import com.vaadin.polymer.paper.PaperMenuElement;

public class MainPage extends Composite {	
	
	@UiField
    PaperMenuElement  paperMenu;
	@UiField
    AnchorElement homeLink;
	@UiField
    AnchorElement usersLink;
	@UiField
    AnchorElement contactLink;
	@UiField
	AnchorElement logoutLink;
	@UiField
	IronPagesElement ironPages;

	
	String accessToken = null;

	
	private static MainPageUiBinder uiBinder = GWT
			.create(MainPageUiBinder.class);

	interface MainPageUiBinder extends UiBinder<Element, MainPage> {
	}

	public MainPage() {
		setElement(uiBinder.createAndBindUi(this));
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "/user");
		
		Polymer.endLoading(this.getElement(), (Element) paperMenu);
	}
	
	
	public void initializeEvents(PlaceController controller){
		 Event.sinkEvents(usersLink, Event.ONCLICK);
		 Event.sinkEvents(homeLink, Event.ONCLICK);
		 Event.sinkEvents(contactLink, Event.ONCLICK);
		 Event.sinkEvents(logoutLink, Event.ONCLICK);
		 
		 Event.setEventListener(contactLink, e -> {
	            if(Event.ONCLICK == e.getTypeInt()) {
	           	 ironPages.select("contact");
	           	 paperMenu.select("contact");
		           	controller.goTo(new ContactPlace("contact"));
		           	slideDrawerIfMobile();

	            }  
	        });
		 
		 Event.setEventListener(homeLink, e -> {
	            if(Event.ONCLICK == e.getTypeInt()) {
	            	ironPages.select("home");
	            	paperMenu.select("home");
	           	controller.goTo(new HomePlace("home"));
	           	slideDrawerIfMobile();
	            }  
	        });
		 
		 Event.setEventListener(usersLink, e -> {
            if(Event.ONCLICK == e.getTypeInt()) {
           	 ironPages.select("users");
           	 paperMenu.select("users");
           	       controller.goTo(new UsersPlace("users"));
           	    slideDrawerIfMobile();
           	    
            }  
   });
		 
		 
		 Event.setEventListener(logoutLink, e -> {
	            if(Event.ONCLICK == e.getTypeInt()) {
	            	RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, "/logout");
	            	String crsfCookie = Cookies.getCookie("XSRF-TOKEN");
	            	if(crsfCookie != null)
	            	    builder.setHeader("X-XSRF-TOKEN", crsfCookie);
	        		
	        		try {
	        			  Request request = builder.sendRequest(null, new RequestCallback() {
	        			    public void onError(Request request, Throwable exception) {
	        			      
	        			    }

	        			    public void onResponseReceived(Request request, Response response) {
	        			    	Window.Location.replace("/login");
	        			    }
	        			  });
	        			} catch (RequestException exp) {
	        			}
	            	
	            	
	            
	            }  
	   });
		 
		 
	}
	
	
	public AnchorElement getContactLink(){
		return contactLink;
	}
	
	public AnchorElement getHomeLink(){
		return homeLink;
	}
	
	public AnchorElement getUsersLink(){
		return usersLink;
		
	}
	
	public PaperMenuElement getPaperMenu(){
		return paperMenu;
	}
	
	public IronPagesElement getIronPagesElement(){
		return ironPages;
	}
	
	public interface Presenter {
		//handles clicking on back and forward buttons of the browser
		public void placeChangeWithoutClickEvent(String placeName);
	}
	
	private void slideDrawerIfMobile(){
		if( Window.getClientWidth() < 600 ){
			PaperDrawerPanelElement drawer = (PaperDrawerPanelElement) Polymer.getDocument().getElementById("paperDrawerPanel");
			drawer.closeDrawer();
		}
		
	}

}
