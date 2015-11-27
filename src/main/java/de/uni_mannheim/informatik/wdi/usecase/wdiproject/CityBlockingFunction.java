package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.identityresolution.blocking.BlockingFunction;

public class CityBlockingFunction extends BlockingFunction<City> {

	@Override
	public String getBlockingKey(City instance) {
//		int lon = (int) Math.round(instance.getLon());
		double lon = (instance.getLon());
		String blockingKey = String.valueOf(lon);
		return blockingKey;
				//instance.getCc() + ((int) Math.round(instance.getLon());
		
	}

}