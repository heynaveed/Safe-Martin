/**
 * An exiting sensor.
 * 
 * @author Naveed Shihab
 * @author Zakeria Ali
 */
public final class ExitingSensor implements Sensor {
	/**
	 * Executed when an {@link Entity} exits the road or when {@link Martin}
	 * leaves his house, via the assigned instances of this class.
	 * 
	 * @param entity
	 *            - the entity being sensed.
	 */
	public synchronized void exit(Entity entity) {
		if (entity instanceof Enemy)
			log("Enemy exiting sensed");
		else
			log("Martin exiting sensed");
	}
}
