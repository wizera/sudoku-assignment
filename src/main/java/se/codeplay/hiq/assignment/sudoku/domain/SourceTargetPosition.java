package se.codeplay.hiq.assignment.sudoku.domain;

public class SourceTargetPosition {

    private int sourcePosition;
    private int targetPosition;

    public SourceTargetPosition(int sourcePosition, int targetPosition) {
	this.sourcePosition = sourcePosition;
	this.targetPosition = targetPosition;
    }

    public int getSourcePosition() {
	return sourcePosition;
    }

    public void setSourcePosition(int sourcePosition) {
	this.sourcePosition = sourcePosition;
    }

    public int getTargetPosition() {
	return targetPosition;
    }

    public void setTargetPosition(int targetPosition) {
	this.targetPosition = targetPosition;
    }

}
