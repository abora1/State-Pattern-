// FIXME: replace XYZ with the package name for the assignment
package fourWayStreetLights.util;

/**
 * @author akshay
 *this class stores different results in logs and then displays them according to the level specified
 */
public class Logger {

	//enums for the Levels
	public static enum DebugLevel {
		CONSTRUCTOR, FILE_PROCESSOR, NONE, STATES, STATE_ACTION
	};

	private static DebugLevel debugLevel;

	// switch cases to handle different levels
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 4:
			debugLevel = DebugLevel.STATE_ACTION;
			break;
		case 3:
			debugLevel = DebugLevel.STATES;
			break;
		case 2:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 1:
			debugLevel = DebugLevel.FILE_PROCESSOR;
			break;
		default:
			debugLevel = DebugLevel.NONE;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}
//this method prints all the message to that debug level.
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public String toString() {
		return "The debug level has been set to the following " + debugLevel;
	}
}
