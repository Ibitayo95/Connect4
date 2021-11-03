public class Move {
    // number variable set up
    private int no;

    // constructor takes number integer sets it to the main number variable
    public Move(int no) {
        this.no = no;
    }

    // getter method to retrieve the number - which will be the player's chosen
    // column
    public int getNo() {
        return no;
    }
}
