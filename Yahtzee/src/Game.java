import java.util.Scanner;

public class Game {
	
	Scanner input = new Scanner(System.in);
	String playerName;
	
	Player[] players;
	boolean[] initRoll;
	CupOfDice cup;

	//constructor
	Game(int numPlayers) {
				
		players = new Player[numPlayers];
		
		//create players
		for(int i=0; i<players.length; i++) {
			
			System.out.print("Enter player " + i + " name: " );
			playerName = input.nextLine();
			
			players[i] = new Player(playerName);
		}
		
		//create cup of dice
		cup = new CupOfDice();
		initRoll = new boolean[]{false, false, false, false, false};
	}
	
	//play the game
	public void playGame() {
		
		for(ChoiceEnum c : ChoiceEnum.values()) {
			
			for(int i=0; i<players.length; i++) {
				players[i].takeTurn(cup, initRoll);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many players? " );
		int numPlayers = in.nextInt();
		
		Game g = new Game(numPlayers);
		g.playGame();

	}

}
