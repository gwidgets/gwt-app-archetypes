package ${package}.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UsersPlace extends Place{
	

	private String name;

	public UsersPlace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	 public static class Tokenizer implements PlaceTokenizer<UsersPlace> {
	        @Override
	        public String getToken(UsersPlace place) {
	            return place.getName();
	        }

	        @Override
	        public UsersPlace getPlace(String token) {
	            return new UsersPlace(token);
	        }
	    }

}
