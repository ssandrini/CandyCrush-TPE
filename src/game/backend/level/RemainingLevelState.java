package game.backend.level;

import game.backend.GameState;

public class RemainingLevelState extends GameState {
    private final int maxMoves;
    private int remaining;

    public RemainingLevelState(int maxMoves, int remaining) {
        this.maxMoves = maxMoves;
        this.remaining = remaining;
    }

    public String[] getScores() {
        return new String[]{String.format("%d", getScore()),String.format("MOVES LEFT: %d", maxMoves-getMoves()), String.format("REMAINING CELLS: %d", getRemaining())};
    }

    public boolean gameOver() {
        return playerWon() || getMoves() >= maxMoves;
    }

    public boolean playerWon() {
        return remaining == 0;
    }

    public void decreaseRemaining() {
        remaining--;
    }

    public int getRemaining() {
        return remaining;
    }

}
