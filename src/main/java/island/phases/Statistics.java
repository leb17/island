package island.phases;

import island.model.Animal;
import island.model.Cell;
import island.model.Island;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
	public void printStats(Island island) {
		Map<Class<? extends Animal>, Integer> counts = new HashMap<>();
		double plants = 0.0;

		for (Cell[] row : island.getCells()) {
			for (Cell cell : row) {
				plants += cell.getPlantSize();
				for (Animal a : cell.animals) {
					counts.merge(a.getClass(), 1, Integer::sum);
				}
			}
		}

		System.out.println("----Island statistics----");
		counts.forEach((type,count) -> System.out.print(type.getSimpleName() + ": " + count + ", "));

		System.out.println("Plants: " + plants);
	}
}
