package island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationScheduler {
	private final ScheduledExecutorService scheduledExecutorService =
			Executors.newScheduledThreadPool(1);

	public void start(IslandSimulation simulation) {
		scheduledExecutorService.scheduleAtFixedRate(simulation::run,
				0, 1, TimeUnit.SECONDS);
	}

	public void stop() {
		scheduledExecutorService.shutdown();
	}
}
