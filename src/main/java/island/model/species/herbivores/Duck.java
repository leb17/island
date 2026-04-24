package island.model.species.herbivores;

import island.config.AnimalConfig;
import island.model.Animal;
import island.model.Herbivore;

public class Duck extends Herbivore {
	private final AnimalConfig animalConfig;

	public Duck(AnimalConfig animalConfig) {
		super(animalConfig);
		this.animalConfig = animalConfig;
	}

	@Override
	public Animal reproduce() {
		return new Duck(animalConfig);
	}
}
