
public class ScorecardMaster {
	
	int[] scores; 
	int[] tallyDice;
	//to handle yahtzee bonus -- increment then multiply by 100
	private int yahtzee_bonus;
	
	//sum of round totals
	private int finalscore;
	
	ScorecardMaster() {
		
		 finalscore = 0;
		 
		 //initialize all score values as -1 because 0 is a valid score
		 scores = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
		 
		 tallyDice = new int[]{0, 0, 0, 0, 0, 0};
	}
	
	// method to count the distinct faces 
	public void countDice(Die[] d)
	{
		for(int i = 0; i < d.length; i++)
		{
			if(d[i].getFace() == 1)
			{
				tallyDice[i] += 1; 
			}
			if(d[i].getFace() == 2)
			{
				tallyDice[i] += 1; 
			}
			if(d[i].getFace() == 3)
			{
				tallyDice[i] += 1; 
			}
			if(d[i].getFace() == 4)
			{
				tallyDice[i] += 1; 
			}
			if(d[i].getFace() == 5)
			{
				tallyDice[i] += 1; 
			}
			if(d[i].getFace() == 6)
			{
				tallyDice[i] += 1; 
			}
		}
	}
	
	public boolean verify(ChoiceEnum choice, Die[] d) 
	{
		countDice(d); // calling method to tally dice
		
		if(choice == choice.ONES) {
			if(scores[ChoiceEnum.ONES.ordinal()] == -1)
			{
				for(int i=0; i<d.length; i++)
				{
					if(d[i].getFace() == 1){
						calculate(ChoiceEnum.ONES.ordinal(), 1);
					}
				}
			}
			System.out.println("Ones score: " + scores[ChoiceEnum.ONES.ordinal()]);
		}
		else if(choice == choice.TWOS) {
			if(scores[ChoiceEnum.TWOS.ordinal()] == -1)
			{
				for(int i=0; i<d.length; i++)
				{
					if(d[i].getFace() == 2){
						calculate(ChoiceEnum.TWOS.ordinal(), 2);
					}
				}
			}
		}
		else if(choice == choice.THREES) {
			if(scores[ChoiceEnum.THREES.ordinal()] == -1)
			{
				for(int i=0; i<d.length; i++)
				{
					if(d[i].getFace() == 3){
						calculate(ChoiceEnum.THREES.ordinal(), 3);
					}
				}
			}
		}
		else if(choice == choice.FOURS) {
			if(scores[ChoiceEnum.FOURS.ordinal()] == -1)
			{
				for(int i=0; i<d.length; i++)
				{
					if(d[i].getFace() == 4){
						calculate(ChoiceEnum.FOURS.ordinal(), 4);
					}
				}
			}
		}
		else if(choice == choice.FIVES) {
			if(scores[ChoiceEnum.FIVES.ordinal()] == -1)
			{
				for(int i=0; i<d.length; i++)
				{
					if(d[i].getFace() == 5){
						calculate(ChoiceEnum.FIVES.ordinal(), 5);
					}
				}
			}
		}
		else if(choice == choice.SIXES) {
			if(scores[ChoiceEnum.SIXES.ordinal()] == -1)
			{
				for(int i=0; i<d.length; i++)
				{
					if(d[i].getFace() == 6){
						calculate(ChoiceEnum.SIXES.ordinal(), 6);
					}
				}
			}
		}
		else if(choice == choice.THREE_KIND)
		{
			for(int i = 0; i < tallyDice.length; i++)
			{
				if(tallyDice[i] == 3)
				{
					for(int j = 0; j < d.length; j++)
					{
						calculate(ChoiceEnum.THREE_KIND.ordinal(), d[j].getFace());
					}
				}
			}
		}
		else if(choice == choice.FOUR_KIND)
		{
			for(int i = 0; i < tallyDice.length; i++)
			{
				if(tallyDice[i] == 4)
				{
					for(int j = 0; j < d.length; j++)
					{
						calculate(ChoiceEnum.FOUR_KIND.ordinal(), d[j].getFace());
					}
				}
			}
			
			System.out.println("Four of a kind score: " + scores[ChoiceEnum.FOUR_KIND.ordinal()]);
		}
		return false;
	}
	
	public void calculate(int index, int val)
	{
		scores[index] = 0;
		scores[index] += val;
	}
	
}
