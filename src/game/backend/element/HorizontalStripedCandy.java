package game.backend.element;

import game.backend.move.Direction;

public class HorizontalStripedCandy extends StripedCandy {

	public HorizontalStripedCandy() {
		explosion[0] = Direction.LEFT;
		explosion[1] = Direction.RIGHT;
		key = "HORIZ";
	}

}
