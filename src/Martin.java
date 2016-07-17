/**
 * @author Naveed Shihab
 * @author Zakeria Ali
 *
 */
public final class Martin extends Entity implements Runnable {

	public Martin(RoadControl control) {
		super(control);
	}

	/**
	 * Martin leaves his home, executes the first sensor, which detects when
	 * Martin leaves his house.
	 * @throws InterruptedException 
	 */
	public void leaveHome() throws InterruptedException {
		control.getGate().lower();
		ExitingSensor sensor = (ExitingSensor) control.getSensors()[0];// sensor1
		sensor.exit(this);
	}

	@Override
	public void enter() throws InterruptedException {
		control.enter(this);
	}

	@Override
	public void exit() throws InterruptedException {
		control.exit(this);
		control.getGate().raise();
	}

	@Override
	public void run() {
		while (true) {
			try {
				enter();
				exit();
				Thread.sleep(random.nextInt(10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
