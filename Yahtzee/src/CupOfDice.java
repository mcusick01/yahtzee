
public class CupOfDice {
	private Die[] dice = new Die[5]; 
	
	public void rollCup(boolean[] hold) 
	{
		int i; 
		for (i = 0; i < hold.length - 1; i++)
		{
			if (hold[i] == true)
			{
				dice[i].roll();
			}
		}
	}
	
	public int getCup() 
	{
		int i; 
		for (i = 0; i < dice.length - 1; i++)
		{
			return dice[i].getFace();
		}
		return 0;
	}
}
