package com.bowling.bowling;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Character.getNumericValue;

@SpringBootApplication
public class BowlingGameCalculator {

	private static final String FRAME_BOUNDARY = "\\|";
	private static final char STRIKE = 'X';
	private static final char MISS = '-';

	public int calculateScore(String game) {
		char[] gameThrows = game.replaceAll(FRAME_BOUNDARY, "").toCharArray();
		int score = 0;
		for (char gameThrow : gameThrows) {
			if (gameThrow == STRIKE) score += 10;
			else if (gameThrow == MISS) score += 0;
			else score += getNumericValue(gameThrow);
		}
		return score;
    }
}
