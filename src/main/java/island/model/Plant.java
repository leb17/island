package island.model;

import lombok.Getter;

@Getter
public class Plant extends IslandObject {
	private final double weight;
	public static final int MAX_PER_CELL = 200;
	public static final double GROWTH = 25.0;

	public Plant() {
		this.weight = 1.0;
	}
}
