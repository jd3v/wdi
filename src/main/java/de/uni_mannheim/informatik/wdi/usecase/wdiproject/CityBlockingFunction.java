package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.identityresolution.blocking.BlockingFunction;

public class CityBlockingFunction extends BlockingFunction<City> {

	@Override
	public String getBlockingKey(City instance) {
		return Double.toString(Math.round(instance.getLat())) + Double.toString(Math.round(instance.getLon()));				
	}

}