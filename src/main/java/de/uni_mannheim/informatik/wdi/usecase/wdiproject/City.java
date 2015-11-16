package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.Record;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mats on 15/11/15.
 */
public class City extends Record {

    private String name;
    private String cc;
    private int population;
    private double lat;
    private double lon;
    private List<Musician> musicians;

    public City(String identifier, String provenance) {
        super(identifier, provenance);
        musicians = new LinkedList<>();
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Musician> musicians) {
        this.musicians = musicians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
