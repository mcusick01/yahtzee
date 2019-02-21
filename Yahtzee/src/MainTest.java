import java.util.Scanner;

public class MainTest {
	public static void main( String[] args ) {
		
	Scanner input = new Scanner(System.in);
		
	Die d = new Die();
	d.roll();
	
	
	CupOfDice cd = new CupOfDice(); 
	boolean[] testBoolean = {false, false, false, false, false}; //true means do not roll the die
	cd.rollCup(testBoolean); 
	
//	int[] testArray = {5, 5, 5, 5, 5};
//	cd.hardCodedRoll(testArray);
	
	cd.getCup();
	System.out.println();
	
	//System.out.println(cd.getCup());
	
	//System.out.println(d.getFace());
	
	ChoiceEnum choice = ChoiceEnum.ONES;
	System.out.println("Hard coded choice=" + choice);
	
	// OPTIONAL - let the user decide a score type
//	System.out.print("What score will you take? ");
//	int userChoice = input.nextInt();
//	
//	ChoiceEnum choice = null;
//	if(userChoice == 1) {
//		choice = ChoiceEnum.ONES;
//	}
	
	ScorecardMaster s = new ScorecardMaster();
	s.verify(choice, cd.returnCup());
	s.printCard();
	
	}
	
	
}