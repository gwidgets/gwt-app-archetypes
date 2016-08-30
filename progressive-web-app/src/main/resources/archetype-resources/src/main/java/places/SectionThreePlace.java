package ${package}.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SectionThreePlace extends Place{
	

	private String name;

	public SectionThreePlace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Prefix("�")
	 public static class Tokenizer implements PlaceTokenizer<SectionThreePlace> {
	        @Override
	        public String getToken(SectionThreePlace place) {
	            return place.getName();
	        }

	        @Override
	        public SectionThreePlace getPlace(String token) {
	            return new SectionThreePlace(token);
	        }
	    }

}
