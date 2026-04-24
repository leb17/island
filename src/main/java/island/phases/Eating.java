package island.phases;

import island.EatTable;
import island.model.Animal;
import island.model.Cell;
import island.model.Island;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Eating {
	private final EatTable eatTable;

	public Eating(EatTable eatTable) {
		this.eatTable = eatTable;
	}

	public void eat(Island island) {
		for (Cell[] row : island.getCells()) {
			for (Cell cell : row) {
				for (Animal a : cell.animals) {
					if (a.isDead() || !a.isHungry()) continue;

					boolean ate = false;

					List<Animal> possiblePreys = cell.animals.stream()
							.filter(p -> p != a && !p.isDead() && eatTable.canEat(a, p))
							.toList();

					if (!possiblePreys.isEmpty()) {
						Animal prey = possiblePreys.get(ThreadLocalRandom.current().nextInt(
								possiblePreys.size()));
						double ran = Math.random();
						if (ran < eatTable.getProbability(a, prey)) {
							a.eat(prey.getWeight());
							prey.die();
							ate = true;
						}
					}

					if (!ate && a.canEatPlants() && cell.getPlantSize() > 0) {
						double eaten = Math.min(0.5, Math.min(cell.getPlantSize(), a.getMaxFood() - a.getFoodEaten()));
						cell.setPlantSize(cell.getPlantSize() - eaten);
						a.eat(eaten);
					}
				}
			}
		}

		System.out.println("Все поели");
	}
}
