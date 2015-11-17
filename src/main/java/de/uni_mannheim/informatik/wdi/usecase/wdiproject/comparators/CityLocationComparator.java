package de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators;

import de.uni_mannheim.informatik.wdi.identityresolution.matching.Comparator;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.geo.AbsolutGeoDistanceSimilarity;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.City;

public class CityLocationComparator extends Comparator<City> {

	private AbsolutGeoDistanceSimilarity sim = new AbsolutGeoDistanceSimilarity();

	@Override
	public double compare(City one, City two) {
		double similarity = sim.calculate(one.getLocation(), two.getLocation());
		System.out.println("similarity:" + similarity);
		return similarity;
	}
}
