

//Purpose: evaluating the value of the cards of each palyer in Cribagge game
//
//we count the value of each player's card in hand by the Cribagge rule like"15s",
//"pairs',"runs","flush" and "one for nob", the suits and number of each card will be 
//key assessment criteria
package cribbageHandValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class HandValue {

	public static int score = 0;
	public String[] args;
	public HandValue() {
	}
	public static void main(String[] args) {
		HandValue hValue = new HandValue();
		hValue.evaluateHand(args);
	}

	/*
	 * @Test public void test(){ HandValue hValue = new HandValue();
	 * hValue.evaluateHand("AS,3H,KH,7H,2D"); System.out.println("score:"+score); }
	 */
	// C for Clubs (♣), D for Diamonds (♦), H for Hearts (♥), or a S for Spades  (♠).
	// 7♣,Q♥,2♣,J♣,9♥ 7C,QH,2C,JC,9H 0
	// A♠,3♥,K♥,7♥,K♠ AS,3H,KH,7H,KS 2
	// A♠,3♥,K♥,7♥,2♦ AS,3H,KH,7H,2D 5
	// 2♠,3♥,K♥,3♠,4♥ 2S,3H,KH,3S,4H 12
	// 6♣,7♣,8♣,9♣,8♠ 6C,7C,8C,6C,8S 20
	// 7♥,9♠,8♣,7♣,8♥ 7H,9S,8C,7C,8H 24
	// 5♥,5♠,5♣,J♦,5♦ 5H,5S,5C,JD,5D 29


	public void evaluateHand(String[] args_) {
		String[] split = args_;
		String StartCard = split[4];
		String Card_1 = split[0];
		String card_1_num = split[0].substring(0, 1);
		if (card_1_num.equals("T")) {
			card_1_num = "10";
		}
		String card_1_head = split[0].substring(1, 2);

		String Card_2 = split[1];
		String card_2_num = split[1].substring(0, 1);
		if (card_2_num.equals("T")) {
			card_2_num = "10";
		}
		String card_2_head = split[1].substring(1, 2);

		String Card_3 = split[2];
		String card_3_num = split[2].substring(0, 1);
		if (card_3_num.equals("T")) {
			card_3_num = "10";
		}
		String card_3_head = split[2].substring(1, 2);

		String Card_4 = split[3];
		String card_4_num = split[3].substring(0, 1);
		if (card_4_num.equals("T")) {
			card_4_num = "10";
		}
		String card_4_head = split[3].substring(1, 2);

		String Card_5 = split[4];
		String card_5_num = split[4].substring(0, 1);
		if (card_5_num.equals("T")) {
			card_5_num = "10";
		}
		String card_5_head = split[4].substring(1, 2);
		// All the numbers of cards have been separated.
		// The following rules are added.

		HandValue hValue = new HandValue();
		hValue.nobs(card_1_head, card_1_num, card_2_head, card_2_num, card_3_head, card_3_num, card_4_head, card_4_num,
				card_5_head, card_5_num);
		hValue.flushes(card_1_head, card_1_num, card_2_head, card_2_num, card_3_head, card_3_num, card_4_head,
				card_4_num, card_5_head, card_5_num);
		hValue.pairs(card_1_head, card_1_num, card_2_head, card_2_num, card_3_head, card_3_num, card_4_head, card_4_num,
				card_5_head, card_5_num);
		hValue._15s(card_1_head, card_1_num, card_2_head, card_2_num, card_3_head, card_3_num, card_4_head, card_4_num,
				card_5_head, card_5_num);
		hValue.runs(card_1_head, card_1_num, card_2_head, card_2_num, card_3_head, card_3_num, card_4_head, card_4_num,
				card_5_head, card_5_num);
		System.out.println(score);
	}

	
	// nobs: this method mainly find the card whose number equals to the "J", and have the same suits with StartCand
	//      and there are four possibilities, and it implements with two circles.
	public void nobs(String card_1_head, String card_1_num, String card_2_head, String card_2_num, String card_3_head,
			String card_3_num, String card_4_head, String card_4_num, String card_5_head, String card_5_num) {
		if (score < 121) {
			if (card_1_num.equals("J")) {
				if (card_1_head.equals(card_5_head)) {
					score = score + 1;
				}
			} else if (card_2_num.equals("J")) {
				if (card_2_head.equals(card_5_head)) {
					score = score + 1;
				
				}
			} else if (card_3_num.equals("J")) {
				if (card_3_head.equals(card_5_head)) {
					score = score + 1;
				
				}
			} else if (card_4_num.equals("J")) {
				if (card_4_head.equals(card_5_head)) {
					score = score + 1;
				
				}
			}
		}

	}

	
	
	// flushes: this method mainly considers about the suits of each cards. 
	//          It operates when four cards in players hand have same suits,
	//           and one bonus point when StartCard has the same suit,too.
	public void flushes(String card_1_head, String card_1_num, String card_2_head, String card_2_num,
			String card_3_head, String card_3_num, String card_4_head, String card_4_num, String card_5_head,
			String card_5_num) {
		if (card_1_head.equals(card_2_head) && card_1_head.equals(card_3_head) && card_1_head.equals(card_4_head)) {
			score = score + 4;
			if (card_1_head.equals(card_5_head)) {
				score = score + 1;
			}
		}

	}
	
	

	// pairs: this method is related to the cards which have same number. 
	//There are 10 possibilities, each counts two scores.
	public void pairs(String card_1_head, String card_1_num, String card_2_head, String card_2_num, String card_3_head,
			String card_3_num, String card_4_head, String card_4_num, String card_5_head, String card_5_num) {

		if (card_1_num.equals(card_2_num)) {
			score = score + 2;
		}
		if (card_1_num.equals(card_3_num)) {
			score = score + 2;
		}
		if (card_1_num.equals(card_4_num)) {
			score = score + 2;
		}
		if (card_1_num.equals(card_5_num)) {
			score = score + 2;
		}
		if (card_2_num.equals(card_3_num)) {
			score = score + 2;
		}
		if (card_2_num.equals(card_4_num)) {
			score = score + 2;
		}
		if (card_2_num.equals(card_5_num)) {
			score = score + 2;
		}
		if (card_3_num.equals(card_4_num)) {
			score = score + 2;
		}
		if (card_3_num.equals(card_5_num)) {
			score = score + 2;
		}
		if (card_4_num.equals(card_5_num)) {
			score = score + 2;
		}

	}

	
	
	// 15s: in this method, the number of "J","Q","K" are regard as 10 to be counted. 
	 //        There are 23 possibilities to be considered.
	public void _15s(String card_1_head, String card_1_num, String card_2_head, String card_2_num, String card_3_head,
			String card_3_num, String card_4_head, String card_4_num, String card_5_head, String card_5_num) {
		if (card_1_num.equals("J") || card_1_num.equals("Q") || card_1_num.equals("K")) {
			card_1_num = "10";
		}
		if (card_2_num.equals("J") || card_2_num.equals("Q") || card_2_num.equals("K")) {
			card_2_num = "10";
		}
		if (card_3_num.equals("J") || card_3_num.equals("Q") || card_3_num.equals("K")) {
			card_3_num = "10";
		}
		if (card_4_num.equals("J") || card_4_num.equals("Q") || card_4_num.equals("K")) {
			card_4_num = "10";
		}
		if (card_5_num.equals("J") || card_5_num.equals("Q") || card_5_num.equals("K")) {
			card_5_num = "10";
		}
		if (card_5_num.equals("A")) {
			card_5_num = "1";
		}
		if (card_4_num.equals("A")) {
			card_4_num = "1";
		}
		if (card_3_num.equals("A")) {
			card_3_num = "1";
		}
		if (card_2_num.equals("A")) {
			card_2_num = "1";
		}
		if (card_1_num.equals("A")) {
			card_1_num = "1";
		}
		// 12 13 14 15 23 24 25 34 35 45 123 124 125 134 135 145 234 235 245 345 1234 2345
		// 12345
		int num_1 = Integer.valueOf(card_1_num);
		int num_2 = Integer.valueOf(card_2_num);
		int num_3 = Integer.valueOf(card_3_num);
		int num_4 = Integer.valueOf(card_4_num);
		int num_5 = Integer.valueOf(card_5_num);

		int _12 = num_1 + num_2;
		int _13 = num_1 + num_3;
		int _14 = num_1 + num_4;
		int _15 = num_1 + num_5;
		int _23 = num_3 + num_2;
		int _24 = num_4 + num_2;
		int _25 = num_5 + num_2;
		int _34 = num_3 + num_4;
		int _35 = num_5 + num_3;
		int _45 = num_4 + num_5;
		int _123 = num_1 + num_2 + num_3;
		int _124 = num_1 + num_2 + num_4;
		int _125 = num_1 + num_2 + num_5;
		int _134 = num_1 + num_3 + num_4;
		int _135 = num_1 + num_3 + num_5;
		int _145 = num_1 + num_4 + num_5;
		int _234 = num_3 + num_2 + num_4;
		int _235 = num_3 + num_2 + num_5;
		int _245 = num_4 + num_2 + num_5;
		int _345 = num_4 + num_5 + num_3;
		int _1234 = num_1 + num_2 + num_4 + num_3;
		int _1235 = num_1 + num_2 + num_3 + num_5;
		int _1245 = num_1 + num_2 + num_4 + num_5;
		int _1345 = num_1 + num_3 + num_4 + num_5;
		int _2345 = num_2 + num_3 + num_4 + num_5;
		int _12345 = num_1 + num_2 + num_3 + num_4 + num_5;
		int[] arr = { _12, _13, _14, _15, _23, _24, _25, _34, _35, _45, _123, _124, _125, _134, _135, _145, _234, _235,
				_245, _345, _1234, _1235, _1345, _2345, _1245, _12345 };
		int count = 0;
	// traverse all of the value in the array to find those has the value of 15, and the times of finding the 15
	// in the array will be counted in the following circle.each counts can have 2 scores.
		for (int i = 0; i < arr.length; i++) {
		
			if (arr[i] == 15) {
				count++;
		     }
		}

		score = score + count * 2;

	}

	
	
	// runs: this method aims to find the continuous card in five cards. 
	// Firstly, make the number of cards in order by using QuickSort method.
	// Secondly,recording the times of the each number occurs in the array, saving in a new array.
	// Thirdly, finding the possibilities of continuous number in the array.
	// Lastly, multiplying the times of the same number and the possibilities of the continuous number
	//will be the final score.
	public void runs(String card_1_head, String card_1_num, String card_2_head, String card_2_num, String card_3_head,
			String card_3_num, String card_4_head, String card_4_num, String card_5_head, String card_5_num) {

		if (card_1_num.equals("J")) {
			card_1_num = "11";
		}
		if (card_2_num.equals("J")) {
			card_2_num = "11";
		}
		if (card_3_num.equals("J")) {
			card_3_num = "11";
		}
		if (card_4_num.equals("J")) {
			card_4_num = "11";
		}
		if (card_5_num.equals("J")) {
			card_5_num = "11";
		}

		if (card_5_num.equals("Q")) {
			card_5_num = "12";
		}
		if (card_4_num.equals("Q")) {
			card_4_num = "12";
		}
		if (card_3_num.equals("Q")) {
			card_3_num = "12";
		}
		if (card_2_num.equals("Q")) {
			card_2_num = "12";
		}
		if (card_1_num.equals("Q")) {
			card_1_num = "12";
		}

		if (card_1_num.equals("K")) {
			card_1_num = "13";
		}
		if (card_2_num.equals("K")) {
			card_2_num = "13";
		}
		if (card_3_num.equals("K")) {
			card_3_num = "13";
		}
		if (card_4_num.equals("K")) {
			card_4_num = "13";
		}
		if (card_5_num.equals("K")) {
			card_5_num = "13";
		}

		if (card_5_num.equals("A")) {
			card_5_num = "1";
		}
		if (card_4_num.equals("A")) {
			card_4_num = "1";
		}
		if (card_3_num.equals("A")) {
			card_3_num = "1";
		}
		if (card_2_num.equals("A")) {
			card_2_num = "1";
		}
		if (card_1_num.equals("A")) {
			card_1_num = "1";
		}
		int num_1 = Integer.valueOf(card_1_num);
		int num_2 = Integer.valueOf(card_2_num);
		int num_3 = Integer.valueOf(card_3_num);
		int num_4 = Integer.valueOf(card_4_num);
		int num_5 = Integer.valueOf(card_5_num);
		int[] arr = { num_1, num_2, num_3, num_4, num_5 };
		sort(arr, 0, arr.length - 1);
		// AS,3H,KH,7H,KS
	
		// The number of continuous elements in a statistical array
		int count = 1;
		// Records the adjacent equal elements in an array
		// The most equivalent number is 4.

		// int[] =
		// Count the number of different sizes in the array.
		int count_diffrent_number = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				count_diffrent_number++;
			}
		}
		// According to the number of numbers of different sizes, the new array
		// records the number of times each digit appears.
		int[] count_diff_array = new int[count_diffrent_number];
		for (int i = 0; i < count_diff_array.length; i++) {
			count_diff_array[i] = 1;
		}
		// From big to small to record different data
		int[] diffrent_number_array = new int[count_diffrent_number];
		int rec = 1;// Record the number of different numbers at the moment.
		diffrent_number_array[0] = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				diffrent_number_array[rec - 1] = arr[i];
				count_diff_array[rec - 1]++;
			}
			if (arr[i] != arr[i + 1]) {
				diffrent_number_array[rec] = arr[i + 1];
				rec++;
			}
		}
		// System.out.println("There are different sizes of numbers in the
		// array. "+count_diffrent_number+"个");
		for (int i = 0; i < arr.length - 1; i++) {
			// After sorting from small to large, if the latter number is one
			// more continuous than the previous one, the longest continuous
			// string length can be found.
			if ((arr[i] + 1 == arr[i + 1]) || (arr[i] == arr[i + 1])) {
				if (arr[i] + 1 == arr[i + 1]) {
					count++;
				} else {
					// count_eq++;
				}
			}
		}
		// Statistics the number of times each digit appears.

		//The maximum length of consecutive or equal numbers of different numbers is obtained here.
		// Calculate possible multiplier
		int times = 1;
		for (int i = 0; i < count_diff_array.length; i++) {
			times = times * count_diff_array[i];
		}
		if (count >= 3) {
			// System.out.println("count="+count+" TIMES="+times);
			// System.out.println("Not added runs "+score);
			score = score + count * times; // Each digit in consecutive figures can be added one point.
		}
		// System.out.println("The longest continuous length is "+count);


	}
//this is the QuickSort method to make the array in order.
	public static void sort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];

		while (end > start) {
			// Compare from back to front
			while (end > start && a[end] >= key) // If none is smaller than the critical value, 
//				compare the next until there is a switch position that is smaller than 
//				the critical value, and then compare from forward to backward
				end--;
			if (a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			// Back to back comparison
			while (end > start && a[start] <= key)// If there is no greater value than the key value, compare the next one
				//until there is a larger switching point than the key value.
				start++;
			if (a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			// At the end of the first cycle, the location of the key values has been determined.
			//The value on the left is smaller than the key, and the value on the right is larger than
//			the key, but the order of the two sides may be different. Make the following recursive call
		}
		// recursion
		if (start > low)
			sort(a, low, start - 1);// Left sequence. The first index position to the key value index -1
		if (end < high)
			sort(a, end + 1, high);// Right side sequence. Index +1 from the key value to the last one.
	}

}

