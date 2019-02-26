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
			
			System.out.print("Enter player " + (i+1) + " name: " );
			playerName = input.nextLine();
			
			players[i] = new Player(playerName);
		}
		
		//create cup of dice
		cup = new CupOfDice();
		initRoll = new boolean[]{false, false, false, false, false};
	}
	
	//play the game
	public void playGame(int roundNum) {
		
		System.out.println();
		System.out.println("~~~~ROUND #" + roundNum + "~~~~");
		
		//play until cards are filled
		for(ChoiceEnum c : ChoiceEnum.values()) {
			for(int i=0; i<players.length; i++) {
				players[i].takeTurn(cup, initRoll, players[i].getPlayerName());
			}
		}		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		String playAgain = "";
		int roundCounter = 0;
		
		System.out.print("How many players? " );
		int numPlayers = in.nextInt();
		
		Game g = new Game(numPlayers);
		do {
			roundCounter++;
			g.playGame(roundCounter);
			in.nextLine();
			
			//calculate the total
			System.out.println("here's where we'll show round totals...");
			
			System.out.print("Play another round? ");
			playAgain = in.nextLine();
		} while(playAgain.equalsIgnoreCase("y") && roundCounter < 6);

		//declare the winner
		System.out.println("Someone's the winner!");
	}

}
