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
		if (game.equals("-")) return 0;
		if (game.equals("X")) return 10;

		return parseInt(game);
    }
}
