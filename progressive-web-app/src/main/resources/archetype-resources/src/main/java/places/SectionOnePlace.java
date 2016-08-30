package ${package}.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SectionOnePlace extends Place{
	
	private String name;

	public SectionOnePlace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Prefix("")
	 public static class Tokenizer implements PlaceTokenizer<SectionOnePlace> {
	        @Override
	        public String getToken(SectionOnePlace place) {
	            return place.getName();
	        }

	        @Override
	        public SectionOnePlace getPlace(String token) {
	            return new SectionOnePlace(token);
	        }
	    }

}
