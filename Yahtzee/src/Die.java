import java.util.Random; 
public class Die {
	
	private int face; 
	Random r = new Random(); 
	
	public void roll() 
	{
		face = r.nextInt(5) + 1;
	}
	
	public int getFace()
	{
		return face; 
	}
	
	public void setFace(int val)
	{
		face = val;
	}
}
