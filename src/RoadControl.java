
/**
 * @author Naveed Shihab
 * @author Zakeria Ali
 *
 */
public final class RoadControl {
	/**
	 * The {@link TrafficController}.
	 */
	private final TrafficController traffic;
	/**
	 * The {@link Gate} {@link Martin} installed on his road.
	 */
	private final Gate gate;
	/**
	 * The {@link Sensor}s {@link Martin} installed.
	 */
	private final Sensor[] sensors;

	public RoadControl(TrafficController counter, Gate gate, Sensor[] sensors) {
		this.traffic = counter;
		this.gate = gate;
		this.sensors = sensors;
	}

	/**
	 * Called when an {@link Entity} enters the road.
	 * 
	 * @param entity
	 * @throws InterruptedException
	 */
	public synchronized void enter(Entity entity) throws InterruptedException {
		if (entity instanceof Enemy)
			enterEnemy(entity);
		else
			enterMartin(entity);
	}

	/**
	 * Called when an {@link Entity} exits the road.
	 * 
	 * @param entity
	 * @throws InterruptedException
	 */
	public synchronized void exit(Entity entity) throws InterruptedException {
		if (entity instanceof Enemy)
			exitEnemy(entity);
		else
			exitMartin(entity);
	}

	/**
	 * Called when {@link Martin} enters the road.
	 * 
	 * @param entity
	 * @throws InterruptedException
	 */
	private void enterMartin(Entity entity) throws InterruptedException {
		while (traffic.getEnemiesCount() > 0 || (traffic.getMartinStatus() > 0)) {
			wait();
		}
		Martin martin = (Martin) entity;
		martin.leaveHome();

		traffic.incrementMartinStatus();
		
		EnteringSensor sensor = (EnteringSensor) sensors[1];// sensor2
		sensor.enter(entity);
		
		notify();
		System.out.println("Martin has entered the road.");
	}

	/**
	 * Executed when an {@link Enemy} enters the road.
	 * 
	 * @param entity
	 * @throws InterruptedException
	 */
	private synchronized void enterEnemy(Entity entity) throws InterruptedException {
		while (traffic.getEnemiesCount() == Settings.MAX_ENEMIES || (traffic.getMartinStatus() == 1)) {
			wait();
		}
		traffic.incrementEnemies();
		
		EnteringSensor sensor = (EnteringSensor) sensors[2];// sensor3
		sensor.enter(entity);
		
		notify();

		Enemy enemy = (Enemy) entity;
		System.out.println("Enemy " + enemy.getId() + " has entered the road");
	}

	/**
	 * Called when {@link Martin} exits the road.
	 * 
	 * @param entity
	 * @throws InterruptedException
	 */
	private void exitMartin(Entity entity) throws InterruptedException {
		while (traffic.getEnemiesCount() > 0 || (traffic.getMartinStatus() == 0)) {
			wait();
		}
		traffic.decrementMartinStatus();
		
		ExitingSensor sensor = (ExitingSensor) sensors[3];// sensor4
		sensor.exit(entity);
		
		notify();
		System.out.println("Martin has left the road.");
	}

	/**
	 * Executed when an {@link Enemy} exits the road.
	 * 
	 * @param entity
	 * @throws InterruptedException
	 */
	private void exitEnemy(Entity entity) throws InterruptedException {
		while (traffic.getEnemiesCount() == 0 || (traffic.getMartinStatus() == 1)) {
			wait();
		}
		traffic.decrementEnemies();
		
		ExitingSensor sensor = (ExitingSensor) sensors[3];// sensor4
		sensor.exit(entity);
		
		notify();

		Enemy enemy = (Enemy) entity;
		System.out.println("Enemy " + enemy.getId() + " has left the road");
	}

	/**
	 * Gets the {@link Gate}.
	 * 
	 * @return gate
	 */
	public Gate getGate() {
		return gate;
	}

	/**
	 * Gets the {@link Sensor}s.
	 * 
	 * @return sensors
	 */
	public Sensor[] getSensors() {
		return sensors;
	}

	/**
	 * Gets the {@link TrafficController}.
	 * 
	 * @return traffic
	 */
	public TrafficController getTraffic() {
		return traffic;
	}
}
