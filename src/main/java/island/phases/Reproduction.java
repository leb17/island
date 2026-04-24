package island.phases;

import island.model.Animal;
import island.model.Cell;
import island.model.Island;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reproduction {
	public void reproduce(Island island) {

		for (Cell[] row : island.getCells()) {
			for (Cell cell : row) {
				Map<Class<? extends Animal>, List<Animal>> group =
						cell.animals.stream().filter(a -> !a.isDead() && !a.isAlreadyReproduced()).collect(
								Collectors.groupingBy(Animal::getClass));

				for (var entry : group.entrySet()) {
					List<Animal> animals = entry.getValue();
					for (int i = 0; i < animals.size() - 1; i+=2) {
						Animal p1 = animals.get(i);
						Animal p2 = animals.get(i+1);

						long count = cell.animals.stream().filter(a -> a.getClass() == p1.getClass()).count();

						if (count >= p1.getMaxCountOnCell()) break;

						Animal child = p1.reproduce();
						child.setCurrentCell(cell);
						cell.animals.add(child);

						p1.setAlreadyReproduced(true);
						p2.setAlreadyReproduced(true);
					}
				}
			}
		}

		for (Cell[] row : island.getCells()) {
			for (Cell cell : row) {
				for (Animal a : cell.animals) {
					a.setAlreadyReproduced(false);
				}
			}
		}

		System.out.println("Все размножились");
	}
}
