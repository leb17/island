package island.model;

public class MoveAction {
	public Animal animal;
	public Cell from;
	public Cell to;

	public MoveAction(Animal animal, Cell from, Cell to) {
		this.animal = animal;
		this.from = from;
		this.to = to;
	}
}
