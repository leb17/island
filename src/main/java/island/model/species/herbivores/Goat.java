package island.model.species.herbivores;

import island.config.AnimalConfig;
import island.model.Animal;
import island.model.Herbivore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goat extends Herbivore {
	private final AnimalConfig animalConfig;

	public Goat(AnimalConfig animalConfig) {
		this.animalConfig = animalConfig;
		this.weight = animalConfig.getWeight();
		this.speed = animalConfig.getSpeed();
		this.maxFood = animalConfig.getMaxFood();
		this.exhaustion = animalConfig.getExhaustion();
		this.maxCountOnCell = animalConfig.getMaxCountOnCell();
		this.foodEaten = maxFood / 3;
		this.alreadyReproduced = false;
	}


	@Override
	public Animal reproduce() {
		return new Goat(animalConfig);
	}
}
