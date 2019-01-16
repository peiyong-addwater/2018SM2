/*
 * This class expresses how to evaluate a hand in the game of Cribbage.The program 
 * will receive 5 cards on the command line. The first four of the cards are hand
 * cards and the fifth card is the start card. Then, the program will only print 
 * out the number of points on hand. To achieve that object, another two classes:
 * "CribbageRank" and "Combinations"are invoked to this HandValue class.This class
 * with a main method contains all the five rules to calculate the points. They 
 * are "One for his nob","Flushes","Pairs","15s" and "Runs". 
 * 
 * @author Peter Schachte schachte@unimelb.edu.au
 * @author(As for an anonymised submission, student's name and number are not allowed to show here)
 */

import java.util.Arrays;

public class HandValue {
	
	private static String hand[];
	private String[][] combos;
	private int evalue;
	
/* A simple main method will receive cards from the command line as two-character 
 * strings,the first being an upper-case A for Ace, K for King, Q for Queen, J for
 * Jack, T for Ten,or digit between 2 and 9 for ranks 2–9. The second character 
 * should be a C for Clubs (♣), D for Diamonds (♦), H for Hearts (♥), or a S for
 * Spades (♠) to represent the suit of each cards. Then it print out the number of
 * points of these cards. 
 */	
	public static void main(String[] args) {
		HandValue h = new HandValue(args);
		for(int i=0;i<args.length-1;i++) {
			hand[i]=args[i];
		}
		System.out.println(h.evaluateHand());
	}
	
/* evaluateHand method calculates the sum of 5 different rules' results. Each addend
 * like Fifteens() comes from the following method in HandValue class.The return value
 * is the program's printing out result, which is the points on hand.
 * 
 * @return evalue, the integer total score of the cards on hand.
 * */	
	public int evaluateHand() {
		evalue=Fifteens()+Pairs()+Flushes()+Nobs()+Runs();
	    return evalue;
	}
	
/*Represent the cards on hand. Hand is the input from the command line
 *combos is invoked from Combinations.java.
 * 
 * @param  hand, all cards from the command line on hand in the type of two-character strings
 * */		
	HandValue(String[] hand) {
        this.hand = hand;
        combos = Combinations.combinations(hand);
    }
	
/* Calculate the points from "One for his nob" which means if the hand containsthe 
 * Jack of teh same suit as the start hand, 1 points scored. First, check if there's
 * a Jack on hand. Then, check if the suit of Jack is the same as the suit of the 
 * start card.
 * 
 *  @return nobPoints, the integer point from "One for his nob" rule
 * */
	private int Nobs () {
		int nobPoints = 0;
        for (int i = 0; i < hand.length-1; i++) {
            if (hand[i].contains("J") == true && (hand[i].contains("C") ==true && hand[hand.length-1].indexOf("C")!= -1)
            		||(hand[i].contains("D") ==true && hand[hand.length-1].indexOf("D")!= -1)
            		||(hand[i].contains("H") ==true && hand[hand.length-1].indexOf("H")!= -1)
            		||(hand[i].contains("S") ==true && hand[hand.length-1].indexOf("S")!= -1)) {
            	nobPoints+=1;
            	}
            nobPoints=0;
            }
        return nobPoints;
	}
      
/* Calculate the points from "Flushes" which means if all the cards in the hand 
 * are of the same suit, 4 points is scores and a further points is scored if the
 * start card is also the same suit. Firstly, check the suit of each card on hand
 * against the suit of the first card. As soon as they don't match, skip out of 
 * the routine and return that there isn't a "Flush" on hand. Otherwise, go on 
 * checking if the start card also in the flush.
 * 
 *  @return flushPoint, the integer point getting from "Flushes"
 * */
	public int Flushes() {
		int flushPoint=0;
		char suit = hand[0].charAt(1);
		for (int i = 1; i < 4; i++) {
			if (hand[i].charAt(1) != suit) {
				flushPoint=0;
				}else flushPoint=4;
			if (hand[hand.length-1].charAt(1)== suit) {
				flushPoint= 5;
				}
			}
		 return flushPoint;
		 }

/* Calculate the points from "Pairs" in where 2 points are sorted for each pair. 
 * Select two cards combinations from Combinations.java based on the cards on hand.
 * Then check if two cards have the same face value and count all the combinations 
 * of two identical ranks.
 * 
 * @return pairPoints, the integer point getting from "Pairs"
 * */
	public int Pairs () {
		int pairPoints=0;
		int i=0;
		while(i < combos.length) {
			if (combos[i].length == 2 && combos[i][0].charAt(0) == combos[i][1].charAt(0)) {
            	pairPoints=pairPoints + 2;
            }
			i++;
		}
		return pairPoints;
	}
	
/* Calculate the points from "15s" which means each distinct combinations of cards 
 * that add to 15 are scored 2 points. Firstly, find all the possible combinations and each 
 * card's faceValue based on the cards on hand. Then calculate the sum of 2 cards,3 cards,4 
 * cards,5 cards combination,to check if the sum is 15.
 * 
 * @return fifteenPoints,  the integer point getting from "Fifteens"
 * */  
	public int Fifteens () {
		Integer[] faceValue = new Integer[hand.length];
        Integer[][] combos;
        int fifteenPoints=0;
        //invoke CribbangeRank.java to obtain cards' faceValue
        int i=0;
        while(i < hand.length){
        	for (CribbageRank a : CribbageRank.values()) {
                if (hand[i].charAt(0) == a.abbrev()) {
                    faceValue[i] = a.faceValue();
                    break;
                }
            }
        	i++;
        }

        combos = Combinations.combinations(faceValue);
		// Look through the "2" sets, then the 3, 4 and 5
        while(i<6) {
        	int sum=0;
        	int j=0;
        	while(j < combos[i].length) {
        		sum += combos[i][j];
				if (sum == 15) {
					fifteenPoints=fifteenPoints + 2;
                    }
        		j++;
        	}
        	i++;
        	}
		return fifteenPoints;
	}

/*This method should be calculating the points from "Runs" rule which means 1 point is scored 
 * for each card in a 3 or more consecutive cards. But the author failed to achieve the method,
 * there are only some ideas about the algorithms. Firstly, the order of all the combinations
 * need to be sorted, Then, the longest runs should be select. Once it is found,ignore the shorter
 * runs. To check if a combination is a run, compare the card's sequence with its nextHigher and 
 * nextLower. If the difference between the card and the neighbor is 1, it is a run.
 * 
 * @return runPoints, a integer point getting from "run" rules.
 * */
//
	private int Runs() {
		int runPoints = 0;
		return runPoints;
		}
		       
   
}

