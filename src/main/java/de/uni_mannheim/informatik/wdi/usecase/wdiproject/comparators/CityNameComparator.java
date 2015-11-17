package de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators;

import de.uni_mannheim.informatik.wdi.identityresolution.matching.Comparator;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.string.LevenshteinSimilarity;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.City;

public class CityNameComparator extends Comparator<City> {

	private LevenshteinSimilarity sim = new LevenshteinSimilarity();

	@Override
	public double compare(City record1, City record2) {
		double similarity = sim.calculate(record1.getName(), record2.getName());

		return similarity;
	}

}