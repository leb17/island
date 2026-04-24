package island;

import island.model.Animal;
import java.util.HashMap;
import java.util.Map;

public class EatTable {
	private final Map<Class<? extends Animal>, Map<Class<? extends Animal>, Double>> eatTable = new HashMap<>();

	public void addRule(Class<? extends Animal> predator,
						Class<? extends Animal> prey,
						double probability) {
		eatTable.computeIfAbsent(predator, k -> new HashMap<>())
				.put(prey, probability);
	}

	public double getProbability(Animal predator, Animal prey) {
		return eatTable.getOrDefault(predator.getClass(), Map.of())
				.getOrDefault(prey.getClass(), 0.0);
	}

	public boolean canEat(Animal predator, Animal prey) {
		return getProbability(predator, prey) > 0;
	}
}
