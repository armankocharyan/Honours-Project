package core;

import java.util.ArrayList;

public class Calculations {
	
	public static String [] arrayify (ArrayList<String> someList) {
		
		String [] invalid = new String [1];
		invalid[0] = "-1";
		if(someList.size() != 5) return invalid;
		
		String [] arr = new String [someList.size()];
		
		for(int i = 0; i < someList.size(); i++) {
			arr[i] = someList.get(i);
		}
		
		return arr;
	}
	
	public static ArrayList<String> findPlayerHands(ArrayList<String> playerHand, ArrayList<String> fiveCards) {
		
		ArrayList<String> allHands = new ArrayList<String>();
		
		ArrayList<String> threeCards = Combination.getCombination(fiveCards, 3);
		ArrayList<String> twoCards = Combination.getCombination(playerHand, 2);		
		//first ten
		for(int i = 0; i < threeCards.size(); i++) {
			
			for(int j = 0; j < twoCards.size(); j++) {
				allHands.add(threeCards.get(i) + twoCards.get(j));
			}
			
		}
	     
		ArrayList<String> fourCards = Combination.getCombination(fiveCards, 4);
		ArrayList<String> oneCard = Combination.getCombination(playerHand, 1);
		//second ten
		for(int i = 0; i < fourCards.size(); i++) {
			
			for(int j = 0; j < oneCard.size(); j++) {
				allHands.add(fourCards.get(i) + oneCard.get(j));
			}
		}
		
		
		for(int i = 0; i < allHands.size(); i++) {
			allHands.set(i, allHands.get(i).substring(0, allHands.get(i).length() - 1));
		}
		
		//last card
		allHands.add(fiveCards.get(0) + " " + fiveCards.get(1) + " " + fiveCards.get(2) + " " + fiveCards.get(3) + " " + fiveCards.get(4));
		
		return allHands;
	}
	
	
	public static ArrayList<String> findAIHands(ArrayList<String> playerHand, ArrayList<String> fiveCards, ArrayList<String> deck) {
		
		ArrayList<String> allHands = new ArrayList<String>();
		
		ArrayList<String> threeCards = Combination.getCombination(fiveCards, 3);
		//first ten
		for(int i = 0; i < threeCards.size(); i++) {
			
			for(int j = 0; j < playerHand.size(); j++) {
				allHands.add(threeCards.get(i) + playerHand.get(j));
			}
			
		}
	     
		ArrayList<String> fourCards = Combination.getCombination(fiveCards, 4);
		//second ten
		for(int i = 0; i < fourCards.size(); i++) {
			
			for(int j = 0; j < deck.size(); j++) {
				allHands.add(fourCards.get(i) + deck.get(j));
			}
		}
		
		allHands.add(fiveCards.get(0) + " " + fiveCards.get(1) + " " + fiveCards.get(2) + " " + fiveCards.get(3) + " " + fiveCards.get(4));
		
		return allHands;
	}
	

	public static String[] findBestHand(ArrayList<String> allCards) {
		String [] arr = new String [5];
		
		int bestIndex = 0;
		int highestScore = 0;
		PokerStrategy poker = new PokerStrategy();
		
		for(int i = 0; i < allCards.size(); i++) {
			
			String[]hand = allCards.get(i).split(" ");
			int tempScore = poker.getScore(hand);
			
			if(tempScore > highestScore) {
				highestScore = tempScore;
				bestIndex = i;
			}
			
			
		}
		
		return allCards.get(bestIndex).split(" ");
	}
	
	
	public static int[] getPredictions(ArrayList<String> cards) {
		int [] predictions = new int[10];
		
		int highCardCounter = 0;
		int pairCounter = 0;
		int twoPairCounter = 0;
		int threeOfKindCounter = 0;
		int straightCounter = 0;
		int flushCounter = 0;
		int fullHouseCounter = 0;
		int fourOfKindCounter = 0;
		int straightFlushCounter = 0;
		int royalFlushCounter = 0;
		
		PokerStrategy strategy = new PokerStrategy();
		
		for(int i = 0; i < cards.size(); i++) {
			
			String [] hand = cards.get(i).split(" ");
			
			if(strategy.isRoyalFlush(hand)) royalFlushCounter++;
			else if(strategy.isStraightFlush(hand)) straightFlushCounter++;
			else if(strategy.isFourKind(hand)) fourOfKindCounter++;
			else if(strategy.isFullHouse(hand)) fullHouseCounter++;
			else if(strategy.isFlush(hand)) flushCounter++;
			else if(strategy.isStraight(hand)) straightCounter++;
			else if(strategy.isThreeKind(hand)) threeOfKindCounter++;
			else if(strategy.isTwoPair(hand)) twoPairCounter++;
			else if(strategy.isPair(hand)) pairCounter++;
			else highCardCounter++;
		}
		
		predictions[0] = highCardCounter;
		predictions[1] = pairCounter;
		predictions[2] = twoPairCounter;
		predictions[3] = threeOfKindCounter;
		predictions[4] = straightCounter;
		predictions[5] = flushCounter;
		predictions[6] = fullHouseCounter;
		predictions[7] = fourOfKindCounter;
		predictions[8] = straightFlushCounter;
		predictions[9] = royalFlushCounter;
		
		return predictions;
		
	}

}
