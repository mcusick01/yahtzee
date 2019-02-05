public class MainTest {
	public static void main( String[] args ) {
		
	Die d = new Die();
	d.roll();
	
	
	CupOfDice cd = new CupOfDice(); 
	boolean[] testBoolean = {true, false, false, false, false}; //true means do not roll the die
	cd.rollCup(testBoolean); 
	
	cd.getCup();
	
	//	System.out.println(cd.getCup());
	
	//System.out.println(d.getFace());
	
	ChoiceEnum choice = ChoiceEnum.ONES;
	System.out.println(choice);
	
	ScoreCard s = new ScoreCard();
	s.verify(choice, cd.returnCup());
	
	}
	
	
}