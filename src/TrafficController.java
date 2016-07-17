/**
 * Represents the TRAFFIC_CONTROL process.
 * 
 * @author Naveed Shihab
 * @author Zakeria Ali
 *
 */
public final class TrafficController {
	/**
	 * The number of {@link Enemy} entities on the road.
	 */
	private int enemiesCount;

	/**
	 * An integer flag, indicating whether {@link Martin} is on the road (1) or not (0).
	 */
	private int martinStatus;

	/**
	 * Increment the enemies count.
	 */
	public synchronized void incrementEnemies() {
		enemiesCount++;
	}

	/**
	 * Decrements the enemies count.
	 */
	public synchronized void decrementEnemies() {
		enemiesCount--;
	}

	/**
	 * Get the enemies count.
	 * 
	 * @return enemiesCount
	 */
	public synchronized int getEnemiesCount() {
		return enemiesCount;
	}

	/**
	 * Increments the status of {@link Martin}.
	 */
	public void incrementMartinStatus() {
		martinStatus++;
	}

	/**
	 * Decrements the status of {@link Martin}.
	 */
	public void decrementMartinStatus() {
		martinStatus--;
	}

	/**
	 * Gets the status of {@link Martin}.
	 * 
	 * @return martinStatus
	 */
	public synchronized int getMartinStatus() {
		return martinStatus;
	}
}
