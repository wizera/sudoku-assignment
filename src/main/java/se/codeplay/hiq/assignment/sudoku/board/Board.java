package se.codeplay.hiq.assignment.sudoku.board;

import se.codeplay.hiq.assignment.sudoku.generator.BoardGenerator;
import se.codeplay.hiq.assignment.sudoku.generator.RowColumnShuffler;

public class Board {

    private static final int BOARD_MIN_SIZE = 3;
    private static final int BOARD_MAX_SIZE = 9;

    private static final int BOARD_MIN_DIFFICULTY = 10;
    private static final int BOARD_MAX_DIFFICULTY = 90;

    private static final int SHUFFLE_AMOUNT = 20;

    private final int[][] board;
    private final int size;
    private final int difficulty;

    /**
     * Initialize new board with given size, this board is limited to a square
     * shape with minimum size of 3 and maximum 9.
     * 
     * @param size
     *            The size of the board (width and height)
     * @param difficuly
     *            The difficulty specified as percentage. Allowed range 10 to
     *            90.
     */
    public Board(final int size, final int difficulty) {

	this.size = validateBoardSize(size);
	this.difficulty = validateBoardDifficulty(difficulty);

	this.board = new int[this.size][this.size];

	// Generate board values
	final BoardGenerator boardGenerator = new BoardGenerator();
	boardGenerator.generateBoardValues(this, this.difficulty);

	// Shuffle both rows and columns around randomly a number of times
	final RowColumnShuffler boardShuffler = new RowColumnShuffler();
	for (int shuffle = 0; shuffle < SHUFFLE_AMOUNT; shuffle++) {
	    boardShuffler.shuffleRowsRandomly(this);
	    boardShuffler.shuffleColumnsRandomly(this);
	}
    }

    /**
     * Check the given size constraints, returns closest valid size if out of
     * range.
     * 
     * @param size
     *            Size of board to check and adjust.
     * @return Size of board, eventually adjusted if given range is not within
     *         constraints.
     */
    private int validateBoardSize(int size) {
	if (size < BOARD_MIN_SIZE)
	    return BOARD_MIN_SIZE;

	if (size > BOARD_MAX_SIZE)
	    return BOARD_MAX_SIZE;

	return size;
    }

    /**
     * Check given difficulty level constraint, returns closest valid difficulty
     * value if out of range.
     * 
     * @param difficulty
     *            Difficulty level percentage value to check and adjust.
     * @return Difficulty level, eventually adjusted if given value is not
     *         within constraint.
     * 
     */
    private int validateBoardDifficulty(int difficulty) {
	if (difficulty < BOARD_MIN_DIFFICULTY)
	    return BOARD_MIN_DIFFICULTY;

	if (difficulty > BOARD_MAX_DIFFICULTY)
	    return BOARD_MAX_DIFFICULTY;

	return difficulty;
    }

    public int getCellValue(int x, int y) {
	return board[x][y];
    }

    public void setCellValue(int x, int y, int value) {
	board[x][y] = value;
    }

    public int getBoardSize() {
	return size;
    }

    /**
     * Prints the board layout to console using System.out
     */
    public void printBoardToConsole() {
	for (int y = 0; y < size; y++) {
	    for (int x = 0; x < size; x++) {
		System.out.print(board[x][y] + "  ");
	    }
	    System.out.println();
	}
    }
}
