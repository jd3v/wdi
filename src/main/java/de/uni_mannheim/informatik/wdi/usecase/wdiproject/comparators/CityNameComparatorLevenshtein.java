package de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators;

import de.uni_mannheim.informatik.wdi.identityresolution.matching.Comparator;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.string.*;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.City;

/**
 * Created by Daniel on 17/11/15.
 */
public class CityNameComparatorLevenshtein extends Comparator<City> {

	private LevenshteinSimilarity sim = new LevenshteinSimilarity();

	@Override
	public double compare(City one, City two) {
		double similarity = sim.calculate(one.getName(), two.getName());
		return similarity;
	}
	
}
