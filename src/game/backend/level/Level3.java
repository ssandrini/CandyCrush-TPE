package game.backend.level;

import game.backend.GameState;
import javafx.scene.paint.Color;

public class Level3 extends AbstractLevel {

    private static int WALL_SIZE = 3;
    private static int MAX_MOVES = 30;
    private static int INITIAL_REMAINING = WALL_SIZE * WALL_SIZE;

    @Override
    protected GameState newState() {
        return new Level3.Level3State(MAX_MOVES, INITIAL_REMAINING);
    }

    @Override
    protected void fillCells() {
        super.fillCells();
        paintWalls();
    }

    private void paintWalls() {
        for(int i = 3; i < SIZE - 3; i++ ) {
            for(int j = 3; j < SIZE - 3; j++ ){
                g()[i][j].setColor(Color.SANDYBROWN);
            }
        }
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        return super.tryMove(i1, j1, i2, j2);
    }

    private class Level3State extends GameState {

        private int maxMoves;
        private int remaining;

        public Level3State(int maxMoves, int remaining) {

            this.maxMoves = maxMoves;
            this.remaining = remaining;
        }

        public String[] getScores() {
            String[] ans = { String.format("%d", getScore()), String.format("REMAINING CELLS: %d", getRemaining())};
            return ans;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            return remaining == 0;
        }

        public void decreaseRemaining() { remaining--; }

        public int getRemaining() { return remaining; }

    }
    
}
