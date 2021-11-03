import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour {
	
	private BufferedReader input;
	private String[][] board;
	
	public MyConnectFour(){
		board = new String[7][8];
		input = new BufferedReader(new InputStreamReader(System.in));
		playGame();
	}
	
	private void playGame(){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in"); 
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		printBoard();
		boolean win = false;
		while(!win){
			// player 1
			String userInput = getUserInput();
			int move = Integer.parseInt(userInput);
			placeCounter("r", move);
			boolean hasWon = false;
			int count = 0;
			// check horizontal
			for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){
					if(board[i][j] == "r"){
						count = count + 1;
						if(count >= 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
				
			}
			// check vertical 
			count = 0;
			for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board.length; j++){
					if(board[j][i] == "r"){
						count = count + 1;
						if(count >= 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
				
			}
			printBoard();
			if(hasWon){
				System.out.println("Red Has Won!!!");
				win = true;
			}
			else{
				//player 2
				userInput = getUserInput();
				move = Integer.parseInt(userInput);
				placeCounter("y", move);
				hasWon = false;
				count = 0;
				// check horizontal
				for(int i=0; i<board.length; i++){
					for(int j=0; j<board[i].length; j++){
						if(board[i][j] == "y"){
							count = count + 1;
							if(count >= 4){
								hasWon = true;
							}
						}
						else{
							count = 0;
						}
					}
					count = 0;
				}
				// check vertical 
				count = 0;
				for(int i=0; i<board[0].length; i++){
					for(int j=0; j<board.length; j++){
						if(board[j][i] == "y"){
							count = count + 1;
							if(count >= 4){
								hasWon = true;
							}
						}
						else{
							count = 0;
						}
					}
					count = 0;
				}
				printBoard();
				if(hasWon){
					win = true;
					System.out.println("Yellow Has Won!!!");
				}
			}
			
		}
			
	}
	
	private String getUserInput(){
		String toReturn = null;
		try{			
			toReturn = input.readLine();
		}
		catch(Exception e){
			
		}
		return toReturn;
	}
	
	private void printBoard(){
		for(int i=0; i<board.length-1; i++){
			for(int j=0; j<board[i].length-1; j++){
				if(board[j][i] == "r"){
					System.out.print("| r ");
				}
				else if(board[j][i] == "y"){
					System.out.print("| y ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7");
	}
	
	private void placeCounter(String player, int position){
		boolean placed = false;
		if(player == "r"){
			for(int i = board.length-2; i>0 ; i--){
				if(!placed){
					if(board[position-1][i] == "y"){
						// skip
					}
					else if(board[position-1][i] != "r"){
						board[position-1][i] = "r";
						placed = true;
					}
				}
			}
		}
		else{
			for(int i = board.length-2; i>0 ; i--){
				if(!placed){
					if(board[position-1][i] == "r"){
						// skip
					}
					else if(board[position-1][i] != "y"){
						board[position-1][i] = "y";
						placed = true;
					} 
				}
			}
		}
	}
}
