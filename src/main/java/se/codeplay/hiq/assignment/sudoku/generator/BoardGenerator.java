package se.codeplay.hiq.assignment.sudoku.generator;

import java.util.Random;

import se.codeplay.hiq.assignment.sudoku.board.Board;

public class BoardGenerator {

    private final Random random;

    public BoardGenerator() {
	this.random = new Random(System.currentTimeMillis());
    }

    /**
     * Generates a board based on size and difficulty given at the generation of
     * this board object.
     */
    public void generateBoardValues(Board board, int difficulty) {
	double availableCells = board.getBoardSize() * board.getBoardSize();
	double numberOfCellsToZero = (double) (availableCells * (difficulty / 100.0f));

	int cellValue = 0;
	for (int x = 0; x < board.getBoardSize(); x++) {
	    for (int y = 0; y < board.getBoardSize(); y++) {

		cellValue++;

		if (isAllowedToSetCellValue(availableCells, numberOfCellsToZero)) {
		    board.setCellValue(x, y, cellValue);
		} else {
		    numberOfCellsToZero--;
		}

		availableCells--;

		// Reset the cell value as it cannot be higher than the size of
		// the board
		if (cellValue == board.getBoardSize())
		    cellValue = 0;
	    }

	    // Shift the cell value for the next row
	    cellValue++;
	}
    }

    /**
     * Randomly returns true/false based on the availableCells and
     * numberOfCellsToZero parameters.
     * 
     * @param availableCells
     *            Number of cells available
     * @param numberOfCellsToZero
     *            Number of cells to zero
     * @return true or false depending on the chance randomly selected by
     *         checking availableCells and numberOfCellsToZero
     */
    private boolean isAllowedToSetCellValue(double availableCells,
	    double numberOfCellsToZero) {
	final double chance = numberOfCellsToZero / availableCells;

	if (random.nextDouble() <= chance) {
	    return false;
	}

	return true;
    }
}
