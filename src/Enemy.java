/**
 * @author Naveed Shihab
 * @author Zakeria Ali
 *
 */
public final class Enemy extends Entity implements Runnable {
	/**
	 * The id of this enemy.
	 */
	private final int id;
			
	public Enemy(RoadControl control, int id) {
		super(control);
		this.id = id;
	}

	@Override
	public void enter() throws InterruptedException {
		control.enter(this);
		control.getGate().pass();
	}

	@Override
	public void exit() throws InterruptedException {
		control.exit(this);
	}
	
	/**
	 * Gets the id of this enemy.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	@Override
	public void run() {
		while(true) {
			try {
				//enter and exit is executed in a sequence.
				enter();
				exit();
				Thread.sleep(random.nextInt(15000 + random.nextInt(1000)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
