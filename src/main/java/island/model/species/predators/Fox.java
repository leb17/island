package island.model.species.predators;

import island.config.AnimalConfig;
import island.model.Animal;
import island.model.Predator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fox extends Predator {
	private final AnimalConfig animalConfig;

	public Fox(AnimalConfig animalConfig) {
		super(animalConfig);
		this.animalConfig = animalConfig;
	}

	@Override
	public Animal reproduce() {
		return new Fox(animalConfig);
	}

}
