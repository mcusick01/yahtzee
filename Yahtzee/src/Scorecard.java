
public class Scorecard {
	
	int[] scores; 
	int[] tallyDice;
	//to handle yahtzee bonus -- increment then multiply by 100
	private int yahtzee_bonus;
	
	//sum of round totals
	int[] roundscores;
	
	private int finalscore; 
	
	Scorecard() {
		
		 
		//initialize all score values as -1 because 0 is a valid score
		scores = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		 
		tallyDice = new int[]{0, 0, 0, 0, 0, 0};
		
		roundscores = new int[] {0, 0, 0, 0, 0, 0};
		
		finalscore = 0; 
		
	}
	
	// method to count the distinct faces 
	public int[] countDice(Die[] d)
	{
		//reset tally to 0
		for(int i = 0; i < tallyDice.length; i++)
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
//		System.out.print("Tally is: ");
//		for(int i=0; i<tally.length; i++)
//		{
//			System.out.print(tally[i] + " ");
//		}
//		System.out.println();
		
		
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
			else {
				System.out.println("You already have a score for ones. Choose another score to write.");
				return false;
			}
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
			else {
				System.out.println("You already have a score for twos. Choose another score to write.");
				return false;
			}
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
			else {
				System.out.println("You already have a score for threes. Choose another score to write.");
				return false;
			}
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
			else {
				System.out.println("You already have a score for fours. Choose another score to write.");
				return false;
			}
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
			else {
				System.out.println("You already have a score for fives. Choose another score to write.");
				return false;
			}
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
			else {
				System.out.println("You already have a score for sixes. Choose another score to write.");
				return false;
			}
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
//						System.out.println("You have three of a kind!");
						for(int j = 0; j < tally.length; j++)
						{
							scores[ChoiceEnum.THREE_KIND.ordinal()] += tally[j] * (j+1);
						}
						break;
					}
					else {
						//set Three of a Kind score to 0 for now
						//this process will change when Player class is implemented
						scores[ChoiceEnum.THREE_KIND.ordinal()] = 0;
					}
				}
			}
			else {
				System.out.println("You already have a score for three of a kind. Choose another score to write.");
				return false;
			}

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
//						System.out.println("You have four of a kind!");
						for(int j = 0; j < tally.length; j++)
						{
							scores[ChoiceEnum.FOUR_KIND.ordinal()] += tally[j] * (j+1);
						}
						break;
					}
					else {
						//set Four of a Kind score to 0 for now
						//this process will change when Player class is implemented
						scores[ChoiceEnum.FOUR_KIND.ordinal()] = 0;
					}
				}
			}
			else {
				System.out.println("You already have a score for four of a kind. Choose another score to write.");
				return false;
			}
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
					//this process will change when Player class is implemented
					scores[ChoiceEnum.YAHTZEE.ordinal()] = 0;
				}
			
			}
		}
		else if(choice == choice.FULL_HOUSE)
		{
			//check if score is writeable
			if(scores[ChoiceEnum.FULL_HOUSE.ordinal()] == -1)
			{
				OUTER_LOOP: //label for break
				for(int i = 0; i < tally.length; i++)
				{
					for(int j = 0; j < tally.length; j++)
					{
						if((tally[i] == 2 && tally[j] == 3) || (tally[i] == 3 && tally[j] == 2))
						{
							scores[ChoiceEnum.FULL_HOUSE.ordinal()] = 25; 
							break OUTER_LOOP;
						}
						else {
							//set Full House score to 0 for now
							//this process will change when Player class is implemented
							scores[ChoiceEnum.FULL_HOUSE.ordinal()] = 0;
						}
					}
				}
			}
			else {
				System.out.println("You already have a score for full house. Choose another score to write.");
				return false;
			}
		}
		else if(choice == ChoiceEnum.SMALL_STRAIGHT) 
		{
			if(scores[ChoiceEnum.SMALL_STRAIGHT.ordinal()] == -1) {
				
				int counter = 0; 
				//Small straight is a sequence of 4 (1234, 2345, or 3456)
				for(int i = 0; i < tally.length; i++)
				{
					if(tally[i] >= 1)
					{
						counter++;
//						System.out.println(counter);
						//need at least 4 unique die (tally==1) to make a small straight
						if(counter > 3)
						{
							scores[ChoiceEnum.SMALL_STRAIGHT.ordinal()] = 30; 
							return true;
						}
						//if counter is not > 3 then keep looping through tally
					}
					else {
						//this handles making sure the unique numbers are a valid sequence
						counter = 0;
						scores[ChoiceEnum.SMALL_STRAIGHT.ordinal()] = 0; 
					}
				}
			}
			else {
				System.out.println("You already have a score for small straight. Choose another score to write.");
				return false;
			}
		}
		else if(choice == ChoiceEnum.LARGE_STRAIGHT) 
		{
			if(scores[ChoiceEnum.LARGE_STRAIGHT.ordinal()] == -1) {
				int counter = 0; 
				//Large straight is a sequence of 5 (12345 or 23456)
				for(int i = 0; i < tally.length; i++)
				{
					//need 5 unique die (tally==1) to make a lg straight
					if(tally[i] == 1)
					{
						counter++;
//						System.out.println(counter);
					}
				}
				if(counter == 5)
				{
					//there must be either no six or no one for the dice to be a valid sequence
					if(tally[0] == 0 || tally[5] == 0)
					{
						scores[ChoiceEnum.LARGE_STRAIGHT.ordinal()] = 40; 
					}
					else {
						scores[ChoiceEnum.LARGE_STRAIGHT.ordinal()] = 0;
					}
				}
				else {
					scores[ChoiceEnum.LARGE_STRAIGHT.ordinal()] = 0;
				}
			}
			else {
				System.out.println("You already have a score for large straight. Choose another score to write.");
				return false;
			}
		}
		else if(choice == ChoiceEnum.CHANCE) {
			if(scores[ChoiceEnum.CHANCE.ordinal()] == -1) {
				
				//get ready to set to actual score
				scores[ChoiceEnum.CHANCE.ordinal()] = 0;
				
				for(int i=0; i<tally.length; i++) {
					scores[ChoiceEnum.CHANCE.ordinal()] += tally[i] * (i+1); 	
				}
			}
			else {
				System.out.println("You already have a score for chance. Choose another score to write.");
				return false;
			}
		}
		return true;
	}
	
	// calculate the score for each round that is played 
	public int calculateRoundScore(int roundNum)
	{
		for(int i = 0; i < scores.length; i++)
		{
			roundscores[roundNum] += scores[i];
		}
		int upperTotal = 0;
		for(int j = 0; j < 5; j++)
		{
			upperTotal += scores[j];
		}
		if(upperTotal >= 63)
		{
			roundscores[roundNum] += 35; 
		}
		return roundscores[roundNum];
	}
	
	// calculate the final score after all rounds are played 
	public int caclulateFinalScores()
	{
		for(int i = 0; i < roundscores.length; i++)
		{
			finalscore += roundscores[i];
		}
		return finalscore; 
		
	}
	
	//print the score card
	public void printCard(String name) {
		System.out.println("********************************");
		System.out.println(name + "'S SCORECARD:");
		System.out.println("--------------------------------");
		System.out.println("SCORE TYPE: \t\t SCORE:");
		System.out.println("********************************");
		for(ChoiceEnum c : ChoiceEnum.values()) {
			if(scores[c.ordinal()] == -1) {
				//don't print out -1s, just for aesthetics
				System.out.printf("%-10s \t\t %-10s%n", c, " - ");
			}
			else {
				System.out.printf("%-10s \t\t  %-10d %n", c, scores[c.ordinal()]);
			}
		}
		
//		System.out.println();
	}
	
}
