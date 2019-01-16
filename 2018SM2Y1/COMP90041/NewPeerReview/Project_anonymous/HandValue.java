/** A playing card rank type designed for cribbage. 
 * main program that receives 5 cards on the command 
 * line and will print out only the number of points. 
 * 
 * Include 5 rules: 15s, Pairs, Runs, Flushes and One for his nob
 *  
 * 
 * @author Peter Schachte schachte@unimelb.edu.au
 * 
 * enter the data in run configurations/arguments to get the score 
 * for example 6C 7C 8C 9C 8S is 20 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class HandValue {
	
	/**
	 * calculate 15 s
	 * @param cards
	 * @return
	 * 
	 * add up the face values of each combination, 
	 * count the ones that sum to 15, and multiply by two.
	 */
	public static int get15s(ArrayList<Card> cards)
	{
		int sum = 0;
		// get sum
		for(int i=0;i<cards.size();i++)
		{
			sum += cards.get(i).rank.faceValue();
		}
		if(sum == 15)
			return 2;
		return 0;
	}
	
	/**
	 * calculate pairs
	 * @param cards
	 * @return
	 * 
	 * count all the combinations of two identical ranks, 
	 * and multiply by two
	 */
	public static int getPairs(ArrayList<Card> cards)
	{
		int sum = 0;
		for(int i=0;i<cards.size();i++)
		{
			for(int j=i+1;j<cards.size();j++)
			{
				if(cards.get(i).rank.toString().charAt(0) == cards.get(j).rank.toString().charAt(0))
				{
					sum += 2;
				}
			}
		}
		return sum;
	}
	
	/**
	 * calculate max runs
	 * @param cards
	 * @param hashMap
	 * @return
	 * Compute the length of each combination consisting only of cards that form a run. 
	 * Then find the maximum length; if it is 3 or more, 
	 * score one point for each card in the combination.
	 */
	public static int getMaxRuns(ArrayList<Card> cards, HashMap<String, Integer> hashMap)
	{
		if(cards.size() < 3)
			return 0;
		Collections.sort(cards, new Comparator<Card>() {

			@Override
			public int compare(Card o1, Card o2) {
				// TODO Auto-generated method stub
				return o1.rank.ordinal() - o2.rank.ordinal();
			}
		});
		
		int max = 0;
		
		// loop
		for(int i=0;i<cards.size();i++)
		{
			for(int j = i + 1;j<cards.size();j++)
			{
				// has next higher
				if(cards.get(j - 1).rank.nextHigher() != null)
				{
					if(cards.get(j - 1).rank.nextHigher().ordinal() == cards.get(j).rank.ordinal())
					{
						String str = "";
						for(int k=i;k<=j;k++)
						{
							str += cards.get(k).toString();
						}
						// not in map, no duplicate
						if(!hashMap.containsKey(str))
						{
							if(max < j - i + 1)
							{
								max = j - i + 1;
								hashMap.put(str, 1);
							}
						}
					}
					else
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
		}
		if(max >= 3)
		{
			return max;
		}
		return 0;
		
	}
	
	/**
	 * calcualte flushes
	 * @param cards
	 * @return
	 * 
	 * check if the hand cards are same suits,
	 * also check if the start card same suit 
	 */
	public static int getFlushes(ArrayList<Card> cards)
	{
		int count = 0;
		for(int i=0;i<cards.size() - 1;i++)
		{
			// judge same
			if(cards.get(i).suit == cards.get(0).suit)
			{
				count++;
			}
		}
		if(count == 4)
		{
			if(cards.get(cards.size() - 1).suit == cards.get(0).suit)
			{
				return 5;
			}
			return 4;
		}
		return 0;
	}
	
	/**
	 * calculate nobs
	 * @param cards
	 * @return
	 * 
	 * check if start card and jack have same suits
	 */
	public static int getNob(ArrayList<Card> cards)
	{
		int count = 0;
		for(int i=0;i<cards.size() - 1;i++)
		{
			// same as last one
			if(cards.get(i).suit == cards.get(cards.size() - 1).suit)
			{
				if(cards.get(i).rank.toString().charAt(0) == 'J')
				{
					count++;
				}
			}
		}
		return count;
	}
	
	
	//calculate total score and print out
	public static void main(String[] args) {
		
		int score = 0;
		int s15 = 0;
		int pairs = 0;
		int runs = 0;
		
		// get s 15
        String[][] lines = Combinations.combinations(args);
        for (String[] line : lines) {
        	ArrayList<Card> cards = new ArrayList<Card>();
            for (String str : line) {
            	cards.add(new Card(str.charAt(0), str.charAt(1)));
            }
            s15 += get15s(cards); 
        }
        score += s15;

        // get pairs
    	ArrayList<Card> cards = new ArrayList<Card>();
        for(String str : args)
        {
        	cards.add(new Card(str.charAt(0), str.charAt(1)));
        }
        pairs = getPairs(cards);
        score += pairs;
        
        // get runs
        lines = Combinations.combinations(args);
        int max_run = 0;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String[] line : lines) {
        	cards = new ArrayList<Card>();
            for (String str : line) {
            	cards.add(new Card(str.charAt(0), str.charAt(1)));
            }
            int tem = getMaxRuns(cards, hashMap);
            if(tem > max_run)
            {
            	max_run = tem;
            	runs = tem;
            }
            else if(tem == max_run)
            {
            	runs += tem;
            }
        }
        score += runs;
        
        // get flushes
        int flushes = 0;
        cards = new ArrayList<Card>();
        for(String str : args)
        {
        	cards.add(new Card(str.charAt(0), str.charAt(1)));
        }
        flushes = getFlushes(cards);
        score += flushes;

        // get nobs
        cards = new ArrayList<Card>();
        for(String str : args)
        {
        	cards.add(new Card(str.charAt(0), str.charAt(1)));
        }
        int nob = getNob(cards);
        score += nob;
        
        // print result
        System.out.println(score);
	}
	
}
