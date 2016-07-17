/**
 * @author Naveed Shihab
 * @author Zakeria Ali
 *
 */
import java.util.ArrayList;
import java.util.List;

public final class Main {
	/**
	 * A list of entities, used for storing {@link Enemy} entities.
	 */
	private final List<Entity> entities = new ArrayList<>();
	
	public static void main(String[] args) {
		Main main = new Main();
		
		/**
		 * Create the traffic controller, the gate and the road control.
		 */
		TrafficController traffic = new TrafficController();
		Gate gate = new Gate();
		
		/**
		 * The sensors that Martin installed.
		 */
		Sensor[] sensors = new Sensor[4];
		sensors[0] = new ExitingSensor();//sensor1
		sensors[1] = new EnteringSensor();//sensor2
		sensors[2] = new EnteringSensor();//sensor3
		sensors[3] = new ExitingSensor();//sensor4
		RoadControl control = new RoadControl(traffic, gate, sensors);
		 
		/**
		 * create Martin.
		 */
		Entity martin = new Martin(control);
		Thread martinThread = new Thread(martin);
		martinThread.start();
		/**
		 * Create the Enemy entities and specify their ids.
		 */
		for(int i = 0; i < Settings.MAX_ENEMIES; i++) {
			Entity enemy = new Enemy(control, i);
			Thread enemyThread = new Thread(enemy);
			enemyThread.start();
			main.entities.add(enemy);
		}
	}
}
