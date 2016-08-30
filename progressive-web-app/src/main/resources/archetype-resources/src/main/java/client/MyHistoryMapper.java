package ${package}.client;



import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import ${package}.places.*;


@WithTokenizers({SectionTwoPlace.Tokenizer.class, SectionOnePlace.Tokenizer.class, SectionThreePlace.Tokenizer.class})
public interface MyHistoryMapper extends PlaceHistoryMapper  {

}

