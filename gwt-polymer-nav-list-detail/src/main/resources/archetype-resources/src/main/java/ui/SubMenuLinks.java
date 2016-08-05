package ${package}.ui;


import java.util.ArrayList;
import java.util.List;

import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.paper.PaperItemElement;

public class SubMenuLinks {

	public static List<PaperItemElement> getLinks(String parentMenuName) {
		
		List<PaperItemElement> linksList = new ArrayList<PaperItemElement>();

		switch (parentMenuName) {
		case "home":

			PaperItemElement subHome1 = Polymer.getDocument().createElement(PaperItemElement.TAG);
			subHome1.setTextContent("Home Sub Menu 1");
			subHome1.setAttribute("id", "home_sub1");

			PaperItemElement subHome2 = Polymer.getDocument().createElement(PaperItemElement.TAG);
			subHome2.setTextContent("Home Sub Menu 2");
			subHome2.setAttribute("id", "home_sub2");
			
			linksList.add(subHome1);
			linksList.add(subHome2);

			break;
		case "users":

			PaperItemElement subUsers1 = Polymer.getDocument().createElement(PaperItemElement.TAG);
			subUsers1.setTextContent("Users Sub Menu 1");
			subUsers1.setAttribute("id", "users_sub1");

			PaperItemElement subUsers2 = Polymer.getDocument().createElement(PaperItemElement.TAG);
			subUsers2.setTextContent("Users Sub Menu 2");
			subUsers2.setAttribute("id", "users_sub2");
			
			linksList.add(subUsers1);
			linksList.add(subUsers2);

			break;
		case "contact":

			PaperItemElement subContact1 = Polymer.getDocument().createElement(PaperItemElement.TAG);
			subContact1.setTextContent("Contact Sub Menu 1");
			subContact1.setAttribute("id", "contact_sub1");

			PaperItemElement subContact2 = Polymer.getDocument().createElement(PaperItemElement.TAG);
			subContact2.setTextContent("Contact Sub Menu 2");
			subContact2.setAttribute("id", "contact_sub2");
			
			linksList.add(subContact1);
			linksList.add(subContact2);

			break;
		}

		return linksList;
	}

}
