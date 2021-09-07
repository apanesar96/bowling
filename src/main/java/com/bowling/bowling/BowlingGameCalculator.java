package com.bowling.bowling;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Character.getNumericValue;

@SpringBootApplication
public class BowlingGameCalculator {

	private static final String FRAME_BOUNDARY = "\\|";
	private static final char STRIKE = 'X';
	private static final char SPARE = '/';
	private static final char MISS = '-';

	public int calculateScore(String game) {
		char[] gameThrows = game.replaceAll(FRAME_BOUNDARY, "").toCharArray();
		int score = 0;

		for (int i = 0; i < gameThrows.length; i++) {
			char currentThrow = gameThrows[i];
			if (currentThrow == SPARE) {
				score += calculateSpareScore(gameThrows, i);
			} else score += calculateThrowScore(currentThrow);
		}
		return score;
    }

	private int calculateSpareScore(char[] gameThrows, int currentThrowIndex) {
		char previousThrow= gameThrows[currentThrowIndex - 1];
		int previousThrowScore = calculateThrowScore(previousThrow);
		char nextThrow = gameThrows[currentThrowIndex + 1];
		int nextThrowScore = calculateThrowScore(nextThrow);

		return ((10 - previousThrowScore) + nextThrowScore);
	}

	private int calculateThrowScore(char gameThrow) {
		if (gameThrow == STRIKE) return 10;
		else if (gameThrow == MISS) return 0;

		return getNumericValue(gameThrow);
	}
}
