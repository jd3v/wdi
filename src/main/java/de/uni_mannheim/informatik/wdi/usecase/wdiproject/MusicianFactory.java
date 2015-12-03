package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.MatchableFactory;
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
        musician.setBirthPlace(getValueFromChildElement(node, "name"));
        musician.setAssociatedBand(getValueFromChildElement(node, "associatedBand"));
        musician.setBackground(getValueFromChildElement(node, "background"));
        musician.setGenre(getValueFromChildElement(node, "genre"));
        musician.setInstrument(getValueFromChildElement(node, "instrument"));
//        musician.setBirthDate(getValueFromChildElement(node, "birthDate"));

        return musician;
    }
}
