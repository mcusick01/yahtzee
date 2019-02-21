import java.util.Scanner;

public class Player {
	
	String playerName;
	ScorecardMaster scoresheet;
	ChoiceEnum choice;
	Die[] dice;
	CupOfDice currCup;
	boolean[] keep;
	Scanner input = new Scanner(System.in);
	
	

	Player(String n, CupOfDice cup) {
		scoresheet = new ScorecardMaster();
		playerName = n;
		choice = null;
		dice = new Die[5]; 
		keep = new boolean[5];
		
		for(int i=0; i<cup.returnCup().length; i++) {
			dice[i] = cup.returnCup()[i];
		}
		
		currCup = cup;
	}
	
	public void rollAgain() {
		
		System.out.println("Which dice do you want to keep?");
		for(int i=0; i<dice.length; i++) {
			System.out.print("DIE " + (i+1) + ": " + dice[i].getFace() + " ");
			if(input.nextLine().equalsIgnoreCase("y")) {
				keep[i] = true;
			}
			else {
				keep[i] = false;
			}
			System.out.println();
		}
		
		System.out.println();
		currCup.rollCup(keep);		
	}
	
	
	
	public void makeChoice(){
		
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
		
		scoresheet.verify(choice, dice);
		scoresheet.printCard();
		
	}
	
	
	
}
