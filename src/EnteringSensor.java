/**
 * An entering sensor.
 * 
 * @author Naveed Shihab
 * @author Zakeria Ali
 *
 */
public final class EnteringSensor implements Sensor {
	/**
	 * Executed when an {@link Entity} enters the road.
	 * 
	 * @param entity - the entity being sensed.
	 */
	public synchronized void enter(Entity entity) {
		if (entity instanceof Enemy)
			log("Enemy entering sensed");
		else
			log("Martin entering sensed");
	}
}
