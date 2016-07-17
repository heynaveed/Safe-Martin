import java.util.Random;

/**
 * @author Naveed Shihab
 * @author Zakeria Ali
 *
 */
public abstract class Entity implements Runnable {
	/**
	 * Entities have access to the {@link RoadControl}.
	 */
	protected final RoadControl control;
	/**
	 * An instance of {@link Random} used for sleeping entities at random times.
	 */
	protected final Random random = new Random();

	public Entity(RoadControl control) {
		this.control = control;
	}

	/**
	 * Executed when an Entity enters the road.
	 * 
	 * @throws InterruptedException
	 */
	public abstract void enter() throws InterruptedException;

	/**
	 * Executed when an Entity exits the road.
	 * 
	 * @throws InterruptedException
	 */
	public abstract void exit() throws InterruptedException;

}
