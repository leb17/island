package island.model;

import island.Eatable;
import island.Reproducible;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal extends IslandObject implements Eatable, Reproducible {

	protected int speed;
	protected double maxFood;
	protected double foodEaten;
	protected double exhaustion;
	protected Cell currentCell;
	protected int maxCountOnCell;
	protected boolean isDead = false;
	protected boolean alreadyReproduced = false;

	public boolean isHungry() {
		return foodEaten < maxFood;
	}

	public void die() {
		isDead = true;
	}

	public void eat(double food) {
		foodEaten = Math.min(maxFood, foodEaten + food);
	}

	public void animalExhaust() {
		foodEaten -= exhaustion;
		if (foodEaten <= 0) {
			isDead = true;
		}
	}

	public boolean canEatPlants() {
		return false;
	}
}
