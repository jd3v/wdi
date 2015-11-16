package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.MatchableFactory;
import org.joda.time.DateTime;
import org.w3c.dom.Node;

/**
 * Created by Mats on 15/11/15.
 */
public class MusicianFactory extends MatchableFactory<Musician> {

    @Override
    public Musician createModelFromElement(Node node, String provenanceInfo) {
        String id = getValueFromChildElement(node, "id");

        // create the object with id and provenance information
        Musician musician = new Musician(id, provenanceInfo);

        // fill the attributes
        musician.setFirstName(getValueFromChildElement(node, "firstname"));
        musician.setLastName(getValueFromChildElement(node, "lastname"));

        // convert the date string into a DateTime object
        try {
            String date = getValueFromChildElement(node, "date");
            if(date!=null && !date.isEmpty()) {
                DateTime dt = DateTime.parse(date);
                musician.setBirthDate(dt);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return musician;
    }
}
