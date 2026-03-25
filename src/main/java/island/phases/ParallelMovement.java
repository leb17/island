package island.phases;

import island.model.Animal;
import island.model.Cell;
import island.model.Island;
import island.model.MoveAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelMovement {
	private final ExecutorService workers;

	public ParallelMovement(ExecutorService workers) {
		this.workers = workers;
	}

	public void move(Island island) {
		List<MoveAction> actions = Collections.synchronizedList(new ArrayList<>());

		List<Callable<Void>> tasks = new ArrayList<>();

		Cell[][] cells = island.getCells();

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {

				int x = i;
				int y = j;

				tasks.add(() -> {
					Cell cell = cells[x][y];
					for (Animal a : cell.animals) {
						if (a.isDead()) continue;
						int steps = ThreadLocalRandom.current().nextInt(0, a.getSpeed() + 1);
						int targetX = x;
						int targetY = y;

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
						if (targetCell != cell) {
							actions.add(new MoveAction(a, cell, targetCell));
						}
					}
					return null;
				});
				}
			}
		try {
			workers.invokeAll(tasks);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		for (MoveAction a : actions) {
			long count = a.to.animals.stream()
					.filter(b -> b.getClass() == a.animal.getClass()).count();
			if (count >= a.animal.getMaxCountOnCell()) continue;

			a.from.animals.remove(a.animal);
			a.to.animals.add(a.animal);
			a.animal.setCurrentCell(a.to);
		}
	}
}
