import java.util.Scanner;

public class Player {
	
	String playerName;
	ScorecardMaster scoresheet;
	ChoiceEnum choice;
	boolean[] keep;
	Scanner input = new Scanner(System.in);
	
	

	Player(String n) {
		scoresheet = new ScorecardMaster();
		playerName = n;
		choice = null;
		keep = new boolean[5];
		
		
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void rollAgain(CupOfDice cup) {
		
		System.out.println();
		System.out.println("Which dice do you want to keep?");
		//line 1 of output formatting
		for(int i=0; i<cup.returnCup().length; i++)
		{
			System.out.print("DIE " + (i+1) + ": \t");
		}
		System.out.println();
		
		//line 2 of output formatting
		for(int i=0; i<cup.returnCup().length; i++) {	
			System.out.print(cup.returnCup()[i].getFace() + " \t");
			
		}
		System.out.println();
		
		
		String keep_or_roll = "";
		do 
		{
			System.out.println("Type 'y' to hold a die, or 'n' to roll it again");
			keep_or_roll = input.nextLine();
			
			for(int i=0; i<keep_or_roll.length(); i++) {
				if(keep_or_roll.charAt(i) == 'y') {
					keep[i] = true;
				}
				else {
					keep[i] = false;
				}
			}
			
		} while(keep_or_roll.length() != 5);
		
		System.out.println();
		cup.rollCup(keep, playerName);		
	}
	
	
	
	public void makeChoice(CupOfDice cup){
		
		do {
			System.out.println("Which score would you like to write to?");
			System.out.println("1: ONES");
			System.out.println("2: TWOS");
			System.out.println("3: THREES");
			System.out.println("4: FOURS");
			System.out.println("5: FIVES");
			System.out.println("6: SIXES");
			System.out.println("7: THREE OF A KIND");
			System.out.println("8: FOUR OF A KIND");
			System.out.println("9: FULL HOUSE");
			System.out.println("10: SMALL STRAIGHT");
			System.out.println("11: LARGE STRAIGHT");
			System.out.println("12: YAHTZEE");
			System.out.println("13: CHANCE");
			int userChoice = input.nextInt();
			
			
			if(userChoice == 1) {
				choice = ChoiceEnum.ONES;
			}
			else if(userChoice == 2) {
				choice = ChoiceEnum.TWOS;
			}
			else if(userChoice == 3) {
				choice = ChoiceEnum.THREES;
			}
			else if(userChoice == 4) {
				choice = ChoiceEnum.FOURS;
			}
			else if(userChoice == 5) {
				choice = ChoiceEnum.FIVES;
			}
			else if(userChoice == 6) {
				choice = ChoiceEnum.SIXES;
			}
			else if(userChoice == 7) {
				choice = ChoiceEnum.THREE_KIND;
			}
			else if(userChoice == 8) {
				choice = ChoiceEnum.FOUR_KIND;
			}
			else if(userChoice == 9) {
				choice = ChoiceEnum.FULL_HOUSE;
			}
			else if(userChoice == 10) {
				choice = ChoiceEnum.SMALL_STRAIGHT;
			}
			else if(userChoice == 11) {
				choice = ChoiceEnum.LARGE_STRAIGHT;
			}
			else if(userChoice == 12) {
				choice = ChoiceEnum.YAHTZEE;
			}
			else if(userChoice == 13) {
				choice = ChoiceEnum.CHANCE;
			}
		} while (scoresheet.verify(choice, cup.returnCup()) == false);
		
		
		scoresheet.printCard(playerName);
		
	}
	
	public void takeTurn(CupOfDice cup, boolean[] hold, String playerName) {

		cup.rollCup(hold, playerName);
		int rollCounter = 1;
		do {
			
			System.out.print("You have " + (3-rollCounter) + " roll(s) left.");

			input.nextLine();
			System.out.print("Do you want to roll again? ");
			if(input.nextLine().equalsIgnoreCase("y")) {
				rollAgain(cup);
				rollCounter++;
			}	
			else {
				input.nextLine();
				break;
			}
						
		} while(rollCounter < 3);
		
		makeChoice(cup);
	}
	
	
}
