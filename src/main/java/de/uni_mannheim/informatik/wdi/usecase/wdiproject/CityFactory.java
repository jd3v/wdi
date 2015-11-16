package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.MatchableFactory;
import org.w3c.dom.Node;

import java.util.List;

/**
 * Created by Mats on 15/11/15.
 */
public class CityFactory extends MatchableFactory<City> {

    @Override
    public City createModelFromElement(Node node, String provenanceInfo) {
        String id = getValueFromChildElement(node, "id");

        // create the object with id and provenance information
        City city = new City(id, provenanceInfo);

        // fill the attributes
        city.setName(getValueFromChildElement(node, "name"));
        city.setCc(getValueFromChildElement(node, "countrycode"));
        city.setLat(Double.valueOf(getValueFromChildElement(node, "lat")));
        city.setLon(Double.valueOf(getValueFromChildElement(node, "lon")));
        city.setPopulation(Integer.valueOf(getValueFromChildElement(node, "population")));

        // load the list of actors
        List<Musician> musicians = getObjectListFromChildElement(node, "musicians", "musician", new MusicianFactory(), provenanceInfo);
        city.setMusicians(musicians);

        return city;
    }
}
