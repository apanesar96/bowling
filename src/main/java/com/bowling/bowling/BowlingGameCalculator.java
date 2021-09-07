package com.bowling.bowling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Integer.parseInt;

@SpringBootApplication
public class BowlingGameCalculator {

	public static void main(String[] args) {
		SpringApplication.run(BowlingGameCalculator.class, args);
	}

    public int calculateScore(String game) {
		String[] frames = game.split("\\|");
		int score = 0;
		for (String frame : frames) {
			if (frame.equals("X")) score += 10;
			else {
				char[] frameThrows = frame.toCharArray(); // split in the number
				for (char frameThrow : frameThrows) {
					if (frameThrow == '-') score += 0;
					else score += (int)frameThrow;
				}
			}
		}
		return score;
    }
}
