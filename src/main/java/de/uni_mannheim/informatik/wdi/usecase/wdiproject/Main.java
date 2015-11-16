package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.DataSet;
import de.uni_mannheim.informatik.wdi.identityresolution.matching.LinearCombinationMatchingRule;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators.PopulationComparator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by Mats on 15/11/15.
 */
public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {

        // define the matching rule
        LinearCombinationMatchingRule<City> rule = new LinearCombinationMatchingRule<>(
                -1.497, 0.5);
        rule.addComparator(new PopulationComparator(), 1);

        // create the matching engine
        //Blocker<City> blocker = new PartitioningBlocker<>(new CityBlockingFunction());
        //MatchingEngine<City> engine = new MatchingEngine<>(rule, blocker);

        // load the data sets
        DataSet<City> geonames = new DataSet<>();
        DataSet<City> maxmind = new DataSet<>();
        DataSet<City> dbpCity = new DataSet<>();
//        geonames.loadFromXML(
//                new File("usecase/movie/input/academy_awards.xml"),
//                new CityFactory(), "/movies/movie");
//        maxmind.loadFromXML(
//                new File("usecase/movie/input/actors.xml"),
//                new CityFactory(), "/movies/movie");
//        dbpCity.loadFromXML(
//                new File("usecase/movie/input/actors.xml"),
//                new CityFactory(), "/movies/movie");

    }
}
