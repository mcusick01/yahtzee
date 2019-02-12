import java.util.Arrays;

/*
 * TO DO:
 * > ask if player wants to write score as 0 when appropriate
 * > array of round scores?
 */

public class ScoreCard {

	//variables to hold score values
//	private int ones;
//	private int twos;
//	private int threes;
//	private int fours;
//	private int fives;
//	private int sixes;
	
//	private int three_kind;
//	private int four_kind;
//	private int chance;
	
	int[] scores; 
	//to handle yahtzee bonus -- increment then multiply by 100
	private int yahtzee_bonus;
	
	//bonuses, full house, yahtzee, and straights are all set values
	
	
	//variables to hold round totals
	private int round1;
	private int round2;
	private int round3;
	private int round4;
	private int round5;
	private int round6;
	
	//sum of round totals
	private int finalscore;
	
	ScoreCard() {
		//sets round scores and final score to 0 to 
		//avoid errors when totaling at the end of the game
		 round1 = 0;
		 round2 = 0;
		 round3 = 0;
		 round4 = 0;
		 round5 = 0;
		 round6 = 0;
		 finalscore = 0;
		 
		 //initialize all score values as -1 because 0 is a valid score
		 scores = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
	}
	
	
	//this method handles adding the total of the die faces
//	public boolean (ChoiceEnum choice, Die[] d) {
//		
//		if(choice == choice.ONES) {
//			for(int i=0; i<d.length; i++)
//			{
//				if(d[i].getFace() == 1){
//					ones += 1;
//				}
//			}
//			System.out.println("Ones score=" + ones);
//		}
//		else if(choice == choice.TWOS) {
//			for(int i=0; i<d.length; i++)
//			{
//				if(d[i].getFace() == 2){
//					twos += 2;
//				}
//			}
//			System.out.println("Twos score=" + twos);
//		}
//		else if(choice == choice.THREES) {
//			for(int i=0; i<d.length; i++)
//			{
//				if(d[i].getFace() == 3){
//					threes += 3;
//				}
//			}
//			System.out.println("Threes score=" + threes);
//		}
//		else if(choice == choice.FOURS) {
//			for(int i=0; i<d.length; i++)
//			{
//				if(d[i].getFace() == 4){
//					fours += 4;
//				}
//			}
//			System.out.println("Fours score=" + fours);
//		}
//		else if(choice == choice.FIVES) {
//			for(int i=0; i<d.length; i++)
//			{
//				if(d[i].getFace() == 5){
//					fives += 5;
//				}
//			}
//			System.out.println("Fives score=" + fives);
//		}
//		else if(choice == choice.SIXES) {
//			for(int i=0; i<d.length; i++)
//			{
//				if(d[i].getFace() == 6){
//					sixes += 6;
//				}
//			}
//			System.out.println("Sixes score=" + sixes);
//		}
//		else if(choice == choice.THREE_KIND) {
//			for(int i=0; i<d.length; i++)
//			{
//				//need to check for three of a kind conditions
//				//do this by sorting? small -> large values
//				//assign a pointer to first value, check next two values = val at pointer?
//				//if fails, move pointer up until it points to length-2
//				
//				//if valid, do this
//				three_kind += d[i].getFace();
//			}
//			System.out.println("Three of a kind score=" + three_kind);
//		}
//		
//		return false;		
//	}
	
	//verifies die faces match chosen score type and calculates the sum of appropriate faces
	public void verifyAndCalculateScore(ChoiceEnum choice, Die[] d)
	{
		if(choice == choice.ONES) {
			for(int i=0; i<d.length; i++)
			{
				if(d[i].getFace() == 1){
					scores[ChoiceEnum.ONES.ordinal()] += 1;
				}
			}
			System.out.println("Ones score=" + scores[ChoiceEnum.ONES.ordinal()] );
		}
		else if(choice == choice.TWOS) {
			for(int i=0; i<d.length; i++)
			{
				if(d[i].getFace() == 2){
					scores[ChoiceEnum.TWOS.ordinal()] += 2;
				}
			}
			System.out.println("TWOS score=" + scores[ChoiceEnum.TWOS.ordinal()] );
		}
		else if(choice == choice.THREES) {
			for(int i=0; i<d.length; i++)
			{
				if(d[i].getFace() == 3){
					scores[ChoiceEnum.THREES.ordinal()] += 3;
				}
			}
			System.out.println("THREES score=" + scores[ChoiceEnum.THREES.ordinal()] );
		}
		else if(choice == choice.FOURS) {
			for(int i=0; i<d.length; i++)
			{
				if(d[i].getFace() == 4){
					scores[ChoiceEnum.FOURS.ordinal()] += 4;
				}
			}
			System.out.println("FOURS score=" + scores[ChoiceEnum.FOURS.ordinal()] );
		}
		else if(choice == choice.FIVES) {
			for(int i=0; i<d.length; i++)
			{
				if(d[i].getFace() == 5){
					scores[ChoiceEnum.FIVES.ordinal()] += 5;
				}
			}
			System.out.println("FIVES score=" + scores[ChoiceEnum.FIVES.ordinal()] );
		}
		else if(choice == choice.SIXES) {
			for(int i=0; i<d.length; i++)
			{
				if(d[i].getFace() == 6){
					scores[ChoiceEnum.SIXES.ordinal()] += 6;
				}
			}
			System.out.println("SIXES score=" + scores[ChoiceEnum.SIXES.ordinal()] );
		}
		else if(choice == choice.THREE_KIND)
		{
			int tmp[] = new int[d.length];
			for(int i = 0; i < tmp.length; i++)
			{
				tmp[i] = d[i].getFace();
			}
			boolean hasThree = false; 
			Arrays.sort(tmp);
			for(int i = 1; i < tmp.length - 1; i++)
			{
			    if(tmp[i-1] == tmp[i] && tmp[i] == tmp[i+1]) 
			    {
			        hasThree = true;
			        System.out.println("Found three of a kind");
			        break;
			        
			    }
			}
			scores[ChoiceEnum.THREE_KIND.ordinal()] = 0;
			for(int i = 0; i < d.length; i++)
			{
				 scores[ChoiceEnum.THREE_KIND.ordinal()] += d[i].getFace();
			}
			System.out.println("Score: " + scores[ChoiceEnum.THREE_KIND.ordinal()]);
		}
		else if(choice == choice.FOUR_KIND)
		{
			int tmp[] = new int[d.length];
			for(int i = 0; i < tmp.length; i++)
			{
				tmp[i] = d[i].getFace();
			}
			boolean hasFour = false; 
			Arrays.sort(tmp);
			for(int i = 1; i < tmp.length - 1; i++)
			{
				// need to check logic of this if statement 
			    if((tmp[i-1] == tmp[i] && tmp[i] == tmp[i+1] && tmp[i] == tmp[i +2]) || (tmp[i-2] == tmp[i] && tmp[i-1] == tmp[i] && tmp[i] == tmp[i+1])) 
			    {
			        hasFour = true;

			    }
			    else
			    {
			    		System.out.println("Did not find four of a kind");
			    }
			}
			if(hasFour ==true)
			{
				System.out.println("Found four of a kind");
				scores[ChoiceEnum.FOUR_KIND.ordinal()] = 0;
				for(int j = 0; j < d.length; j++)
				{
					scores[ChoiceEnum.FOUR_KIND.ordinal()] += d[j].getFace();
				}
				System.out.println("Score: " + scores[ChoiceEnum.FOUR_KIND.ordinal()]);
			}
		}
	}
	
}
