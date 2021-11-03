public class Board {

    private String[][] board;
    private static boolean win;

    // each instance of the board class sets up an array and intialises win = false.
    public Board() {
        board = new String[7][8];
        win = false;
    }

    // placeCounter takes player's token and places on the board
    public void placeCounter(String player, Player player1, Player player2, int position) {
        boolean placed = false;
        if (player == player1.getToken()) {
            for (int i = board.length - 2; i >= 0; i--) {
                if (!placed) {
                    if (board[position - 1][i] == player2.getToken()) {
                        // skip
                    } else if (board[position - 1][i] != player1.getToken()) {
                        board[position - 1][i] = player1.getToken();
                        placed = true;
                    }
                }
            }
        } else {
            for (int i = board.length - 2; i >= 0; i--) {
                if (!placed) {
                    if (board[position - 1][i] == player1.getToken()) {
                        // skip
                    } else if (board[position - 1][i] != player2.getToken()) {
                        board[position - 1][i] = player2.getToken();
                        placed = true;
                    }
                }
            }
        }
    }

    // checkHorizontalWin checks to see if a player's token is matched 4 times in a
    // row horizontally
    public void checkHorizontalWin(Player x) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == x.getToken()) {
                    count++;
                    if (count >= 4) {
                        Board.win = true;
                        break;
                    }
                } else {
                    count = 0;
                }
            }
        }
    }

    // checkVerticalWin checks to see if a player's token is matched 4 times in a
    // row vertically
    public void checkVerticalWin(Player x) {
        int count = 0;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == x.getToken()) {
                    count++;
                    if (count >= 4) {
                        Board.win = true;
                        break;
                    }
                } else {
                    count = 0;
                }
            }
        }
    }

    // checkDiagonalWin checks to see if a player's token is matched 4 times
    // diagonally, either ascending or descending
    public void checkDiagonalWin(Player x) {
        // for ascending win
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == x.getToken() && board[i - 1][j + 1] == x.getToken()
                        && board[i - 2][j + 2] == x.getToken() && board[i - 3][j + 3] == x.getToken()) {
                    Board.win = true;
                    break;
                }
            }
        }
        // for descending win
        for (int i = 3; i < board.length; i++) {
            for (int j = 3; j < board[i].length; j++) {
                if (board[i][j] == x.getToken() && board[i - 1][j - 1] == x.getToken()
                        && board[i - 2][j - 2] == x.getToken() && board[i - 3][j - 3] == x.getToken()) {
                    Board.win = true;
                    break;
                }
            }
        }
    }

    // need a method to check if a column is full

    // getter method to check status of win
    public boolean hasWon() {
        return Board.win;
    }

    // method prints out the board and contains rules for how to board looks when
    // tokens are placed
    public String getBoard(Player first, Player second) {
        String b = "";
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[j][i] == first.getToken()) {
                    b += ("| " + first.getToken() + " ");
                } else if (board[j][i] == second.getToken()) {
                    b += ("| " + second.getToken() + " ");
                } else {
                    b += ("|   ");
                }
            }
            b += ("|" + "\n");
        }
        b += ("  1   2   3   4   5   6   7" + "\n");
        return b;
    }

}
