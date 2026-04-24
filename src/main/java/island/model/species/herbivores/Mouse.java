package island.model.species.herbivores;

import island.config.AnimalConfig;
import island.model.Animal;
import island.model.Herbivore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mouse extends Herbivore {
	private final AnimalConfig animalConfig;

	public Mouse(AnimalConfig animalConfig) {
		super(animalConfig);
		this.animalConfig = animalConfig;
	}

	@Override
	public Animal reproduce() {
		return new Mouse(animalConfig);
	}

}
