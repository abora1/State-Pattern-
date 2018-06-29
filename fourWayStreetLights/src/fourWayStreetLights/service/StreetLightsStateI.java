package fourWayStreetLights.service;

/**
 * @author akshay
 *Interface for all the states and actions.
 */
public interface StreetLightsStateI {
	public void signal(String s);

	public void carPass();

	public void maxCars();

	public void carWait();

}
