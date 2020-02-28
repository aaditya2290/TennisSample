package com.bnpp.tennis;

public class GameBoard {
	private String boardStatus;
	private Player firstPlayer;
	private Player secondPlayer;

	GameBoard(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public void updateGamePoints() {

		int comparedPoints = firstPlayer.compareTo(secondPlayer);
		int playerPointsDifference = Math.abs(comparedPoints);

		if (firstPlayer.getPoints() > 3 || secondPlayer.getPoints() > 3 && playerPointsDifference >= 2) {
			boardStatus = comparedPoints > 0 ? firstPlayer.getName() : secondPlayer.getName() + " Wins";
		} else if (firstPlayer.getPoints() >= 3 && secondPlayer.getPoints() >= 3 && playerPointsDifference == 1) {
			boardStatus = "Advantage " + (comparedPoints > 0 ? firstPlayer.getName() : secondPlayer.getName());
		} else if (comparedPoints == 0) {
			boardStatus = firstPlayer.getPoints() < 3 ? firstPlayer.getScore() + " All" : "Deuce";
		} else {
			boardStatus = firstPlayer.getScore() + ":" + secondPlayer.getScore();
		}
	}

	String getBoardStatus() {
		return boardStatus;
	}

	@Override
	public String toString() {
		// Love all / Points / Dues
		//return String.format("%-30s%-30s", "Score Card:", boardStatus);
		return String.format(boardStatus);
	}

	public static void main(String[] args) {
		try {
			Player p1 = new Player(args[0]);
			Player p2 = new Player(args[2]);
			p1.setPoints(Integer.parseInt(args[1]));
			p2.setPoints(Integer.parseInt(args[3]));
			TennisGame t = new TennisGame(p1, p2);
			GameBoard tennisGameBoard = t.getGameBoard();
			tennisGameBoard.updateGamePoints();
			System.out.println(tennisGameBoard.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Player implements Comparable<Player> {
	private int points;
	private String name;

	Player(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Player o) {
		return points - o.points;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getScore() {
		return PointsToScoreMapper.getScore(points);
	}

}