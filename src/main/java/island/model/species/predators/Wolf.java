package island.model.species.predators;

import island.config.AnimalConfig;
import island.model.Animal;
import island.model.Predator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wolf extends Predator {
	private final AnimalConfig animalConfig;

	public Wolf(AnimalConfig animalConfig) {
		super(animalConfig);
		this.animalConfig = animalConfig;
	}

	@Override
	public Animal reproduce() {
		return new Wolf(animalConfig);
	}
}
