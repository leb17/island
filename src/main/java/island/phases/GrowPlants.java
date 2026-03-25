package island.phases;

import island.model.Cell;
import island.model.Island;
import island.model.Plant;

public class GrowPlants {

	public void grow(Island island) {
		for (Cell[] row : island.getCells()) {
			for (Cell cell : row) {
				if (cell.getPlantSize() < Plant.MAX_PER_CELL) {
					cell.setPlantSize(Math.min(cell.getPlantSize() + Plant.GROWTH, Plant.MAX_PER_CELL));
				}
			}
		}
		System.out.println("Все растения выросли");
	}
}
