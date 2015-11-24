package de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators;

import de.uni_mannheim.informatik.wdi.identityresolution.matching.Comparator;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.geo.AbsolutGeoDistanceSimilarity;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.numeric.AbsoluteDifferenceSimilarity;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.City;

public class CityLocationComparator extends Comparator<City> {

	private AbsoluteDifferenceSimilarity sim = new AbsoluteDifferenceSimilarity(0.5);

	@Override
	public double compare(City one, City two) {
		double similarityLat = sim.calculate(one.getLat(), two.getLat());
		double similarityLong = sim.calculate(one.getLon(), two.getLon());
		
		double similarity = similarityLat * similarityLong;
		
		return similarity;
	}
}
