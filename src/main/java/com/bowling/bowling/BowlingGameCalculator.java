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
			if (frame.equals("-")) score += 0;
			else if (frame.equals("X")) score += 10;
			else score += parseInt(frame);
		}
		return score;
    }
}
