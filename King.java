

public class King {
    private int row;
    private int col;
    private boolean isBlack;

    public King(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    //Checking to see if the King can move correctly, and if so then making sure it can move adjacently correctly
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        return board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack) ? board.verifyAdjacent(this.row, this.col, endRow, endCol) : false;
    }
}
