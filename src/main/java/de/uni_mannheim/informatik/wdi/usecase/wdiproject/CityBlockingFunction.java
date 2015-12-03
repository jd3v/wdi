package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.identityresolution.blocking.BlockingFunction;

public class CityBlockingFunction extends BlockingFunction<City> {

	@Override
	public String getBlockingKey(City instance) {
//		int lon = (int) Math.round(instance.getLon());
		

		//instance.getCc() + ((int) Math.round(instance.getLon());
		
		//lat + long
//		return Double.toString(Math.round(instance.getLat())) + Double.toString(Math.round(instance.getLon()));		
		// cc + lon
//		return instance.getCc() + ((int) Math.round(instance.getLon()));
		
		//windowing
		
//		longitude
		double lon = (instance.getLon());
		String blockingKey = String.valueOf(lon);
		return blockingKey;
//		
////		//latitude
//		double lat = (instance.getLat());
//		String blockingKey = String.valueOf(lat);
//		return blockingKey;

		
	}

}