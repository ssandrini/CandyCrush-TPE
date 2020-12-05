package game.backend.element;

import game.backend.move.Direction;

public class VerticalStripedCandy extends StripedCandy {

	public VerticalStripedCandy() {
		explosion[0] = Direction.DOWN;
		explosion[1] = Direction.UP;
		key = "VERT";
	}

}
