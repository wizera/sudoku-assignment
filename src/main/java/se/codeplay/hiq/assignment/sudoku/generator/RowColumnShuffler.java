package se.codeplay.hiq.assignment.sudoku.generator;

import java.util.Random;

import se.codeplay.hiq.assignment.sudoku.board.Board;
import se.codeplay.hiq.assignment.sudoku.domain.SourceTargetPosition;

public class RowColumnShuffler {

    private Random random = new Random();

    /**
     * This method shuffles two rows across the board randomly for each call.
     * 
     * @param board
     *            Reference to sudoku board object
     */
    public void shuffleRowsRandomly(Board board) {

	final SourceTargetPosition stp = getRandomSourceAndTargetPosition(board
		.getBoardSize());

	swapRow(board, stp.getSourcePosition(), stp.getTargetPosition());
    }

    /**
     * This method shuffles two columns across the board randomly for each call.
     * 
     * @param board
     *            Reference to sudoku board object
     */
    public void shuffleColumnsRandomly(Board board) {

	final SourceTargetPosition stp = getRandomSourceAndTargetPosition(board
		.getBoardSize());

	swapColumn(board, stp.getSourcePosition(), stp.getTargetPosition());
    }

    /**
     * Swaps the row at given source position with the given target position.
     * 
     * @param board
     *            Reference to sudoku board object
     * @param source
     *            Source position of the board
     * @param target
     *            Target position of the board
     */
    private void swapRow(Board board, int source, int target) {

	final int[] rowCopy = new int[board.getBoardSize()];

	for (int pos = 0; pos < board.getBoardSize(); pos++) {
	    rowCopy[pos] = board.getCellValue(target, pos);

	    board.setCellValue(target, pos, board.getCellValue(source, pos));

	    board.setCellValue(source, pos, rowCopy[pos]);
	}
    }

    /**
     * Swaps the column at given source position with the given target position.
     * 
     * @param board
     *            Reference to sudoku board object
     * @param source
     *            Source position of the board
     * @param target
     *            Target position of the board
     */
    private void swapColumn(Board board, int source, int target) {

	final int[] colCopy = new int[board.getBoardSize()];

	for (int pos = 0; pos < board.getBoardSize(); pos++) {
	    colCopy[pos] = board.getCellValue(pos, target);

	    board.setCellValue(pos, target, board.getCellValue(pos, source));

	    board.setCellValue(pos, source, colCopy[pos]);
	}
    }

    /**
     * This method will return an object containing two uniquely randomized
     * numbers between 0 and given maxValue.
     * 
     * @param maxValue
     *            Max value allowed to be assigned, the size of the grid row or
     *            column.
     * @return object containing two unique numbers between 0 and maxValue, same
     *         sourcePosition number will never be returned.
     */
    private SourceTargetPosition getRandomSourceAndTargetPosition(int maxValue) {

	if (maxValue < 2) {
	    throw new RuntimeException("maxValue must be greater than 1");
	}

	int firstValue = random.nextInt(maxValue);
	int secondValue = firstValue;
	while (firstValue == secondValue) {
	    secondValue = random.nextInt(maxValue);
	}

	return new SourceTargetPosition(firstValue, secondValue);
    }
}
