package de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators;

import de.uni_mannheim.informatik.wdi.identityresolution.matching.Comparator;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.string.JaroSimilarity;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.City;
/**
 * Created by Daniel on 25/11/15.
 */
public class CityNameComparatorJaro extends Comparator<City>{
	private JaroSimilarity sim = new JaroSimilarity();

	@Override
	public double compare(City record1, City record2) {
		double similarity = sim.calculate(record1.getName(), record2.getName());
		return similarity;
	}
}
