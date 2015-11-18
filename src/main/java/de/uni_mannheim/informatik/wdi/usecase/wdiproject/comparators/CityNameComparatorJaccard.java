package de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators;

import de.uni_mannheim.informatik.wdi.identityresolution.matching.Comparator;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.string.TokenizingJaccardSimilarity;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.City;

/**
 * Created by Daniel on 17/11/15.
 */
public class CityNameComparatorJaccard extends Comparator<City>{
	private TokenizingJaccardSimilarity sim = new TokenizingJaccardSimilarity();

	@Override
	public double compare(City one, City two) {
		double similarity = sim.calculate(one.getName(), two.getName());
		return similarity;
	}
	
	

}
