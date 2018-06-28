package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;
import fourWayStreetLights.util.Logger.DebugLevel;

public abstract class StreetStateBase implements StreetLightsStateI {

	protected Results result = Results.Instance();
	protected StretLightsContext ctx;
	protected Logger lx;
	protected DebugLevel dl;
}
