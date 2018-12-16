package core;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestCases extends TestCase{
	
	//Testing Hand Identifying Methods
	public void testIsPairCase1() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "DA";
	      cards[2] = "D3";
	      cards[3] = "D4";
	      cards[4] = "D2";
	      
	      
	      assertEquals(true, poker.isPair(cards));
	}

	public void testIsPairCase2() {
		
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "D4";
	      cards[3] = "D5";
	      cards[4] = "D6";
	      
	      assertEquals(false, poker.isPair(cards));
	}
	
	public void testIsTwoPairCase1() {
		
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "DA";
	      cards[2] = "D3";
	      cards[3] = "D3";
	      cards[4] = "D2";
	      
	      assertEquals(true, poker.isTwoPair(cards));
	}
	
	public void testIsTwoPairCase2() {
		
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "DA";
	      cards[2] = "DQ";
	      cards[3] = "D3";
	      cards[4] = "D2";
	      
	      assertEquals(false, poker.isTwoPair(cards));
	}
	
	public void testIsThreeKindCase1() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "DA";
	      cards[2] = "D2";
	      cards[3] = "D3";
	      cards[4] = "D2";
	      
	      assertEquals(true, poker.isThreeKind(cards));
	}
	
	public void testIsThreeKindCase2() {
		PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "DA";
	      cards[2] = "D3";
	      cards[3] = "D3";
	      cards[4] = "D2";
	      
	      assertEquals(false, poker.isThreeKind(cards));
	}

	public void testIsStraightKindCase1() {
		  
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D7";
	      cards[1] = "D8";
	      cards[2] = "D9";
	      cards[3] = "H10";
	      cards[4] = "DJ";
	      
	      assertEquals(true, poker.isStraight(cards));
	}
	
	public void testIsStraightKindCase2() {
		  
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "D7";
	      cards[3] = "H5";
	      cards[4] = "D6";
	      
	      assertEquals(false, poker.isStraight(cards));
	}
	
	public void testIsFlushKindCase1() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "DQ";
	      cards[3] = "D9";
	      cards[4] = "D6";
	      
	      assertEquals(true, poker.isFlush(cards));
	}
	
	public void testIsFlushKindCase2() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "DQ";
	      cards[3] = "H9";
	      cards[4] = "D6";
	      
	      assertEquals(false, poker.isFlush(cards));
	}

	public void testIsFullHouseCase1() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "D2";
	      cards[3] = "D3";
	      cards[4] = "D2";
	      
	      assertEquals(true, poker.isFullHouse(cards));
	}
	
	public void testIsFullHouseCase2() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "D5";
	      cards[3] = "D3";
	      cards[4] = "D2";
	      
	      assertEquals(false, poker.isFullHouse(cards));
	}

	public void testIsFourKindCase1() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "CA";
	      cards[1] = "HA";
	      cards[2] = "DA";
	      cards[3] = "D3";
	      cards[4] = "SA";
	      
	      assertEquals(true, poker.isFourKind(cards));
	}
	
	public void testIsFourKindCase2() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "DA";
	      cards[1] = "DJ";
	      cards[2] = "CA";
	      cards[3] = "D3";
	      cards[4] = "HA";
	      
	      assertEquals(false, poker.isFourKind(cards));
	}
	
	public void testIsStraightFlushCase1() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D7";
	      cards[1] = "D8";
	      cards[2] = "D9";
	      cards[3] = "D10";
	      cards[4] = "DJ";
	      
	      assertEquals(true, poker.isStraightFlush(cards));
	}
	
	public void testIsStraightFlushCase2() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "S7";
	      cards[1] = "S8";
	      cards[2] = "S9";
	      cards[3] = "S10";
	      cards[4] = "DJ";
	      
	      assertEquals(false, poker.isStraightFlush(cards));
	}
	
	public void testIsRoyalFlushCase1() {
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D10";
	      cards[1] = "DQ";
	      cards[2] = "DJ";
	      cards[3] = "DK";
	      cards[4] = "DA";
	      
	      assertEquals(true, poker.isRoyalFlush(cards));
	}
	
	public void testIsRoyalFlushCase2() {
	   	  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      
	      cards[0] = "D10";
	      cards[1] = "DQ";
	      cards[2] = "DJ";
	      cards[3] = "SK";
	      cards[4] = "DA";
	      
	      assertEquals(false, poker.isRoyalFlush(cards));
	}
	
	
	public void testIsSuitCorrectCase1(){
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      String [] cards2 = new String [5];
	      
	      cards[0] = "C2";
	      cards[1] = "C3";
	      cards[2] = "C4";
	      cards[3] = "C5";
	      cards[4] = "C6";
	      
	      cards2[0] = "D2";
	      cards2[1] = "D3";
	      cards2[2] = "D4";
	      cards2[3] = "D5";
	      cards2[4] = "D6";
	      
	      assertEquals(true, poker.getScore(cards2) > poker.getScore(cards));
	}
	
	public void testIsSuitCorrectCase2(){
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      String [] cards2 = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "D4";
	      cards[3] = "D5";
	      cards[4] = "D6";
	      
	      cards2[0] = "H2";
	      cards2[1] = "H3";
	      cards2[2] = "H4";
	      cards2[3] = "H5";
	      cards2[4] = "H6";
	      
	      assertEquals(true, poker.getScore(cards2) > poker.getScore(cards));
	}
	
	public void testIsSuitCorrectCase3(){
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      String [] cards2 = new String [5];
	      
	      cards[0] = "H2";
	      cards[1] = "H3";
	      cards[2] = "H4";
	      cards[3] = "H5";
	      cards[4] = "H6";
	      
	      cards2[0] = "S2";
	      cards2[1] = "S3";
	      cards2[2] = "S4";
	      cards2[3] = "S5";
	      cards2[4] = "S6";
	      
	      assertEquals(true, poker.getScore(cards2) > poker.getScore(cards));
	}
		
	public void testIsRankCorrectCase1(){
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      String [] cards2 = new String [5];
	      
	      cards[0] = "C2";
	      cards[1] = "C3";
	      cards[2] = "C4";
	      cards[3] = "C5";
	      cards[4] = "HK";
	      
	      cards2[0] = "D2";
	      cards2[1] = "D3";
	      cards2[2] = "D4";
	      cards2[3] = "D5";
	      cards2[4] = "HA";
	      
	      assertEquals(true, poker.getScore(cards2) > poker.getScore(cards));
	}
	
	public void testIsRankCorrectCase2(){
		  PokerStrategy poker = new PokerStrategy();
	      String [] cards = new String [5];
	      String [] cards2 = new String [5];
	      
	      cards[0] = "D2";
	      cards[1] = "D3";
	      cards[2] = "D4";
	      cards[3] = "D5";
	      cards[4] = "C10";
	      
	      cards2[0] = "H2";
	      cards2[1] = "H3";
	      cards2[2] = "H4";
	      cards2[3] = "H5";
	      cards2[4] = "CJ";
	      
	      assertEquals(true, poker.getScore(cards2) > poker.getScore(cards));
	}
	

}

