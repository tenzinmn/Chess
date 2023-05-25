

public class Knight {
    private int row;
    private int col;
    private boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    /*
    Checking to see if the Knight can move correctly, and if so then making sure it
    can move up or down 2 and then left or right by 1 correctly
    */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack)) {
            if (this.row - 2 == endRow && this.col - 1 == endCol) {
                return true;
            }

            if (this.row - 1 == endRow && this.col - 2 == endCol) {
                return true;
            }

            if (this.row + 1 == endRow && this.col - 2 == endCol) {
                return true;
            }

            if (this.row + 2 == endRow && this.col - 1 == endCol) {
                return true;
            }

            if (this.row + 2 == endRow && this.col + 1 == endCol) {
                return true;
            }

            if (this.row + 1 == endRow && this.col + 2 == endCol) {
                return true;
            }

            if (this.row - 1 == endRow && this.col + 2 == endCol) {
                return true;
            }

            if (this.row - 2 == endRow && this.col + 1 == endCol) {
                return true;
            }
        }

        return false;
    }
}
