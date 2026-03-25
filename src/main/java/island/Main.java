package island;

import island.config.AnimalConfig;
import island.model.Animal;
import island.model.Island;
import island.model.species.herbivores.Boar;
import island.model.species.herbivores.Caterpillar;
import island.model.species.herbivores.Cow;
import island.model.species.herbivores.Deer;
import island.model.species.herbivores.Duck;
import island.model.species.herbivores.Goat;
import island.model.species.herbivores.Horse;
import island.model.species.herbivores.Mouse;
import island.model.species.herbivores.Rabbit;
import island.model.species.herbivores.Sheep;
import island.model.species.predators.Bear;
import island.model.species.predators.Eagle;
import island.model.species.predators.Fox;
import island.model.species.predators.Snake;
import island.model.species.predators.Wolf;
import island.phases.Eating;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<Class<? extends Animal>, AnimalConfig> config = new HashMap<>();
		config.put(Boar.class, new AnimalConfig(400, 50, 10, 50, 2));
		config.put(Caterpillar.class, new AnimalConfig(0.01, 0, 0, 1000, 0));
		config.put(Cow.class, new AnimalConfig(700, 100, 20, 10, 3));
		config.put(Deer.class, new AnimalConfig(300, 50, 10, 20, 4));
		config.put(Duck.class, new AnimalConfig(1, 0.15, 0.03, 200, 4));
		config.put(Goat.class, new AnimalConfig(60, 10, 2, 140, 3));
		config.put(Horse.class, new AnimalConfig(400, 60, 12, 20, 4));
		config.put(Mouse.class, new AnimalConfig(0.05, 0.01, 0.002, 500, 1));
		config.put(Rabbit.class, new AnimalConfig(2, 0.45, 0.09, 150, 2));
		config.put(Sheep.class, new AnimalConfig(70, 15, 3, 140, 3));

		config.put(Wolf.class, new AnimalConfig(50, 8, 1.6, 30, 3));
		config.put(Bear.class, new AnimalConfig(500, 80, 16, 5, 2));
		config.put(Eagle.class, new AnimalConfig(6, 1, 0.2, 20, 3));
		config.put(Snake.class, new AnimalConfig(15, 3, 0.6, 30, 1));
		config.put(Fox.class, new AnimalConfig(8, 2, 0.4, 30, 2));

		EatTable eatTable = new EatTable();
		eatTable.addRule(Boar.class, Caterpillar.class, 0.9);
		eatTable.addRule(Mouse.class, Caterpillar.class, 0.9);
		eatTable.addRule(Wolf.class, Boar.class, 0.15);
		eatTable.addRule(Wolf.class, Cow.class, 0.1);
		eatTable.addRule(Wolf.class, Deer.class, 0.15);
		eatTable.addRule(Wolf.class, Duck.class, 0.4);
		eatTable.addRule(Wolf.class, Goat.class, 0.6);
		eatTable.addRule(Wolf.class, Horse.class, 0.1);
		eatTable.addRule(Wolf.class, Mouse.class, 0.8);
		eatTable.addRule(Wolf.class, Rabbit.class, 0.6);
		eatTable.addRule(Wolf.class, Sheep.class, 0.7);
		eatTable.addRule(Bear.class, Boar.class, 0.5);
		eatTable.addRule(Bear.class, Cow.class, 0.2);
		eatTable.addRule(Bear.class, Deer.class, 0.8);
		eatTable.addRule(Bear.class, Duck.class, 0.1);
		eatTable.addRule(Bear.class, Goat.class, 0.7);
		eatTable.addRule(Bear.class, Horse.class, 0.4);
		eatTable.addRule(Bear.class, Mouse.class, 0.9);
		eatTable.addRule(Bear.class, Snake.class, 0.8);
		eatTable.addRule(Bear.class, Rabbit.class, 0.8);
		eatTable.addRule(Bear.class, Sheep.class, 0.7);
		eatTable.addRule(Duck.class, Caterpillar.class, 0.9);
		eatTable.addRule(Eagle.class, Duck.class, 0.8);
		eatTable.addRule(Eagle.class, Mouse.class, 0.9);
		eatTable.addRule(Eagle.class, Rabbit.class, 0.9);
		eatTable.addRule(Eagle.class, Fox.class, 0.1);
		eatTable.addRule(Snake.class, Mouse.class, 0.4);
		eatTable.addRule(Snake.class, Duck.class, 0.1);
		eatTable.addRule(Snake.class, Rabbit.class, 0.2);
		eatTable.addRule(Snake.class, Fox.class, 0.15);
		eatTable.addRule(Fox.class, Rabbit.class, 0.7);
		eatTable.addRule(Fox.class, Mouse.class, 0.9);
		eatTable.addRule(Fox.class, Duck.class, 0.6);
		eatTable.addRule(Fox.class, Caterpillar.class, 0.4);

		AnimalFactory animalFactory = new AnimalFactory(config);

		Island island = new Island(3,3);
		new IslandInit(animalFactory, config).initBaseSpecies(island);

		IslandSimulation simulation = new IslandSimulation(island, new Eating(eatTable));

		//single thread
		//for (int i = 0; i < 3; i++) {
		//	simulation.run();
		//}

		SimulationScheduler scheduler = new SimulationScheduler();
		scheduler.start(simulation);
	}
}
