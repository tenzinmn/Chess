

import java.util.Scanner;

public class Game {
    public Game() {
    }
    /*Main function of being able to list the pieces on the board and having the ability
    for to display whose turn it is and letting the user input their moves and displaying
    game over when a king has been taken
     */
    public static void main(String[] var0) {
        Board var1 = new Board();
        Fen.load("rnbkqbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBKQBNR", var1);
        boolean var2 = false;
        System.out.println(var1.toString());
        Scanner var3 = new Scanner(System.in);

        while(!var1.isGameOver()) {
            if (var2) {
                System.out.println("It is currently Black's turn to play.");
            } else {
                System.out.println("It is currently White's turn to play.");
            }

            System.out.println("What is your move? (format: [start row] [start col] [end row] [end col])");
            int var4 = var3.nextInt();
            int var5 = var3.nextInt();
            int var6 = var3.nextInt();
            int var7 = var3.nextInt();
            if (var1.movePiece(var4, var5, var6, var7)) {
                System.out.println(var1.toString());
                var2 = !var2;
            } else {
                System.out.println("Not a Possible Move! Enter a valid move");
                System.out.println(var1.toString());
            }
        }

        var1.Winner();
        var3.close();
        System.out.println("Game is Over.");
    }
}
