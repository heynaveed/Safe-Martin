import java.util.logging.Logger;

/**
 * Represents a sensor.
 * 
 * @author Naveed
 * @author Zakeria
 *
 */
public interface Sensor {
	/**
	 * A logger instance for this interface.
	 * 
	 */
	final Logger logger = Logger.getLogger(Sensor.class.getName());

	/**
	 * Log a sense event.
	 * 
	 * @param str
	 *            the log message
	 */
	default void log(String str) {
		logger.info(str);
	}
}
