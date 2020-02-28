package com.bnpp.tennis;

public class TennisGame {

	GameBoard gameBoard;
	Player firstPlayer;
	Player secondPlayer;

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.gameBoard = new GameBoard(firstPlayer, secondPlayer);
	}

	GameBoard getGameBoard() {
		return gameBoard;
	}
}