package island.phases;

import island.model.Animal;
import island.model.Cell;
import island.model.Island;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Movement {
	public void move(Island island) {

		Cell[][] cells = island.getCells();

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				Cell cell = cells[i][j];
				List<Animal> animals = new ArrayList<>(cell.animals);

				for (Animal a : animals) {
					if (a.isDead()) continue;
					int steps = ThreadLocalRandom.current().nextInt(0, a.getSpeed() + 1);
					int targetX = i;
					int targetY = j;

					for (int k = 0; k < steps; k++) {
						int dx = 0;
						int dy = 0;

						switch (ThreadLocalRandom.current().nextInt(4)) {
							case 0 -> dx = 1;
							case 1 -> dx = -1;
							case 2 -> dy = 1;
							case 3 -> dy = -1;
						}

						if (island.getCell(targetX + dx, targetY + dy) != null) {
							targetX += dx;
							targetY += dy;
						}
					}

					Cell targetCell = island.getCell(targetX, targetY);
					if (targetCell == cell) continue;

					long countType = targetCell.animals.stream().filter(animal -> animal.getClass() == a.getClass()).count();
					if (countType >= a.getMaxCountOnCell()) continue;

					cell.animals.remove(a);
					targetCell.animals.add(a);
					a.setCurrentCell(targetCell);
				}
			}
		}

		System.out.println("Все сменили клетки");
	}
}
