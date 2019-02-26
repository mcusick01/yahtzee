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
	
	public void rollAgain(CupOfDice cup) {
		
		System.out.println("Which dice do you want to keep?");
		for(int i=0; i<cup.returnCup().length; i++) {	
			System.out.print("DIE " + (i+1) + ": " + cup.returnCup()[i].getFace() + " ");
			if(input.nextLine().equalsIgnoreCase("y")) {
				keep[i] = true;
			}
			else {
				keep[i] = false;
			}
			System.out.println();
		}
		
		System.out.println();
		cup.rollCup(keep);		
	}
	
	
	
	public void makeChoice(CupOfDice cup){
		
		do {
			System.out.println("Which score would you like to write to?");
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
	
	public void takeTurn(CupOfDice cup, boolean[] hold) {
		cup.rollCup(hold);
		int rollCounter = 1;
		do {
			
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
		
		System.out.println("rollCounter=" + rollCounter);
		makeChoice(cup);
	}
	
	
}
