package com.bnpp.tennis;

import java.util.HashMap;

public class PointsToScoreMapper {

	private static final HashMap<Integer, String> pointsToScore = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;

		{
			put(0, "Love");
			put(1, "Fifteen");
			put(2, "Thirty");
			put(3, "Forty");
		}
	};

	public static String getScore(int points) {
		return pointsToScore.get(points);
	}

}
