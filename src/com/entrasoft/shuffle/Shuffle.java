package com.entrasoft.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Christopher Deschenes on 9/4/13. Entrasoft, Inc.
 * <p/>
 * Program to simulate shuffling and dealing from a traditional card deck
 */
public class Shuffle {

	// Setup a mapping between the card and its suit
	public ArrayList<String> cardMap = new ArrayList<String>();

	Shuffle() {
		// Maps for each suit
		// Populate Hearts
		for (int i = 0; i < 9; i++) {
			cardMap.add(Integer.toString(i + 1) + "H");
		}
		cardMap.add("JH");
		cardMap.add("QH");
		cardMap.add("KH");
		cardMap.add("AH");

		// Populate Diamonds
		for (int i = 0; i < 9; i++) {
			cardMap.add(Integer.toString(i + 1) + "D");
		}
		cardMap.add("JD");
		cardMap.add("QD");
		cardMap.add("KD");
		cardMap.add("AD");

		// Populate Spades
		for (int i = 0; i < 9; i++) {
			cardMap.add(Integer.toString(i + 1) + "S");
		}
		cardMap.add("JS");
		cardMap.add("QS");
		cardMap.add("KS");
		cardMap.add("AS");

		// Populate Clubs
		for (int i = 0; i < 9; i++) {
			cardMap.add(Integer.toString(i + 1) + "C");
		}
		cardMap.add("JC");
		cardMap.add("QC");
		cardMap.add("KC");
		cardMap.add("AC");

		// Show the unshuffled deck
		System.out.println(cardMap);

		// Shuffle the deck
		long seed = System.nanoTime();
		Collections.shuffle(cardMap, new Random(seed));

		// Show the shuffled deck
		System.out.println("Shuffled Deck");
		System.out.println(cardMap);

	}

	protected void deal(int numPlayers, int numCards) {
		// Take a randomized deck and distribute cards from the top
		String[][] hands = new String[numPlayers][numCards];
		int cardcount = 0;

		int s = cardMap.size();
		System.out.println("Size: " + s);

		for (int i = 0; i < numCards; i++) {
			for (int j = 0; j < numPlayers; j++) {
				hands[j][i] = cardMap.get(cardcount);
				cardcount++;
			}
		}

		// Output the hands
		for (int i = 0; i < numPlayers; i++) {
			int player = i + 1;
			System.out.println("\nPlayer " + player + " hand");
			for (int j = 0; j < numCards; j++) {
				System.out.println(hands[i][j]);
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shuffle myDeck = new Shuffle();
		int numberofPlayers = 5;
		int numberofCards = 5;
		myDeck.deal(numberofPlayers, numberofCards);

	}

}
