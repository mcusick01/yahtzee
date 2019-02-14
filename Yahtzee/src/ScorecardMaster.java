
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
		scores = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		 
		tallyDice = new int[]{0, 0, 0, 0, 0, 0};
	}
	
	// method to count the distinct faces 
	public int[] countDice(Die[] d)
	{
		//reset tally to 0
		for(int i = 0; i < d.length; i++)
		{
			tallyDice[i] = 0;
		}
		
		//count die faces
		for(int i = 0; i < d.length; i++)
		{
			tallyDice[d[i].getFace()-1]++;
		}
		return tallyDice;
	}
	
	public boolean verify(ChoiceEnum choice, Die[] d) 
	{
		int[] tally = countDice(d); // calling method to tally dice
		System.out.print("Tally is: ");
		for(int i=0; i<tally.length; i++)
		{
			System.out.print(tally[i] + " ");
		}
		System.out.println();
		
		
		if(choice == choice.ONES) {
			if(scores[ChoiceEnum.ONES.ordinal()] == -1)
			{
				if(tally[0] > 0) {
					scores[ChoiceEnum.ONES.ordinal()] = tally[0] * 1;
				}
				else { //to handle making another choice in Player class later
					scores[ChoiceEnum.ONES.ordinal()] = 0;
				}
			}
			System.out.println("Ones score: " + scores[ChoiceEnum.ONES.ordinal()]);
		}
		else if(choice == choice.TWOS) {
			if(scores[ChoiceEnum.TWOS.ordinal()] == -1)
			{
				if(tally[1] > 0) {
					scores[ChoiceEnum.TWOS.ordinal()] = tally[1] * 2;
				}
				else { //to handle making another choice in Player class later
					scores[ChoiceEnum.TWOS.ordinal()] = 0;
				}
			}
			System.out.println("Twos score: " + scores[ChoiceEnum.TWOS.ordinal()]);
		}
		else if(choice == choice.THREES) {
			if(scores[ChoiceEnum.THREES.ordinal()] == -1)
			{
				if(tally[2] > 0) {
					scores[ChoiceEnum.THREES.ordinal()] = tally[2] * 3;
				}
				else { //to handle making another choice in Player class later
					scores[ChoiceEnum.THREES.ordinal()] = 0;
				}
			}
			System.out.println("Threes score: " + scores[ChoiceEnum.THREES.ordinal()]);
		}
		else if(choice == choice.FOURS) {
			if(scores[ChoiceEnum.FOURS.ordinal()] == -1)
			{
				if(tally[3] > 0) {
					scores[ChoiceEnum.FOURS.ordinal()] = tally[3] * 4;
				}
				else { //to handle making another choice in Player class later
					scores[ChoiceEnum.FOURS.ordinal()] = 0;
				}
			}
			System.out.println("Fours score: " + scores[ChoiceEnum.FOURS.ordinal()]);
		}
		else if(choice == choice.FIVES) {
			if(scores[ChoiceEnum.FIVES.ordinal()] == -1)
			{
				if(tally[4] > 0) {
					scores[ChoiceEnum.FIVES.ordinal()] = tally[4] * 5;
				}
				else { //to handle making another choice in Player class later
					scores[ChoiceEnum.FIVES.ordinal()] = 0;
				}
			}
			System.out.println("Fives score: " + scores[ChoiceEnum.FIVES.ordinal()]);
		}
		else if(choice == choice.SIXES) {
			if(scores[ChoiceEnum.SIXES.ordinal()] == -1)
			{
				if(tally[5] > 0) {
					scores[ChoiceEnum.SIXES.ordinal()] = tally[5] * 6;
				}
				else { //to handle making another choice in Player class later
					scores[ChoiceEnum.SIXES.ordinal()] = 0;
				}
			}
			System.out.println("Sixes score: " + scores[ChoiceEnum.SIXES.ordinal()]);
		}
		else if(choice == choice.THREE_KIND)
		{
			//check if score is writeable
			if(scores[ChoiceEnum.THREE_KIND.ordinal()] == -1)
			{
				//check if there is three of a kind
				for(int i = 0; i < tally.length; i++)
				{
					if(tally[i] >= 3)
					{
						//if there is three of a kind, calculate score by totaling dice faces
						scores[ChoiceEnum.THREE_KIND.ordinal()] = 0;
						System.out.println("You have three of a kind!");
						for(int j = 0; j < tally.length; j++)
						{
							scores[ChoiceEnum.THREE_KIND.ordinal()] += tally[j] * (j+1);
						}
						break;
					}
					else {
						//set Three of a Kind score to 0 for now
						scores[ChoiceEnum.THREE_KIND.ordinal()] = 0;
					}
				}
			}
			
			System.out.println("Three of a kind score: " + scores[ChoiceEnum.THREE_KIND.ordinal()]);

		}
		else if(choice == choice.FOUR_KIND)
		{
			//check if score is writeable
			if(scores[ChoiceEnum.FOUR_KIND.ordinal()] == -1)
			{
				//check if there is four of a kind
				for(int i = 0; i < tally.length; i++)
				{
					if(tally[i] >= 4)
					{
						//if there is three of a kind, calculate score by totaling dice faces
						scores[ChoiceEnum.FOUR_KIND.ordinal()] = 0;
						System.out.println("You have four of a kind!");
						for(int j = 0; j < tally.length; j++)
						{
							scores[ChoiceEnum.FOUR_KIND.ordinal()] += tally[j] * (j+1);
						}
						break;
					}
					else {
						//set Four of a Kind score to 0 for now
						scores[ChoiceEnum.FOUR_KIND.ordinal()] = 0;
					}
				}
			}
			
			System.out.println("Four of a kind score: " + scores[ChoiceEnum.FOUR_KIND.ordinal()]);
		}
		else if(choice == ChoiceEnum.YAHTZEE) 
		{
			//check if there is a Yahtzee
			for(int i = 0; i < tally.length; i++)
			{
				if(tally[i] == 5)
				{
					if(scores[ChoiceEnum.YAHTZEE.ordinal()] >= 50) 
					{
						//player has already scored a yahtzee
						scores[ChoiceEnum.YAHTZEE.ordinal()] += 100;
					}
					else {
						//player has NOT already scored a yahtzee
						scores[ChoiceEnum.YAHTZEE.ordinal()] = 50;
					}
					
					break;
				}
				else {
					//set Yahtzee score to 0 for now
					scores[ChoiceEnum.YAHTZEE.ordinal()] = 0;
				}
			
			}
			
			System.out.println("Yahtzee score: " + scores[ChoiceEnum.YAHTZEE.ordinal()]);
		}
		return false;
	}
	
//	public int calculate(int index, int val)
//	{
//		scores[index] += val;
////		System.out.println("Three of a kind score: " + scores[ChoiceEnum.THREE_KIND.ordinal()]);
//		return scores[index];
//	}
	
}
