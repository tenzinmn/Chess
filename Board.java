
public class Board {
    private Piece[][] board = new Piece[8][8];

    public Board() {
    }
    //Getter for a piece
    public Piece getPiece(int var1, int var2) {
        return this.board[var1][var2];
    }
    //Setter for a piece
    public void setPiece(int var1, int var2, Piece var3) {
        this.board[var1][var2] = var3;
    }
    //Method to move a piece and checking to see if it's allowed
    public boolean movePiece(int var1, int var2, int var3, int var4) {
        boolean var5 = 0 <= var1 && var1 < 8 && 0 <= var2 && var2 < 8 && 0 <= var3 && var3 < 8 && 0 <= var4 && var4 < 8;
        if (var5 && this.board[var1][var2] != null && this.board[var1][var2].isMoveLegal(this, var3, var4)) {
            this.board[var3][var4] = this.board[var1][var2];
            this.board[var3][var4].setPosition(var3, var4);
            this.board[var3][var4].pawnPromotion();
            this.board[var1][var2] = null;
            return true;
        } else {
            return false;
        }
    }
    //Method to check if a king gets taken then the game is over
    public boolean isGameOver() {
        int var1 = 0;

        for(int var2 = 0; var2 < this.board.length; ++var2) {
            for(int var3 = 0; var3 < this.board[var2].length; ++var3) {
                if (this.board[var2][var3] != null && (this.board[var2][var3].getCharacter() == 9818 || this.board[var2][var3].getCharacter() == 9812)) {
                    ++var1;
                }
            }
        }

        if (var1 < 2) {
            return true;
        } else {
            return false;
        }
    }
    //Method to declare a winner depending on whose king has been taken
    public void Winner() {
        for(int var1 = 0; var1 < this.board.length; ++var1) {
            for(int var2 = 0; var2 < this.board[var1].length; ++var2) {
                if (this.board[var1][var2] != null && this.board[var1][var2].getCharacter() == 9812) {
                    System.out.println("White has won the game!");
                }

                if (this.board[var1][var2] != null && this.board[var1][var2].getCharacter() == 9818) {
                    System.out.println("Black has won the game!");
                }
            }
        }

    }
    //Method of toString to print the board border
    public String toString() {
        String var1 = " Board: \n   0 1 2 3 4 5 6 7 \n";

        for(int var2 = 0; var2 <= 7; ++var2) {
            var1 = var1 + Integer.toString(var2) + " ";

            for(int var3 = 0; var3 <= 7; ++var3) {
                if (this.board[var2][var3] != null) {
                    var1 = var1 + "|" + this.board[var2][var3].getCharacter();
                } else {
                    var1 = var1 + "| ";
                }
            }

            var1 = var1 + "| \n";
        }

        return var1;
    }
    //Method of clearing the board
    public void clear() {
        for(int var1 = 0; var1 < this.board.length; ++var1) {
            for(int var2 = 0; var2 < this.board[var1].length; ++var2) {
                this.board[var1][var2] = null;
            }
        }

    }
    //Method of making sure the right piece can only move with its corresponding moves
    public boolean verifySourceAndDestination(int var1, int var2, int var3, int var4, boolean var5) {
        return 0 <= var1 && var1 < this.board.length && 0 <= var2 && var2 < this.board.length && 0 <= var3 && var3 < this.board.length && 0 <= var4 && var4 < this.board.length && this.board[var1][var2] != null && this.board[var1][var2].getIsBlack() == var5 && (this.board[var3][var4] == null || this.board[var3][var4].getIsBlack() != var5);
    }
    //Method of pieces being able to move adjacently
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);
        return rowDiff <= 1 && colDiff <= 1;
    }

    //Method of pieces being able to move horizontally
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        // check if move is in the same row
        if (startRow != endRow) {
            return false;
        }

        // check if all spaces between start and end are empty
        int minCol = Math.min(startCol, endCol);
        int maxCol = Math.max(startCol, endCol);
        for (int col = minCol + 1; col < maxCol; col++) {
            if (board[startRow][col] != null) { // assuming board is a 2D array of pieces
                return false;
            }
        }

        return true;
    }

    //Method of pieces being able to move vertically
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        // check if move is in the same row
        if (startCol != endCol) {
            return false;
        }

        // check for pieces between start and destination
        int minRow = Math.min(startRow, endRow);
        int maxRow = Math.max(startRow, endRow);
        for (int row = minRow + 1; row < maxRow; row++) {
            if (board[row][startCol] != null) {
                return false;
            }
        }

        return true;
    }

    //Method of pieces being able to move diagonally
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        // check if move is diagonal
        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);
        if (rowDiff != colDiff) {
            return false;
        }

        // check for pieces between start and destination
        int rowDir = Integer.compare(endRow, startRow);
        int colDir = Integer.compare(endCol, startCol);
        int curRow = startRow + rowDir;
        int curCol = startCol + colDir;
        while (curRow != endRow || curCol != endCol) {
            if (board[curRow][curCol] != null) {
                return false;
            }
            curRow += rowDir;
            curCol += colDir;
        }

        return true;
    }


}



