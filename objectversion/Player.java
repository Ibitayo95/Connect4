//abstract superclass called player
public abstract class Player {
    // each player should have a token (in this game red or yellow - could be any)
    protected String token;

    // constructor sets the token
    public Player(String token) {
        this.token = token;
    }

    // each player will need to have a move made
    public abstract Move getPlayerMove();

    // getter for player token
    public abstract String getToken();
}
