package com.bowling.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class BowlingGameCalculatorShould {

	private BowlingGameCalculator target;

	@BeforeEach
	void setUp() {
		target = new BowlingGameCalculator();
	}

	@Test
	public void calculate_score_of_strike() {
		assertEquals(target.calculateScore("X"), 10);
	}

	@Test
	public void calculate_score_of_a_miss() {
		assertEquals(target.calculateScore("-"), 0);
	}

	@Test
	public void calculate_score_of_a_frame() {
		assertEquals(target.calculateScore("9"), 9);
	}

	@Test
	public void calculate_score_of_two_frames() {
		assertEquals(target.calculateScore("9|9"), 18);
	}
}
