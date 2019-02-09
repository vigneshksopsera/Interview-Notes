package SystemDesign;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
	

/**
 * @author Vignesh Kumar Subramanian
 * 
 * 
 * Assumptions and implementation details:
 * 
 * 1. ChutesAndLadder is the main class, which has "Board" and the "Player" has nested class.
 * 2. "Player" class has "spinTheSpinner" function which every player uses to play his turn.
 * 3. Assumed board to be single-dimension array of length = 100.
 * 4. "Board" class has ladders and chutes hashmap, which captures the next position of player, once he encounters 
 * a ladder or chute. 
 * 
 * 
 * Nice to have:
 * 1. Capability of dynamically setting the ladders and chutes for each game, such that we can have different boards.
 * 
 */

public class ChutesAndLadder {
	
	class Board {
		protected int[] board;
		protected Map<Integer, Integer> ladders;
		protected Map<Integer, Integer> chutes;
		
		Board() {
			board = new int[100];
			ladders = new HashMap<>();
			chutes = new HashMap<>();
		}
	}
	
	class Player {
		// Position of the player in the board.
		private int currentPositionOfPlayer;
		private String playerName;
		
		Player(String name) {
			this.playerName = name;
			this.currentPositionOfPlayer = -1;
		}
		/*
		 * spinTheSpinner - Player uses this function to spin the spinner, which is equivalent of playing a dice.
		 * input - none
		 * output- int (The outcome will be equal probablity of 1-6 inclusive)
		 */
		protected int spinTheSpinner() {
			Random rand = new Random();
			int result = rand.nextInt(7);
			if(result == 0) result++;
			return result;
		}
		
		/*
		 * movePawn -  Player uses this function to move his pawn from current pos to new position.
		 * input - currPos(Current position of player), count(number of steps)
		 * output - int (new position)
		 */
		protected int movePawn(int currPos, int count) {
			
			int newPosition = currPos+count;
			if(newPosition > 99) return -1;
			this.currentPositionOfPlayer = newPosition;
			return this.currentPositionOfPlayer;
		}
		protected int getCurrentPosition() {
			return this.currentPositionOfPlayer;
		}
		protected void setCurrentPosition(int pos) {
			this.currentPositionOfPlayer = pos;
		}
		protected String getPlayerName() {
			return this.playerName;
		}
	}
	
	protected int numberOfTurns;
	protected int numberOfPlayers;
	
	protected Board boardObj;
	protected Player[] players;
	private boolean gameCompleted;
	private String winner;
	
	
	ChutesAndLadder(int numberOfPlayers, String[] names) {
		boardObj = new Board();
		gameCompleted = false;
		numberOfTurns = 0;
		players = new Player[numberOfPlayers];
		
		// set the number of players
		for(int i=0; i < numberOfPlayers; i++) {
			Player player = new Player(names[i]);
			players[i] = player;
		}
	}
	
	protected boolean isGameCompleted() {
		return this.gameCompleted;
	}
	protected void setGameCompleted() {
		this.gameCompleted = true;
	}
	protected void announceWinner() {
		System.out.println("The Winner is: " + this.winner);
	}
	protected void setWinner(String playerName) {
		this.winner = playerName;
	}
	
	/*
	 * startGame - Function used by the system to simulate the game of Chutes and Ladders
	 * input - none
	 * output - none
	 */
	protected void startGame() {
		
		while(!isGameCompleted()) {
			
			for(int playerNumber = 0; playerNumber < players.length; playerNumber++) {
				
				Player player = players[playerNumber];
				String playerName = player.getPlayerName();
				
				int numberOfSquaresToHop = player.spinTheSpinner();
				int currentPositionOfPlayer = player.getCurrentPosition();
				
				int nextPossiblePositionOfPlayer = player.movePawn(currentPositionOfPlayer, numberOfSquaresToHop);
				
				// Printing each turn as it goes..
				System.out.print(++numberOfTurns + " : " + playerName + " " 
				+ (currentPositionOfPlayer+1) + " ---> " + (nextPossiblePositionOfPlayer+1));
				
				//if player reaches 100th square, declare player winner
				if(checkGameIsAlreadyOver(nextPossiblePositionOfPlayer)) {
					System.out.println();
					setGameCompleted();
					setWinner(playerName);
					break;
				}
				//  scenario when position of player goes beyond 100, skip chance
				else if(nextPossiblePositionOfPlayer == -1) {
					System.out.println();
					continue;
				}
				
				//check in ladders map, if there is a ladder from current position
				else if(boardObj.ladders.containsKey(nextPossiblePositionOfPlayer)) {
					int positionElevatedFromLadder = boardObj.ladders.get(nextPossiblePositionOfPlayer);
					player.setCurrentPosition(positionElevatedFromLadder);
					nextPossiblePositionOfPlayer = positionElevatedFromLadder;
					System.out.print(" ---LADDER--- " + (nextPossiblePositionOfPlayer+1));
					if(checkGameIsAlreadyOver(nextPossiblePositionOfPlayer)) {
						System.out.println();
						setGameCompleted();
						setWinner(playerName);
						break;
					}
				}
				//check in chutes map, if there is a chute from current position
				else if(boardObj.chutes.containsKey(nextPossiblePositionOfPlayer)) {
					int positionElevatedFromLadder = boardObj.chutes.get(nextPossiblePositionOfPlayer);
					player.setCurrentPosition(positionElevatedFromLadder);
					nextPossiblePositionOfPlayer = positionElevatedFromLadder;
					System.out.print(" ---CHUTE--- " + (nextPossiblePositionOfPlayer+1));
				}
				
				System.out.println();
			}
		}
	}
	
	protected boolean checkGameIsAlreadyOver(int position) {
		if(position == boardObj.board.length-1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("(Note: min 2 players, max 4 players) Enter number of players: ");
		int numberOfPlayers = reader.nextInt(); // max 4 players
		String[] names = new String[numberOfPlayers];
		
		System.out.println("Enter their names: ");
		for(int i=0; i<numberOfPlayers; i++) {
			System.out.println("Player " + (i+1) + ": ");
			names[i] = reader.next();
		}
		reader.close();
		
		ChutesAndLadder game = new ChutesAndLadder(numberOfPlayers, names);
		
		//Add the ladders in the board
		game.boardObj.ladders.put(0, 37);
		game.boardObj.ladders.put(3, 13);
		game.boardObj.ladders.put(8, 30);
		game.boardObj.ladders.put(20, 41);
		game.boardObj.ladders.put(27, 83);
		game.boardObj.ladders.put(35, 43);
		game.boardObj.ladders.put(50, 66);
		game.boardObj.ladders.put(70, 90);
		game.boardObj.ladders.put(79, 99);
		
		//Add the chutes in the board
		game.boardObj.chutes.put(15, 5);
		game.boardObj.chutes.put(48, 10);
		game.boardObj.chutes.put(46, 26);
		game.boardObj.chutes.put(55, 52);
		game.boardObj.chutes.put(63, 59);
		game.boardObj.chutes.put(61, 18);
		game.boardObj.chutes.put(86, 23);
		game.boardObj.chutes.put(92, 72);
		game.boardObj.chutes.put(94, 74);
		game.boardObj.chutes.put(97, 77);
		
		//Start the game
		System.out.println();
		System.out.println("Game Starts.......");
		System.out.println();
		
		game.startGame();
		game.announceWinner();
	}

}
