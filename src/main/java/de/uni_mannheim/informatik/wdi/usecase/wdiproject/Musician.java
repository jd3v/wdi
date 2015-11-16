package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.Record;
import org.joda.time.DateTime;

/**
 * Created by Mats on 15/11/15.
 */
public class Musician extends Record {

    private String firstName;
    private String lastName;
    private DateTime birthDate;
    private String birthPlace;

    private String instrument;
    private String background;
    private String genre;
    private String associatedBand;

    public Musician(String identifier, String provenance) {
        super(identifier, provenance);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAssociatedBand() {
        return associatedBand;
    }

    public void setAssociatedBand(String associatedBand) {
        this.associatedBand = associatedBand;
    }
}
