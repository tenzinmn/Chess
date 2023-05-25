

import java.util.Scanner;

public class Piece {
    private char character;
    private int row;
    private int col;
    private boolean isBlack;

    public Piece(char var1, int var2, int var3, boolean var4) {
        this.character = var1;
        this.row = var2;
        this.col = var3;
        this.isBlack = var4;
    }
    //Method of printing out the icon's of the pieces onto the board
    public boolean isMoveLegal(Board var1, int var2, int var3) {
        switch (this.character) {
            case '♔':
            case '♚':
                King var9 = new King(this.row, this.col, this.isBlack);
                return var9.isMoveLegal(var1, var2, var3);
            case '♕':
            case '♛':
                Queen var8 = new Queen(this.row, this.col, this.isBlack);
                return var8.isMoveLegal(var1, var2, var3);
            case '♖':
            case '♜':
                Rook var5 = new Rook(this.row, this.col, this.isBlack);
                return var5.isMoveLegal(var1, var2, var3);
            case '♗':
            case '♝':
                Bishop var7 = new Bishop(this.row, this.col, this.isBlack);
                return var7.isMoveLegal(var1, var2, var3);
            case '♘':
            case '♞':
                Knight var6 = new Knight(this.row, this.col, this.isBlack);
                return var6.isMoveLegal(var1, var2, var3);
            case '♙':
            case '♟':
                Pawn var4 = new Pawn(this.row, this.col, this.isBlack);
                return var4.isMoveLegal(var1, var2, var3);
            default:
                return false;
        }
    }
    //Method of setting position for the row and col to var1 and var2
    public void setPosition(int var1, int var2) {
        this.row = var1;
        this.col = var2;
    }

    public char getCharacter() {
        return this.character;
    }

    public boolean getIsBlack() {
        return this.isBlack;
    }

    public boolean equals(Piece var1) {
        return this.character == var1.character;
    }

    public String toString() {
        return "" + this.character;
    }
    //Pawn promotion method having the ability for user to input a piece listed when their pawn reaches the other side
    public boolean pawnPromotion() {
        Scanner var1;
        String var2;
        if (this.character == 9817 && this.row == 0) {
            var1 = new Scanner(System.in);
            System.out.println("Your pawn has reached the opposite side! Promote your pawn to the piece of your choice. Ex: Queen, Rook, Bishop, Knight");
            var2 = var1.nextLine();
            if (var2.equals("Rook")) {
                this.character = 9814;
            }

            if (var2.equals("Queen")) {
                this.character = 9819;
            }

            if (var2.equals("Bishop")) {
                this.character = 9821;
            }

            if (var2.equals("Knight")) {
                this.character = 9822;
            }

            return true;
        } else if (this.character == 9823 && this.row == 7) {
            var1 = new Scanner(System.in);
            System.out.println("Your pawn has reached the opposite side! Promote your pawn to the piece of your choice. Ex: Queen, Rook, Bishop, Knight");
            var2 = var1.nextLine();
            if (var2.equals("Rook")) {
                this.character = 9820;
            }

            if (var2.equals("Queen")) {
                this.character = 9813;
            }

            if (var2.equals("Bishop")) {
                this.character = 9815;
            }

            if (var2.equals("Knight")) {
                this.character = 9816;
            }

            var1.close();
            return true;
        } else {
            return false;
        }
    }
}
