import java.io.*;

// child class of player which is human
public class PlayerHuman extends Player {

    private BufferedReader input;

    // constructor creates human player with a token and an input
    public PlayerHuman(String token) {
        super(token);
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    // getting human player's move from commandline input using BufferedReader
    @Override
    public Move getPlayerMove() {
        String playerInput = null;
        boolean checkCorrectInput = false;

        while (!checkCorrectInput) {
            try {
                playerInput = input.readLine();
            } catch (IOException e) {
                System.err.println("Caught IOException: " + e.getMessage());
            }
            try {
                int move = Integer.parseInt(playerInput);
                if (move < 0 || move > 7) {
                    System.err.println("The number you entered is not between 1 and 7! try again.");
                    checkCorrectInput = false;
                    continue;
                }
                checkCorrectInput = true;
                return new Move(move);

            } catch (NumberFormatException wrongInput) {
                System.out.println("You haven't entered a number! Please try again and enter a number between 1 and 7");
                checkCorrectInput = false;
            }
        }

        try {
            input.close();
        } catch (IOException close) {
            System.err.println("Caught IOException: " + close.getMessage());
        }

        return null;
    }

    // getting human player's token
    @Override
    public String getToken() {
        return token;
    }

}
