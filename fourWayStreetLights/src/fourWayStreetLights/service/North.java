package fourWayStreetLights.service;

public class North extends StreetStateBase {
	protected String sig = "RED";
	private int counter = 0;
	private int counter1 = 0;

	public North(StretLightsContext context) {
		this.ctx = context;
	}

	@Override
	public void signal(String signal) {
		if (sig.compareTo(signal) != 0) {
			sig = signal;
			ctx.setCurrentS(ctx.getNorthstate());
			result.storeNewResult("The CURRENT STATE IS NORTH\n");
			lx.writeMessage("The signal is " + sig + " for north direction",
					dl.STATE_ACTION);
			result.storeNewResult("The signal is " + sig
					+ " for north direction\n");
			while (counter != 0) {
				lx.writeMessage(
						"The car waiting passes from the north direction",
						dl.STATE_ACTION);
				result.storeNewResult("The car waiting passes from the north direction\n");
				counter--;
				counter1++;
				if (counter1 == 2) {
					maxCars();
					counter1 = 0;
				}

			}
		}
	}

	@Override
	public void carPass() {

		counter1++;
		lx.writeMessage("The car passes from the north direction",
				dl.STATE_ACTION);
		result.storeNewResult("The car passes from the north direction\n");
		if (counter1 == 2) {
			maxCars();
			counter1 = 0;
		}
	}

	@Override
	public void carWait() {
		counter++;
		lx.writeMessage("The car waits on the north Signal", dl.STATE_ACTION);
		result.storeNewResult("The car waits on the north Signal\n");
	}

	@Override
	public void maxCars() {
		sig = "RED";
		counter = 0;
		lx.writeMessage("The signal is " + sig + " for north direction",
				dl.STATE_ACTION);
		result.storeNewResult("The signal is " + sig + " for north direction\n");
	}

}
