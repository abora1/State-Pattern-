package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Logger.DebugLevel;

public class StretLightsContext {

	private North northstate;
	private South southstate;
	private East eaststate;
	private West weststate;
	private StreetLightsStateI currentS = northstate;

	public StretLightsContext() {
		this.northstate = new North(this);
		this.southstate = new South(this);
		this.eaststate = new East(this);
		this.weststate = new West(this);
	}

	public void action(String s) {
		// System.out.print(s + "\n\n");
		String[] result = s.split(":");
		if ((result[1]).equals("NORTH")
				|| ((result[1]).equals("NORTH") && result[0].equals("CAR"))) {

			currentS = northstate;

			if ((result[0]).equals("LIGHT")) {
				Logger.writeMessage("The Current STATE is NORTH",
						DebugLevel.STATES);
				currentS.signal(result[2]);
			}
			if ((result[0]).equals("CAR")) {
				if ((northstate.sig).equals("GREEN")) {
					currentS.carPass();
				} else {
					northstate.carWait();
				}
			}
		} else if ((result[1]).equals("SOUTH")
				|| ((result[1]).equals("SOUTH") && result[0].equals("CAR"))) {
			currentS = southstate;

			if ((result[0]).equals("LIGHT")) {
				Logger.writeMessage("The Current STATE is SOUTH",
						DebugLevel.STATES);
				currentS.signal(result[2]);
			}
			if ((result[0]).equals("CAR")) {
				if ((southstate.sig).equals("GREEN")) {
					currentS.carPass();
				} else {
					southstate.carWait();
				}
			}

		} else if ((result[1]).equals("EAST")
				|| ((result[1]).equals("EAST") && result[0].equals("CAR"))) {
			currentS = eaststate;
			if ((result[0]).equals("LIGHT")) {
				Logger.writeMessage("The Current STATE is EAST",
						DebugLevel.STATES);
				currentS.signal(result[2]);
			}
			if ((result[0]).equals("CAR")) {
				if ((eaststate.sig).equals("GREEN")) {
					currentS.carPass();
				} else {
					eaststate.carWait();
				}
			}

		} else if ((result[1]).equals("WEST")
				|| ((result[1]).equals("WEST") && result[0].equals("CAR"))) {
			currentS = weststate;
			if ((result[0]).equals("LIGHT")) {
				Logger.writeMessage("The Current STATE is WEST",
						DebugLevel.STATES);
				currentS.signal(result[2]);
			}
			if ((result[0]).equals("CAR")) {
				if ((weststate.sig).equals("GREEN")) {
					currentS.carPass();
				} else {
					weststate.carWait();
				}
			}

		}

	}

	@Override
	public String toString() {
		return currentS.toString();
	}

	public StreetLightsStateI getCurrentS() {
		return currentS;
	}

	public void setCurrentS(StreetLightsStateI currentS) {
		this.currentS = currentS;
	}

	public North getNorthstate() {
		return northstate;
	}

	public void setNorthstate(North northstate) {
		this.northstate = northstate;
	}

	public South getSouthstate() {
		return southstate;
	}

	public void setSouthstate(South southstate) {
		this.southstate = southstate;
	}

	public East getEaststate() {
		return eaststate;
	}

	public void setEaststate(East eaststate) {
		this.eaststate = eaststate;
	}

	public West getWeststate() {
		return weststate;
	}

	public void setWeststate(West weststate) {
		this.weststate = weststate;
	}

	public String currentStateName() {
		return this.currentS.toString();
	}
}
