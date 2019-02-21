import java.util.Scanner;

public class MainTest {
	public static void main( String[] args ) {
		
	Scanner input = new Scanner(System.in);
		
	Die d = new Die();
	d.roll();
	
	
	CupOfDice cd = new CupOfDice(); 
	boolean[] initRoll = {false, false, false, false, false}; //true means do not roll the die
	cd.rollCup(initRoll); 
	
//	int[] testArray = {5, 5, 5, 4, 4};
//	cd.hardCodedRoll(testArray);
//	
//	cd.getCup();
//	System.out.println();
	
	Player p1 = new Player("abc", cd);
	int rollCounter = 1;
	do {
		
		System.out.print("Do you want to roll again? ");
		if(input.nextLine().equalsIgnoreCase("y")) {
			rollCounter++;
			p1.rollAgain();
		}	
		else {
			break;
		}
		
	} while(rollCounter < 3);
		
	p1.makeChoice();
	
	//System.out.println(cd.getCup());
	
	//System.out.println(d.getFace());
//	
//	ChoiceEnum choice = ChoiceEnum.FULL_HOUSE;
//	System.out.println("Hard coded choice=" + choice);
	
	// OPTIONAL - let the user decide a score type
//	System.out.print("What score will you take? ");
//	int userChoice = input.nextInt();
//	
//	ChoiceEnum choice = null;
//	if(userChoice == 1) {
//		choice = ChoiceEnum.ONES;
//	}
	
//	ScorecardMaster s = new ScorecardMaster();
//	s.verify(choice, cd.returnCup());
//	s.printCard();
	
	}
	
	
}