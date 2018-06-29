package fourWayStreetLights.service;

/**
 * @author akshay
 *This is a state class which holds the SOUTH signal condition.
 */
public class South extends StreetStateBase {
	protected String sig = "RED";
	private int counter = 0;
	private int counter1 = 0;

	public South(StretLightsContext context) {
		this.ctx = context;
	}
	//this method checks the signal and then uses that to pass or wait cars
	@Override
	public void signal(String signal) {
		if (sig.compareTo(signal) != 0) {
			sig = signal;
			ctx.setCurrentS(ctx.getSouthstate());
			result.storeNewResult("The CURRENT STATE IS SOUTH\n");
			lx.writeMessage("The signal is " + sig + " for SOUTH direction",
					dl.STATE_ACTION);
			result.storeNewResult("The signal is " + sig
					+ " for SOUTH direction\n");
			while (counter != 0) {
				lx.writeMessage(
						"The car waiting passes from the SOUTH direction",
						dl.STATE_ACTION);
				result.storeNewResult("The car waiting passes from the SOUTH direction\n");
				counter--;
				counter1++;
				if (counter1 == 2) {
					maxCars();
					counter1 = 0;
				}

			}
		}
	}
	//if the signal is green the car can easily pass holding that the counter is not greater than 2
	@Override
	public void carPass() {

		counter1++;
		lx.writeMessage("The car passes from the SOUTH direction",
				dl.STATE_ACTION);
		result.storeNewResult("The car passes from the SOUTH direction\n");
		if (counter1 == 2) {
			maxCars();
			counter1 = 0;
		}
	}
	//if there are more than 2 cars or if 2 cars have already passed then this method is used to hold these cars.
	@Override
	public void carWait() {
		counter++;
		lx.writeMessage("The car waits on the SOUTH Signal", dl.STATE_ACTION);
		result.storeNewResult("The car waits on the SOUTH Signal\n");
	}
	//when 2 cars have passed the signal changes to red and the rest of the cars wait.
	@Override
	public void maxCars() {
		sig = "RED";
		counter = 0;
		lx.writeMessage("The signal is " + sig + " for SOUTH direction",
				dl.STATE_ACTION);
		result.storeNewResult("The signal is " + sig + " for SOUTH direction\n");
	}

}
