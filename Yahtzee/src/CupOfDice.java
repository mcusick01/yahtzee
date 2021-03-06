
public class CupOfDice {
	private Die[] dice = new Die[5]; 
	
	
	//constructor to fill array with Die objects
	CupOfDice() {
		for(int i = 0; i<dice.length; i++)
		{
			dice[i] = new Die();
		}
	}
	
	public void hardCodedRoll(int[] cup)
	{
		int i; 
		for (i = 0; i < cup.length; i++)
		{
			dice[i].setFace(cup[i]);
		}
	}
	//to use in ScoreCard verify
	public Die[] returnCup()
	{
		return dice;
	}
	
	public void rollCup(boolean[] hold, String playerName) 
	{
		System.out.println(playerName + " ROLLED: ");

		//line 1 of output formatting
		for(int i=0; i<hold.length; i++)
		{
			System.out.print("DIE " + (i+1) + ": \t");
		}
		System.out.println();
		
		//line 2 of output formatting
		for (int i = 0; i < hold.length; i++)
		{
			if (hold[i] == false)
			{
				dice[i].roll();
			}
			
			System.out.print(dice[i].getFace() + " \t");
		}
		System.out.println();
	}
	
	public void getCup() 
	{		
		
		for(int i=0; i<dice.length; i++)
		{
			System.out.print(dice[i].getFace() + " ");
		}
		
//		int i; 
//		for (i = 0; i < dice.length - 1; i++)
//		{
//			return dice[i].getFace();
//		}
//		return 0; //failed
	}
}
