package game.backend.level;

public class Level3 extends Level2 {

    private static int WALL_SIZE = 3;
    private static int MAX_MOVES = 30;
    private static int INITIAL_REMAINING = WALL_SIZE * WALL_SIZE;

    @Override
    protected void fillCells() {
        super.fillCells();
        paintWalls();
    }

    private void paintWalls() {
        //FALTA TERMINAR
        int initialI = SIZE/2;
        int initialJ = SIZE/2;
        int diff = WALL_SIZE/2;
        for(int i = initialI; i < initialI + diff; i++ ) {

        }
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        return true;
        // aca hay que poner si un special move cae en el wall y que lo destruya
    }
    
}
