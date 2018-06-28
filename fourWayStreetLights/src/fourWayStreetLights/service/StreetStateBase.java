package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;

public abstract class StreetStateBase implements StreetLightsStateI {

	protected Results result = Results.Instance();
	protected StretLightsContext ctx;

}
