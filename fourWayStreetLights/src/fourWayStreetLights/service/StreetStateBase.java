package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;
import fourWayStreetLights.util.Logger.DebugLevel;

/**
 * @author akshay
 *this abstract class holds the objects of all the required class to be used easily.
 */
public abstract class StreetStateBase implements StreetLightsStateI {

	protected Results result = Results.Instance();
	protected StretLightsContext ctx;
	protected Logger lx;
	protected DebugLevel dl;
}
