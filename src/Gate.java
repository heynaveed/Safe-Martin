import java.util.logging.Logger;

/**
 * Represents the gate process.
 * 
 * @author Naveed Shihab
 * @author Zakeria Ali
 *
 */
public final class Gate {
	/**
	 * A logger instance for the gate class.
	 */
	private final Logger logger = Logger.getLogger(Gate.class.getName());

	/**
	 * Raise the gate, called when {@link Martin} exits the road.
	 */
	public void raise() {
		logger.info("Gate raised");
	}

	/**
	 * Lower the gate, called when {@link Martin} exits the road.
	 */
	public void lower() {
		logger.info("Gate lowered");
	}

	/**
	 * Pass action of the gate, called when an {@link Enemy} passes through.
	 */
	public synchronized void pass() {
		logger.info("Enemy passed through gate");
	}
}
