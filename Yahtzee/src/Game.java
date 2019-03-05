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
		
		// play until cards are filled
		for(ChoiceEnum c : ChoiceEnum.values()) {
			for(int i=0; i<players.length; i++) {
				players[i].takeTurn(cup, initRoll, players[i].getPlayerName());
			}
		}
		
//		//speed round for testing
//		for(int j=0; j<2; j++)
//		{
//			for(int i=0; i<players.length; i++) {
//				players[i].takeTurn(cup, initRoll, players[i].getPlayerName());
//			}
//		}
//		
		//display each player's total for each round 
		for(int j = 0; j < players.length; j++)
		{
			System.out.println(players[j].getPlayerName() + "'s total for round " + roundNum + ": " + players[j].getRoundScore(roundNum));
		}
		
	}
	
	// display the final score after all rounds are played
	public void displayFinalScore() 
	{
		for(int i = 0; i < players.length; i++)
		{
			System.out.println(players[i].getPlayerName() + "'s final score is " + ":" + players[i].getFinalScore());
		}
		Player winner = players[0]; 
		for(int j = 1; j < players.length; j++)
		{
			if(players[j].getFinalScore() > winner.getFinalScore())
			{
				winner = players[j];
			}			
		}
		System.out.println("The winner is: " + winner.getPlayerName());
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
	
			System.out.print("Play another round? ");
			playAgain = in.nextLine();
		} while(playAgain.equalsIgnoreCase("y") && roundCounter < 6);

		//declare the winner
		g.displayFinalScore();
		
	}

}
