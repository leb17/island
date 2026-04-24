package island.model;

import island.config.AnimalConfig;

public abstract class Herbivore extends Animal {
	protected Herbivore(AnimalConfig animalConfig) {
		super(animalConfig);
	}

	@Override
	public boolean canEatPlants() {
		return true;
	}
}
