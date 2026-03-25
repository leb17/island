package island.model;

import lombok.Data;

@Data
public class Island {
	private final int width;
	private final int height;
	private final Cell[][] cells;

	//конструктор для создания острова
	public Island(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new Cell[width][height];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				cells[i][j] = new Cell();
			}
		}
	}

	//метод для получения клетки по координатам
	public Cell getCell(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			//throw new IndexOutOfBoundsException("Cell coordinates out of bounds");
			return null;
		}
		return cells[x][y];
	}
}
