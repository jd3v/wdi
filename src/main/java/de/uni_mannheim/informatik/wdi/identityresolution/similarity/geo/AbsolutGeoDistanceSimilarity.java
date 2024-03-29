package de.uni_mannheim.informatik.wdi.identityresolution.similarity.geo;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import de.uni_mannheim.informatik.wdi.identityresolution.similarity.SimilarityMeasure;

/**
 * Calculates the absolute geo distance between to goe-locations
 * @author Julian
 *
 */
public class AbsolutGeoDistanceSimilarity extends SimilarityMeasure<LatLng> {
		
	@Override
	public double calculate(LatLng location1, LatLng location2) {
		if(location1==null || location1==null) {
			return 0.0;
		} else {
			double distanceInKilometers = LatLngTool.distance(location1, location2, LengthUnit.KILOMETER);
			System.out.println(distanceInKilometers);
							
			return distanceInKilometers;
		}
	}

}




//private double max_percentage = 0.0;
//
///**
// * Creates a new instance of the similarity measure
// * @param max_percental_difference the max percental difference between two values. Higher differences lead to a similarity value of 0.0.
// */
//public PercentageSimilarity(double max_percental_difference) {
//	this.max_percentage = max_percental_difference;
//}
//
//@Override
//public double calculate(Double first, Double second) {
//	if(first==null || second==null) {
//		return 0.0;
//	} else {
//		double pc = Math.abs(first-second)/Math.max(first, second);
//		
//		if(pc < max_percentage) {
//			return 1 - pc/max_percentage;
//		} else {
//			return 0.0;
//		}
//	}
//}