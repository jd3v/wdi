package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import de.uni_mannheim.informatik.wdi.identityresolution.blocking.BlockingFunction;

public class CityBlockingFunction extends BlockingFunction<City> {

	@Override
	public String getBlockingKey(City instance) {
		return instance.getCc() + ((int) Math.round(instance.getLon()));
		
	}

}