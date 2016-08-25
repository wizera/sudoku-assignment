package se.codeplay.hiq.assignment.sudoku;

import se.codeplay.hiq.assignment.sudoku.board.Board;

public class Main {

    public static void main(String[] args) {

	int boardSize = 4;
	int difficulty = 50;

	if (args.length >= 2) {
	    boardSize = tryParseNumber(args[0]);
	    difficulty = tryParseNumber(args[1]);
	}

	final Board board = new Board(boardSize, difficulty);

	board.printBoardToConsole();
    }

    private static int tryParseNumber(String number) {
	try {
	    return Integer.parseInt(number);
	} catch (NumberFormatException e) {
	    throw new RuntimeException("Please provide numerical argument");
	}
    }
}
