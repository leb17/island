package island;

import island.model.Animal;
import island.model.Cell;
import island.model.Island;
import island.phases.Eating;
import island.phases.Exhaustion;
import island.phases.GrowPlants;
import island.phases.Movement;
import island.phases.ParallelMovement;
import island.phases.Reproduction;
import island.phases.Statistics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IslandSimulation {
	private final Island island;

	private final ExecutorService workers = Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	private final GrowPlants growPlants;
	//private final Movement movement;
	private final ParallelMovement movement;
	private final Eating eating;
	private final Exhaustion exhaustion;
	private final Reproduction reproduction;
	private final Statistics stats;

	public IslandSimulation(Island island, Eating eating) {
		this.island = island;
		this.growPlants = new GrowPlants();
		//this.movement = new Movement();
		this.movement = new ParallelMovement(workers);
		this.eating = eating;
		this.exhaustion = new Exhaustion();
		this.reproduction = new Reproduction();
		this.stats = new Statistics();
	}

	//метод симуляции такта на острове
	public void run() {
			growPlants.grow(island);
			movement.move(island);
			eating.eat(island);
			exhaustion.run(island);
			reproduction.reproduce(island);
			clean();
			stats.printStats(island);
	}

	public void clean() {
		for (Cell[] row : island.getCells()) {
			for (Cell cell : row) {
				cell.animals.removeIf(Animal::isDead);
			}
		}
	}

}
