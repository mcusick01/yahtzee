
public class MainTest {
	public static void main( String[] args ) {
		
	/*Die d = new Die();
	d.roll();
	*/
		
	CupOfDice cd = new CupOfDice(); 
	boolean[] testBoolean = {true, true, true, true, true, false};
	cd.rollCup(testBoolean); 
	
	System.out.println(cd.getCup());
	
	//System.out.println(d.getFace());
	
	}
}