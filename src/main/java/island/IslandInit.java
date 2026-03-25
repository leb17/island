package island;

import island.config.AnimalConfig;
import island.model.Animal;
import island.model.Cell;
import island.model.Island;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class IslandInit {
	private final AnimalFactory animalFactory;
	private final Map<Class<? extends Animal>, AnimalConfig> initConfig;

	public IslandInit(AnimalFactory animalFactory,
					  Map<Class<? extends Animal>, AnimalConfig> initConfig) {
		this.animalFactory = animalFactory;
		this.initConfig = initConfig;
	}

	public void initBaseSpecies(Island island) {
		for (Cell[] row : island.getCells()) {
			for (Cell cell : row) {
				for (Class<? extends Animal> clazz : initConfig.keySet()) {
					AnimalConfig animalConfig = initConfig.get(clazz);
					int count = ThreadLocalRandom.current().nextInt(0,
							animalConfig.getMaxCountOnCell() + 1);
					for (int i = 0; i < count; i++) {
						Animal a = animalFactory.createAnimal(clazz);
						a.setCurrentCell(cell);
						cell.animals.add(a);
					}
				}
				cell.setPlantSize(ThreadLocalRandom.current().nextDouble(0, 150));
			}
		}
	}
}
