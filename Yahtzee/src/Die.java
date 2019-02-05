import java.util.Random; 
public class Die {
	
	private int face; 
	Random r = new Random(); 
	
	
	
	public void roll() 
	{
		face = r.nextInt(6) + 1; // fixed functionality to roll 1-6 instead of 1-5
	}
	
	public int getFace()
	{
		return face; 
	}
}
