package game.backend.level;

import game.backend.GameState;

import javafx.scene.paint.Color;

public class Level2 extends AbstractLevel {

    private static final int MAX_MOVES = 30;
    private static final int INITIAL_REMAINING = SIZE*SIZE;

    @Override
    protected GameState newState() {
        return new RemainingLevelState(MAX_MOVES, INITIAL_REMAINING);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        RemainingLevelState state = (RemainingLevelState) state();
        if (ret = super.tryMove(i1, j1, i2, j2)) {
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
}
