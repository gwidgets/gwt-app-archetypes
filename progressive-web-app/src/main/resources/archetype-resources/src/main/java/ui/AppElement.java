package ${package}.ui;

import com.google.gwt.place.shared.PlaceController;
import ${package}.places.SectionOnePlace;
import ${package}.places.SectionThreePlace;
import ${package}.places.SectionTwoPlace;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.iron.IronPagesElement;
import com.vaadin.polymer.paper.PaperButtonElement;

public class AppElement {
	
	
	public static final String SECTION1_BUTTON_ID="section1Button";
	public static final String SECTION2_BUTTON_ID="section2Button";
	public static final String SECTION3_BUTTON_ID="section3Button";
	
	
	private PaperButtonElement section1Button;
	private PaperButtonElement section2Button;
	private PaperButtonElement section3Button;
	private IronPagesElement ironPages;
	
	public AppElement(){
		section1Button = (PaperButtonElement) Polymer.getDocument().getElementById(SECTION1_BUTTON_ID);
		section2Button = (PaperButtonElement) Polymer.getDocument().getElementById(SECTION2_BUTTON_ID);
		section3Button = (PaperButtonElement) Polymer.getDocument().getElementById(SECTION3_BUTTON_ID);
		
		ironPages = (IronPagesElement) Polymer.getDocument().getElementById("ironPages");
		
	}
	
	public void initializeEvents(PlaceController controller){
		
		section1Button.addEventListener("click", (e) -> {
			ironPages.select("section1");
			SelectionManager.getSelectedElement().removeAttribute("class");
			section1Button.setAttribute("class", "selected");
			SelectionManager.select(SECTION1_BUTTON_ID);
			controller.goTo(new SectionOnePlace("section1"));
		});
		
		section2Button.addEventListener("click", (e) -> {
			ironPages.select("section2");
			SelectionManager.getSelectedElement().removeAttribute("class");
			section2Button.setAttribute("class", "selected");
			SelectionManager.select(SECTION2_BUTTON_ID);
			controller.goTo(new SectionTwoPlace("section2"));
		});
		
		section3Button.addEventListener("click", (e) -> {
			ironPages.select("section3");
			SelectionManager.getSelectedElement().removeAttribute("class");
			section3Button.setAttribute("class", "selected");
			SelectionManager.select(SECTION3_BUTTON_ID);
			controller.goTo(new SectionThreePlace("section3"));
		});
	}

	public PaperButtonElement getSection1Button() {
		return this.section1Button;
	}

	public PaperButtonElement getSection2Button() {
		return this.section2Button;
	}

	public PaperButtonElement getSection3Button() {
		return this.section3Button;
	}

	public IronPagesElement getIronPages() {
		return this.ironPages;
	} 

}
