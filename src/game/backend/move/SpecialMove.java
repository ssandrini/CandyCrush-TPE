package game.backend.move;

import game.backend.Grid;
import javafx.scene.paint.Color;

public abstract class SpecialMove extends Move {

    public SpecialMove(Grid grid) {
        super(grid);
    }

    @Override
    protected void clearContent(int i, int j) {
        if(grid.getCell(i,j).hasColor()) {
            if (grid.getCell(i, j).getColor().equals(Color.SANDYBROWN)) {
                grid.getCell(i, j).setColor(null);
                grid.state().decreaseRemaining();
            }
        }
        super.clearContent(i, j);
    }
}
