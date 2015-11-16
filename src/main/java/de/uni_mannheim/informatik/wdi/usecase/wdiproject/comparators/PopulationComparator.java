package de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators;

import de.uni_mannheim.informatik.wdi.identityresolution.matching.Comparator;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.numeric.PercentageSimilarity;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.City;

/**
 * Created by Mats on 15/11/15.
 */
public class PopulationComparator extends Comparator<City> {

    private PercentageSimilarity sim = new PercentageSimilarity(10);

    @Override
    public double compare(City one, City two) {

        double similarity = sim.calculate(Double.valueOf(one.getPopulation()), Double.valueOf(one.getPopulation()));

        return similarity * similarity;
    }
}
