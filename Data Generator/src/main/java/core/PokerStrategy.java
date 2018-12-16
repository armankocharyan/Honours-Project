package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class PokerStrategy {
	
	//Constant Variables
	static final LinkedList<Integer> SPECIAL_STRAIGHT = new LinkedList<Integer>(){{
		add(2);
		add(3);
		add(4);
		add(5);
		add(14);
	}};
	
	//Hand Identifiers:
	
	public boolean isPair(String [] hand) {
		
		
		LinkedList<String> type = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) type.add(hand[i].substring(1));
		
		int counter = 0;
		boolean foundPair = false;
		String tempType = "";
		
		for (int i = 0; i < type.size(); i++) {
			for (int j = 0; j < type.size(); j++) {
				if(type.get(i).equals(type.get(j)) ) {
					
					counter++;
					if(counter == 2) {
						if(!foundPair && !type.get(i).equals(tempType)) {
							foundPair = true;
						}
					}
					
				}
				
			}
			counter = 0;
		}
		
		return foundPair;
	}

	public boolean isTwoPair(String [] hand) {
		
		LinkedList<String> type = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) type .add(hand[i].substring(1));
		
		
		int counter = 0;
		String tempType = "";
		boolean twoOfKind = false;
		for (int i = 0; i < type.size(); i++) {
			
			for (int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j))) counter++;
			
			if(counter > 2) return false;
			
			if(counter == 2) { 
				tempType = type.get(i); 
				twoOfKind = true;
				}
			counter = 0;
			
		}
		
		if (!twoOfKind) return twoOfKind;
		
		for (int i = 0; i < type.size(); i++) {
			
			for(int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j) ) && (!type.get(i).equals(tempType))) counter++;
			
			if(counter == 2) return true;
			counter = 0;
		}
		
		
		return false;
	}

    public boolean isThreeKind(String [] hand) {
		
		LinkedList<String> type = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) type.add(hand[i].substring(1));
		
		
		int counter = 0;
		String tempType = "";
		boolean threeOfKind = false;
		
		for (int i = 0; i < type.size(); i++) {
			
			for (int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j))) counter++;
			
			if(counter > 3) return false;
			
			if(counter == 3) { 
				tempType = type.get(i); 
				threeOfKind = true;
				return true;
				}
			counter = 0;
			
		}
		
		return false;
	}
	
    public boolean isStraight(String [] hand) {
		
		LinkedList<String> type = new LinkedList<String>();
		for(int i = 0; i < hand.length; i++) type .add(hand[i].substring(1));
		
		LinkedList<Integer> intType = new LinkedList<Integer>();
		
		for(int i = 0; i < type.size(); i ++) {
			if(type.get(i).equals("J")) intType.add(11);
			else if(type.get(i).equals("Q")) intType.add(12);
			else if(type.get(i).equals("K")) intType.add(13);
			else if(type.get(i).equals("A")) intType.add(14);
			else intType.add(Integer.parseInt(type.get(i)));
		}
		
		if(intType.contains(14)) {
			if(isAceOneHelper(intType) == 4) intType.set(intType.indexOf(14), 1);
		}
		
		Collections.sort(intType);
				
		for (int i = 0; i < intType.size() - 1; i ++) {
			
			if (intType.get(i + 1) - intType.get(i) != 1)
				return false;
		}
		
		return true;
	}
    
    public boolean isFlush(String [] hand) {
		
		LinkedList<String> suit = new LinkedList<String>();
		for(int i = 0; i < hand.length; i++) suit.add(hand[i].substring(0, 1));
		
		for(int i = 0; i < suit.size(); i++) {
			
			for(int j = 0; j < suit.size(); j++) {
				
				if(! suit.get(i).equals(suit.get(j))) return false;
			}
		}
		return true;
	}
    
    public boolean isFullHouse(String [] hand) {
    	
		LinkedList<String> type = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) type .add(hand[i].substring(1));
		
		int counter = 0;
		String tempType = "";
		boolean threeOfKind = false;
		//checks to see if there is a three of a kind
		//if there is it stores the card type
		for (int i = 0; i < type.size(); i++) {
			
			for (int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j))) counter++;
			
			if(counter > 3) return false;
			
			
			if(counter == 3) { 
					tempType = type.get(i); 
					threeOfKind = true;
				}
			counter = 0;
			
		}
		
		if (!threeOfKind) return threeOfKind;
		
		//checks to see if there is a two of a kind that is 
		//not the same as the previous equation
		
		for (int i = 0; i < type.size(); i++) {
			
			for(int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j) ) && (!type.get(i).equals(tempType))) counter++;
			
			if(counter == 2) return true;
			counter = 0;
		}
		
		
		return false;
		
	}

    public boolean isFourKind(String [] hand) {
		
		LinkedList<String> type = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) type.add(hand[i].substring(1));
		
		
		int counter = 0;
		String tempType = "";
		boolean fourOfKind = false;
		
		for (int i = 0; i < type.size(); i++) {
			
			for (int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j))) counter++;
			
			if(counter > 4) return false;
			
			if(counter == 4) { 
				tempType = type.get(i); 
				fourOfKind = true;
				return true;
				}
			counter = 0;
			
		}
		
		return false;
	}
    
    public boolean isStraightFlush(String [] hand) {
	
		LinkedList<String> suit = new LinkedList<String>();
		LinkedList<String> type = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
			type.add(hand[i].substring(1));
		}
		
		//check to see if the suit is the same
		for(int i = 0; i < suit.size(); i++) {
			
			for(int j = 0; j < suit.size(); j++) {
				
				if(!suit.get(i).equals(suit.get(j))) return false;
			}
			
		}
		
		LinkedList<Integer> intType = new LinkedList<Integer>();
	
		//convert the string linked list to an int linked list
		for(int i = 0; i < type.size(); i ++) {
			if(type.get(i).equals("J")) intType.add(11);
			else if(type.get(i).equals("Q")) intType.add(12);
			else if(type.get(i).equals("K")) intType.add(13);
			else if(type.get(i).equals("A")) intType.add(14);
			else intType.add(Integer.parseInt(type.get(i)));
		}
		
		//check to see if the Ace is 1 or 14
		if(intType.containsAll(SPECIAL_STRAIGHT)) {
			intType.set(intType.indexOf(14), 1);
			Collections.sort(intType);
		}
				
		//sort the numbers from lowest to highest
		Collections.sort(intType);
		
		
		//check to see if the hand is a straight
		for (int i = 0; i < intType.size() - 1; i ++) {
			
			if (intType.get(i + 1) - intType.get(i) != 1)
				return false;
		}
		
		
		return true;
	}
    
    public boolean isRoyalFlush(String [] hand) {
		
		
		LinkedList<String> suit = new LinkedList<String>();
		LinkedList<String> type = new LinkedList<String>();
		
		//split the array into suit and type lists
		for(int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
			type.add(hand[i].substring(1));
		}
		
		//check to see if the suit is the same
		for(int i = 0; i < suit.size(); i++) {
			
			for(int j = 0; j < suit.size(); j++) {
				
				if(!suit.get(i).equals(suit.get(j))) return false;
			}
			
		}
		
		
		LinkedList<Integer> intType = new LinkedList<Integer>();
		
		//convert the string linked list to an int linked list
		for(int i = 0; i < type.size(); i ++) {
			if(type.get(i).equals("J")) intType.add(11);
			else if(type.get(i).equals("Q")) intType.add(12);
			else if(type.get(i).equals("K")) intType.add(13);
			else if(type.get(i).equals("A")) intType.add(14);
			else intType.add(Integer.parseInt(type.get(i)));
		}
		
		Collections.sort(intType);
		//for(int i = 0; i < intType.size(); i ++) System.out.print(intType.get(i) + "\t");
		
		for (int i = 0; i < intType.size() - 1; i ++) {
			
			if (intType.get(i + 1) - intType.get(i) != 1)
				return false;
		}
		
		//check to see if lowest elem is 10 and highest is ace
		if(intType.get(0) != 10 && intType.get(4) != 14) return false;
		
		return true;
	}
  
    
    
    //Returns the hand type
    public String handType(String [] hand) {
    	
    	if(isRoyalFlush(hand)) return "0.9";
    	else if(isStraightFlush(hand)) return "0.8";
    	else if(isFourKind(hand)) return "0.7";
    	else if(isFullHouse(hand)) return "0.6";
    	else if(isFlush(hand)) return "0.5";
    	else if(isStraight(hand)) return "0.4";
    	else if(isThreeKind(hand)) return "0.3";
    	else if(isTwoPair(hand)) return "0.2";
    	else if(isPair(hand)) return "0.1";
    	return "0";
    }
    
 

    
    //Get Score Function
    //used to determine the score of a hand
    public int getScore (String [] hand) {
		
		int handScore = 0;
		
		
		if(isRoyalFlush(hand)) {
			//System.out.println("Royal Flush!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 90000000;
			handScore += getSuitScore(hand, 0);
		}
		else if(isStraightFlush(hand)) {
			//System.out.println("StraightFLush Flush!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 80000000;
			handScore += getHighCardScore(hand);
			handScore += getSuitScore(hand, 0);
		}
		else if(isFourKind(hand)) {
			//System.out.println("Four of a kind!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 70000000;
			handScore += getHighSequenceScore(hand, 4);
		}
		else if(isFullHouse(hand)) {
			//System.out.println("Full House!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 60000000;
			handScore += getHighSequenceScore(hand, 3);
		}
		else if(isFlush(hand)) {
			//System.out.println("Flush!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 50000000;
			handScore += getHighCardScore(hand);
			//System.out.println("High Card Score: " + getHighCardScore(hand));
			handScore += getSuitScore(hand, 0);
			//System.out.println("get suit score: " + getSuitScore(hand, 0));
		}
		else if(isStraight(hand)) {
			//System.out.println("Straight!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 40000000;
			handScore += getHighCardScore(hand);
			//System.out.println("High Card Score: " + getHighCardScore(hand));
		}
		else if(isThreeKind(hand)) {
			//System.out.println("Three of a Kind!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 30000000;
			handScore += getHighSequenceScore(hand, 3);
		}
		else if(isTwoPair(hand)) {
			//System.out.println("Two Pair!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 20000000;
			handScore += twoPairScore(hand);
		}
		else if(isPair(hand)) {
			//System.out.println("Pair!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += 10000000;
			handScore += getHighSequenceScore(hand, 2);
			handScore += getSuitScore(hand, 0);
		}
		else{
			//System.out.println("High Card!");
			//for(int i = 0; i < hand.length; i++) System.out.print(hand[i] + "\t");
			handScore += handScore += getHighCardScore(hand);
		}
		
		
		return handScore;
	}
    
  
    
    //Helper functions

    
    public int isAceOneHelper(LinkedList<Integer> intType) {
		int counter = 0;
		
		if(intType.contains(2)) counter++;
		if(intType.contains(3)) counter++;
		if(intType.contains(4)) counter++;
		if(intType.contains(5)) counter++;
		
		
		return counter;
	}
    
    
    public int getHighSequenceScore(String [] hand , int repeat) {
		
		LinkedList<String> type = new LinkedList<String>();
		LinkedList<String> suit = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
			type.add(hand[i].substring(1));
			//System.out.print(type.get(i) + "\t");
		}
		
		int counter = 0;
		int score = 0;
		
		for (int i = 0; i < type.size(); i++) {
			
			for (int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j))) counter++;
			
			if(counter == repeat) {
				if(type.get(i).equals("J")) score += 11;
				else if(type.get(i).equals("Q")) score += 12;
				else if(type.get(i).equals("K")) score += 13;
				else if(type.get(i).equals("A")) score += 14;
				else score += 100000 * Integer.parseInt(type.get(i));
				return score;
				
			}
			counter = 0;
			
		}
		
		return score;
	}
    

	public int twoPairScore(String [] hand) {
		
		LinkedList<String> type = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) {
			type .add(hand[i].substring(1));
			//System.out.print(type.get(i) + "\t");
		}
		
		
		//System.out.print("\n");
		
		int counter = 0;
		String tempType1 = "";
		String tempType2 = "";
		
		boolean twoOfKind1 = false;
		boolean twoOfKind2 = false;
		//checks to see if there is a three of a kind
		//if there is it stores the card type
		for (int i = 0; i < type.size(); i++) {
			
			for (int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j))) counter++;
			
			if(counter > 2) return -1;
			
			if(counter == 2) { 
				if (!twoOfKind1) {
					tempType1 = type.get(i); 
					twoOfKind1 = true;
				}
					
			}
			counter = 0;
		}
		
		//checks to see if there is a two of a kind that is 
		//not the same as the previous equation
		
		for (int i = 0; i < type.size(); i++) {
			
			for(int j = 0; j < type.size(); j++) if(type.get(i).equals(type.get(j)) && (!type.get(i).equals(tempType1))) counter++;
			
			if(counter > 2) return -1;
			
			if(counter == 2) { 
				if (!twoOfKind2) {
					tempType2 = type.get(i); 
					twoOfKind2 = true;
				}
				
			}
			counter = 0;
		}
		
		String oddCard = "";
		
		int pairScore1 = 0;
		int pairScore2 = 0;
		int oddCardScore = 0;
		
		
		for(int i = 0; i < type.size(); i++)
			if( !(type.get(i).equals(tempType1)) && !(type.get(i).equals(tempType2))) oddCard = type.get(i);
		
		if(oddCard.equals(""))return -1;
		
		
		if(tempType1.equals("J")) pairScore1 += 11;
		else if(tempType1.equals("Q")) pairScore1 += 12;
		else if(tempType1.equals("K")) pairScore1 += 13;
		else if(tempType1.equals("A")) pairScore1 += 14;
		else pairScore1 += Integer.parseInt(tempType1);
		
		
		if(tempType2.equals("J")) pairScore2 += 11;
		else if(tempType2.equals("Q")) pairScore2 += 12;
		else if(tempType2.equals("K")) pairScore2 += 13;
		else if(tempType2.equals("A")) pairScore2 += 14;
		else pairScore2 += Integer.parseInt(tempType2);
		
		if(oddCard.equals("J")) oddCardScore  += 11;
		else if(oddCard.equals("Q")) oddCardScore  += 12;
		else if(oddCard.equals("K")) oddCardScore  += 13;
		else if(oddCard.equals("A")) oddCardScore  += 14;
		else oddCardScore += Integer.parseInt(oddCard);
		
		if(pairScore1 > pairScore2) return 100000 * pairScore1 + 1000 * pairScore2 + 10 * oddCardScore + getSuitScore(hand, type.indexOf(oddCard));
		else return 100000 * pairScore2 + 1000 * pairScore1 + 10 * oddCardScore + getSuitScore(hand, type.indexOf(oddCard));
		
		
	}
		

	public int getHighCardScore(String [] hand) {
		
		LinkedList<String> type = new LinkedList<String>();
		LinkedList<Integer> intType = new LinkedList<Integer>();
		
		for(int i = 0; i < hand.length; i++) type.add(hand[i].substring(1)); 
		
		
		for(int i = 0; i < type.size(); i ++) {
			if(type.get(i).equals("J")) intType.add(11);
			else if(type.get(i).equals("Q")) intType.add(12);
			else if(type.get(i).equals("K")) intType.add(13);
			else if(type.get(i).equals("A")) intType.add(14);
			else intType.add(Integer.parseInt(type.get(i)));
		}
		
		
		//check to see if the Ace is 1 or 14
		if(intType.containsAll(SPECIAL_STRAIGHT)) {
			intType.set(intType.indexOf(14), 1);
			Collections.sort(intType);
		}
				
		//sort the numbers from lowest to highest
		Collections.sort(intType);
		
		int highCard = intType.get(intType.size() - 1);
		String tempType = "";
		
		if(highCard == 1) tempType = "A";
		else if(highCard == 11) tempType = "J";
		else if(highCard == 12) tempType = "Q";
		else if(highCard == 13) tempType = "K";
		else if(highCard == 14) tempType = "A";
		else tempType = new Integer(highCard).toString();
		
		
		
		return 100000 * highCard + getSuitScore(hand, type.indexOf(tempType));
		
	}
	
	
	public int getSuitScore(String [] hand, int index) {
		
		LinkedList<String> suit = new LinkedList<String>();
		
		for(int i = 0; i < hand.length; i++) {
			suit.add(hand[i].substring(0, 1));
			//System.out.print(type.get(i) + "\t");
		}
		
		if(suit.get(index).equals("C")) return 1;
		else if(suit.get(index).equals("D")) return 2;
		else if(suit.get(index).equals("H")) return 3;
		else if(suit.get(index).equals("S")) return 4;
		
		return 0;
	}
    
    

}