
public class GameRules {
    // the GameRules class contains the rules to connect4.
    private Board board;
    private Player player1;
    private Player player2;

    // With every instance of this class, two players and a board are set up
    public GameRules() {
        board = new Board();
        player1 = new PlayerHuman("r");
        player2 = new PlayerAI("y");
    }

    // playGame method, prints out instructions and then alternates between player1
    // and player2
    public void playGame() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop your counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
        // print out an empty board
        System.out.println(board.getBoard(player1, player2));
        // while loop continues between players until a win has been declared
        while (!board.hasWon()) {
            // player 1's turn to move
            Move m1 = player1.getPlayerMove();
            board.placeCounter(player1.getToken(), player1, player2, m1.getNo());

            // check for 4 in a row horizontal
            board.checkHorizontalWin(player1);
            // check for 4 in a row vertical
            board.checkVerticalWin(player1);
            // check for 4 in a row diagonal
            board.checkDiagonalWin(player1);
            // Print out the updated board with the player 1's move
            System.out.println(board.getBoard(player1, player2));
            System.out.println("Player 1 has moved.");

            if (board.hasWon()) {
                System.out.println("\nPlayer 1 Has Won!!!");
            } else {
                // player 2
                Move m2 = player2.getPlayerMove();
                board.placeCounter(player2.getToken(), player1, player2, m2.getNo());

                // check for 4 in a row horizontal
                board.checkHorizontalWin(player2);
                // check for 4 in a row vertical
                board.checkVerticalWin(player2);
                // check for 4 in a row diagonal
                board.checkDiagonalWin(player2);
                // Print out the updated board with the player 2's move
                System.out.println(board.getBoard(player1, player2));
                System.out.println("Player 2 has moved.");

                if (board.hasWon()) {
                    System.out.println("\nPlayer 2 Has Won!!!");
                }
            }
        }

    }
}
