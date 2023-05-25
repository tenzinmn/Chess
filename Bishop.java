public class Bishop {
    private int row;
    private int col;
    private boolean isBlack;

    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    //Checking to see if the Bishop can move correctly, and if so then making sure it can move diagonally correctly
    public boolean isMoveLegal(Board board, int destRow, int destCol) {
        if (!board.verifySourceAndDestination(this.row, this.col, destRow, destCol, this.isBlack)) {
            return false;
        }
        return board.verifyDiagonal(this.row, this.col, destRow, destCol);
    }
}
