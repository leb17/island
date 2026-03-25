package island;

import island.config.AnimalConfig;
import island.model.Animal;
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
import java.util.Map;

public class AnimalFactory {
	private final Map<Class<? extends Animal>, AnimalConfig> configMap;

	public AnimalFactory(Map<Class<? extends Animal>, AnimalConfig> configMap) {
		this.configMap = configMap;
	}

	public Animal createAnimal(Class<? extends Animal> clazz) {
		AnimalConfig animalConfig = configMap.get(clazz);
		if (clazz == Boar.class) return new Boar(animalConfig);
		if (clazz == Caterpillar.class) return new Caterpillar(animalConfig);
		if (clazz == Cow.class) return new Cow(animalConfig);
		if (clazz == Deer.class) return new Deer(animalConfig);
		if (clazz == Duck.class) return new Duck(animalConfig);
		if (clazz == Goat.class) return new Goat(animalConfig);
		if (clazz == Horse.class) return new Horse(animalConfig);
		if (clazz == Mouse.class) return new Mouse(animalConfig);
		if (clazz == Rabbit.class) return new Rabbit(animalConfig);
		if (clazz == Sheep.class) return new Sheep(animalConfig);
		if (clazz == Wolf.class) return new Wolf(animalConfig);
		if (clazz == Bear.class) return new Bear(animalConfig);
		if (clazz == Eagle.class) return new Eagle(animalConfig);
		if (clazz == Snake.class) return new Snake(animalConfig);
		if (clazz == Fox.class) return new Fox(animalConfig);

		throw new IllegalArgumentException("Unknown class: " + clazz);
	}
}
