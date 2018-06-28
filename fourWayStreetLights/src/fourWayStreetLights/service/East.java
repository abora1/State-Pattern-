package fourWayStreetLights.service;

public class East extends StreetStateBase {
	protected String sig="RED";
	private int counter = 0;
	private int counter1=0;

	public East(StretLightsContext context) {
		this.ctx = context;
	}

	@Override
	public void signal(String signal) {
		if (sig.compareTo(signal)!=0) {
			sig = signal;
			ctx.setCurrentS(ctx.getSouthstate());
			result.storeNewResult("The CURRENT STATE IS EAST\n");
			System.out.print("The signal is " + sig + " for east direction\n");
			result.storeNewResult("The signal is " + sig + " for east direction\n");
			while(counter!=0){
				System.out.print("The car waiting passes from the east direction\n");
				result.storeNewResult("The car waiting passes from the east direction\n");
				counter--;
				counter1++;
				if(counter1==2){
					maxCars();
					counter1=0;
				}

			}
					}
	}

	@Override
	public void carPass() {
		
		counter1++;
		System.out.print("The car passes from the east direction\n");
		result.storeNewResult("The car passes from the east direction\n");
		if (counter1 == 2) {
			maxCars();
			counter1=0;
			}
	}
	@Override
	public void carWait(){
		counter++;
		System.out.print("The car waits on the east Signal\n");
		result.storeNewResult("The car waits on the east Signal\n");
	}
	@Override
	public void maxCars() {
		sig = "RED";
		counter=0;
		System.out.print("The signal is " + sig + " for east direction\n");
		result.storeNewResult("The signal is " + sig + " for east direction\n");
	}

}
