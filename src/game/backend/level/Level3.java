package game.backend.level;

import game.backend.GameState;

public class Level3 extends AbstractLevel {
    //cambiarlo y poner las condiciones del nivel3(estan con la del 1)
    private static int REQUIRED_SCORE = 5000;
    private static int MAX_MOVES = 20;

    @Override
    protected GameState newState() {
        return new Level3.Level3State(REQUIRED_SCORE, MAX_MOVES);
    }

    @Override
    protected void fillCells() {
        super.fillCells();
        // falta rellenar el centro con sandybrown
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        return true;
        // aca hay que poner si un special move cae en el wall y que lo destruya
    }

    private class Level3State extends GameState {
        private long requiredScore;
        private long maxMoves;

        public Level3State(long requiredScore, int maxMoves) {
            this.requiredScore = requiredScore;
            this.maxMoves = maxMoves;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            return getScore() > requiredScore;
        }
    }
}
