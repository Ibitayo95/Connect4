import java.util.Random;

//child class of player which is non-human
public class PlayerAI extends Player {
    // inherits token from player class but adds new int variable called
    // randomchoice
    private int randomChoice;

    public PlayerAI(String token) {
        super(token);
    }

    // getting a player move from the 'AI' is just a random choice of number between
    // 1-7
    @Override
    public Move getPlayerMove() {

        Random choice = new Random();
        randomChoice = choice.nextInt(7) + 1;

        int move = randomChoice;

        return new Move(move);
    }

    // getting AI player's token
    @Override
    public String getToken() {
        return token;
    }
}
