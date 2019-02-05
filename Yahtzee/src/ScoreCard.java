
public class ScoreCard {

	//variables to hold score values
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	
	private int three_kind;
	private int four_kind;
	private int chance;
	
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
	}
	
	public boolean verify(ChoiceEnum choice, Die[] d) {
		
		if(choice == choice.ONES) {
			for(int i=0; i<d.length; i++)
			{
				if(d[i].getFace() == 1){
					ones += 1;
				}
			}
			System.out.println("Ones score=" + ones);
		}
		
		return false;		
	}
}
