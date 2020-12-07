package game.backend.level;

import game.backend.GameState;

public class Level1 extends AbstractLevel {
	
	private static final int REQUIRED_SCORE = 5000;
	private static final int MAX_MOVES = 20;
	
	@Override
	protected GameState newState() {
		return new Level1State(REQUIRED_SCORE, MAX_MOVES);
	}

	private static class Level1State extends GameState {
		private final long requiredScore;
		private final long maxMoves;
		
		public Level1State(long requiredScore, int maxMoves) {
			this.requiredScore = requiredScore;
			this.maxMoves = maxMoves;
		}

		public String[] getScores() {
			return new String[]{String.format("%d", getScore()), String.format("MOVES LEFT: %d", maxMoves-getMoves())};
		}
		
		public boolean gameOver() {
			return playerWon() || getMoves() >= maxMoves;
		}
		
		public boolean playerWon() {
			return getScore() > requiredScore;
		}

		public void decreaseRemaining() {
			//no hace nada por ahora//
		}
	}

}
