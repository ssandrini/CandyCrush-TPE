package game.backend.level;

import game.backend.GameState;
import javafx.scene.paint.Color;

public class Level3 extends AbstractLevel {

    private static final int WALL_SIZE = 3;
    private static final int MAX_MOVES = 30;
    private static final int INITIAL_REMAINING = WALL_SIZE * WALL_SIZE;

    @Override
    protected GameState newState() {
        return new RemainingLevelState(MAX_MOVES, INITIAL_REMAINING);
    }

    @Override
    protected void fillCells() {
        super.fillCells();
        paintWalls();
    }

    private void paintWalls() {
        for(int i = WALL_SIZE; i < SIZE - WALL_SIZE; i++ ) {
            for(int j = WALL_SIZE; j < SIZE - WALL_SIZE; j++ ){
                g()[i][j].setColor(Color.SANDYBROWN);
            }
        }
    }

}
