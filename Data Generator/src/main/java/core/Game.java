package core;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
	
	private static ArrayList<String> createDeck() {
		
		ArrayList<String> deck = new ArrayList<String>();
		
		for (int i = 0; i < 4; i++) {
			
			String suit = "S";
			if(i == 1) suit = "C";
			else if(i == 2) suit = "H";
			else if(i == 3) suit = "D";
			
			for(int j = 2; j < 15; j++) {
				
				if(j == 11) deck.add(suit + "J");
				else if(j == 12) deck.add(suit + "Q");
				else if(j == 13) deck.add(suit + "K");
				else if(j == 14) deck.add(suit + "A");
				else deck.add(suit + new Integer(j).toString());		
			}
		}
		
		return deck;
	}
	
	public static String [] getDataSet() {
		
		//creating a deck (size 52 cards)
		ArrayList<String>deck = Game.createDeck();
		Collections.shuffle(deck);
		
		PokerStrategy strategy = new PokerStrategy();
		
		//dealing AI two cards
		ArrayList<String>AITwoCard = new ArrayList<String>();
		
		for (int i = 0; i < 2; i++) {
			AITwoCard.add(deck.remove(i));
			Collections.shuffle(deck);
		}
		//setting 5 cards aside
		ArrayList<String>fiveCards = new ArrayList<String>();
		
		for (int i = 0; i < 5; i++) {
			fiveCards.add(deck.remove(i));
			Collections.shuffle(deck);
		}
		//dealing the other player two cards (our AI doesn't know about these cards)
		ArrayList<String>otherPlayerTwoCard = new ArrayList<String>();
		for (int i = 0; i < 2; i++) {
			otherPlayerTwoCard.add(deck.get(i));
			Collections.shuffle(deck);
		}
		
		//Calculating all the 
		ArrayList<String> allPlayerHands = Calculations.findAIHands(Combination.getCombination(deck, 2), fiveCards, deck);
		
		//ArrayList<String> allCombinations = Combination.getCombination(deck, 2);
		/*
		for(int i = 0; i < allPlayerHands.size(); i++) {
			System.out.println(i + "iteration: " + allPlayerHands.get(i));
		}
		*/
		

		
		String [] AIHand = Calculations.findBestHand((Calculations.findPlayerHands(AITwoCard, fiveCards)));
		String [] otherPlayerHand = Calculations.findBestHand((Calculations.findPlayerHands(otherPlayerTwoCard, fiveCards)));
		
		/*
		System.out.println("AIHand: ");
		for(int i = 0; i < AIHand.length; i++)System.out.print(AIHand[i] + "\t");
		System.out.println("");
		System.out.println("Other Player Hand: ");
		for(int i = 0; i < otherPlayerHand.length; i++)System.out.print(otherPlayerHand[i] + "\t");
		System.out.println("");
		System.out.println("Five other cards: ");
		for(int i = 0; i < fiveCards.size(); i++)System.out.print(fiveCards.get(i) + "\t");
		System.out.println("");
		*/
		
		String winner = "";
		if(strategy.getScore(AIHand) > strategy.getScore(otherPlayerHand)) {
			winner = "1";
		}
		else {
			winner = "0";
		}
		//System.out.println("Size of total hands is : " + allPlayerHands.size());
		int [] arr = Calculations.getPredictions(allPlayerHands);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		
		float [] floatArr = new float [arr.length];
		floatArr[0] = (float)arr[0]/(float)allPlayerHands.size();
		floatArr[1] = (float)arr[1]/(float)allPlayerHands.size();
		floatArr[2] = (float)arr[2]/(float)allPlayerHands.size();
		floatArr[3] = (float)arr[3]/(float)allPlayerHands.size();
		floatArr[4] = (float)arr[4]/(float)allPlayerHands.size();
		floatArr[5] = (float)arr[5]/(float)allPlayerHands.size();
		floatArr[6] = (float)arr[6]/(float)allPlayerHands.size();
		floatArr[7] = (float)arr[7]/(float)allPlayerHands.size();
		floatArr[8] = (float)arr[8]/(float)allPlayerHands.size();
		floatArr[9] = (float)arr[9]/(float)allPlayerHands.size();
		
		
		
		
		String AIHandType = strategy.handType(AIHand);
		
		String [] dataSet = new String [12];
		
		dataSet[0] = AIHandType;
		DecimalFormat df = new DecimalFormat("#.########");
		dataSet[1] = df.format(floatArr[0]);
		dataSet[2] = df.format(floatArr[1]);
		dataSet[3] = df.format(floatArr[2]);
		dataSet[4] = df.format(floatArr[3]);
		dataSet[5] = df.format(floatArr[4]);
		dataSet[6] = df.format(floatArr[5]);
		dataSet[7] = df.format(floatArr[6]);
		dataSet[8] = df.format(floatArr[7]);
		dataSet[9] = df.format(floatArr[8]);
		dataSet[10] = df.format(floatArr[9]);
		dataSet[11] = winner;
		
		
		return dataSet;
	}

	
	public static void main(String [] args) throws InterruptedException{
		for(int i = 0; i < 1; i++) {
			Output.write(Game.getDataSet());
		}
		System.out.println("Done");

	}
	

}
