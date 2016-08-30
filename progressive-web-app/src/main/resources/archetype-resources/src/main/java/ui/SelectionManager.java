package ${package}.ui;

import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.paper.PaperButtonElement;

public class SelectionManager {
	
	private static PaperButtonElement currentSelection = (PaperButtonElement) Polymer.getDocument().getElementById(AppElement.SECTION1_BUTTON_ID);
	
	public static void select(String id){
		
		currentSelection = (PaperButtonElement) Polymer.getDocument().getElementById(id);
	}
	
    public static PaperButtonElement getSelectedElement(){
		
	
	return currentSelection;
	}

}
