package game.backend.level;

import game.backend.GameState;

import javafx.scene.paint.Color;

public class Level2 extends AbstractLevel {

    private static int MAX_MOVES = 30;
    private static int INITIAL_REMAINING = SIZE*SIZE;

    @Override
    protected GameState newState() {
        return new Level2.Level2State(MAX_MOVES, INITIAL_REMAINING);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        Level2State state = (Level2State) state();
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state.addMove();
            //chequeamos si es un movimiento horizontal
            if(i1 == i2) {
                for(int i = 0; i < SIZE; i++){
                    if(! g()[i1][i].hasColor()) {
                        super.g()[i1][i].setColor(Color.YELLOW);
                        state.decreaseRemaining();
                    }
                }
            }
            else {
                for(int i = 0; i < SIZE; i++){
                    if(! g()[i][j1].hasColor()) {
                        super.g()[i][j1].setColor(Color.YELLOW);
                        state.decreaseRemaining();
                    }
                }
            }
        }
        return ret;
    }

    private class Level2State extends GameState {

        private int maxMoves;
        private int remaining;

        public Level2State(int maxMoves, int remaining) {

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
