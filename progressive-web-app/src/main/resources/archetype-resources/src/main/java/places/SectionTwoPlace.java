package ${package}.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class SectionTwoPlace extends Place {
	
	private String name;

	public SectionTwoPlace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Prefix("!")
	 public static class Tokenizer implements PlaceTokenizer<SectionTwoPlace> {
	        @Override
	        public String getToken(SectionTwoPlace place) {
	            return place.getName();
	        }

	        @Override
	        public SectionTwoPlace getPlace(String token) {
	            return new SectionTwoPlace(token);
	        }
	    }
	
	

}
