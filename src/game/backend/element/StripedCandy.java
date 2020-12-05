package game.backend.element;

import game.backend.move.Direction;

public abstract class StripedCandy extends Candy {

    protected Direction[] explosion = new Direction[2];
    protected String key;

    @Override
    public String getKey() {
        return String.format("%s-STRIPED-", key) + super.getKey();
    }

    @Override
    public String getFullKey() {
        return String.format("%s-STRIPED-", key) + super.getFullKey();
    }

    @Override
    public Direction[] explode() {
        return explosion;
    }

    @Override
    public long getScore() {
        return 80;
    }
}
