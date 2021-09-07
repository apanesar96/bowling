package com.bowling.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BowlingGameCalculatorShould {

	private BowlingGameCalculator target;

	@BeforeEach
	void setUp() {
		target = new BowlingGameCalculator();
	}

	@ParameterizedTest
	@CsvSource({
			"X||, 10",
			"-||, 0",
			"9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||, 90",
			"X|5||, 15",
			"7-|5||, 12",
			"5/|1-||, 12",
			"5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5, 150",
			"X|X|X|X|X|X|X|X|X|X||XX, 300"
	})
	public void calculate_score_of_game(String game, int expectScore) {
		assertEquals(target.calculateScore(game), expectScore);
	}

}
