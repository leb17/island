package island.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalConfig {
	private double weight;
	private double maxFood;
	private double exhaustion;

	private int maxCountOnCell;
	private int speed;

	public AnimalConfig(double weight, double maxFood, double exhaustion, int maxCountOnCell,
						int speed) {
		this.weight = weight;
		this.maxFood = maxFood;
		this.exhaustion = exhaustion;
		this.maxCountOnCell = maxCountOnCell;
		this.speed = speed;
	}
}
