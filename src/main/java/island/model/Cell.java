package island.model;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
	public ArrayList<Animal> animals = new ArrayList<>();
	double plantSize = 0.0;
}
