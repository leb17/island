package island.phases;

import island.model.Animal;
import island.model.Cell;
import island.model.Island;


public class Exhaustion {

	public void run(Island island) {
		for (Cell[] row : island.getCells()) {
			for (Cell cell : row) {
				for (Animal a : cell.animals) {
					a.animalExhaust();
				}
			}
		}
		System.out.println("Все истощились");
	}
}
