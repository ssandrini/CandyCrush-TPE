package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.Nothing;
import game.backend.move.Direction;
import javafx.scene.paint.Color;

public class Cell {
	
	private final Grid grid; ///////////
	private final Cell[] around = new Cell[Direction.values().length]; ////////////
	private Element content;
	private Color backgroundColor;

	public Cell(Grid grid) {
		this.grid = grid;
		this.content = new Nothing();
	}
	
	public void setAround(Cell up, Cell down, Cell left, Cell right) {
		this.around[Direction.UP.ordinal()] = up;
		this.around[Direction.DOWN.ordinal()] = down;
		this.around[Direction.LEFT.ordinal()] = left;
		this.around[Direction.RIGHT.ordinal()] = right;
	}

	public boolean hasFloor() {
		return !around[Direction.DOWN.ordinal()].isEmpty();
	}
	
	public boolean isMovable(){
		return content.isMovable();
	}
	
	public boolean isEmpty() {
		return !content.isSolid();
	}

	public Element getContent() {
		return content;
	}
	
	public void clearContent() {
		if (content.isMovable()) {
			Direction[] explosionCascade = content.explode();
			grid.cellExplosion(content);
			this.content = new Nothing();
			if (explosionCascade != null) {
				expandExplosion(explosionCascade);
				wallBlast();
			}
			this.content = new Nothing();
		}
	}

	private void wallBlast() {
		if(hasColor()) {
			if (getColor().equals(Color.SANDYBROWN)) {
				setColor(null);
				grid.state().decreaseRemaining();
			}
		}
	}

	private void expandExplosion(Direction[] explosion) {
		for(Direction d: explosion) {
			this.around[d.ordinal()].explode(d);
		}
	}
	
	private void explode(Direction d) {
		wallBlast();
		if (this.around[d.ordinal()] != null)
			this.around[d.ordinal()].explode(d);
		clearContent();
	}
	
	public Element getAndClearContent() {
		if (content.isMovable()) {
			Element ret = content;
			this.content = new Nothing();
			return ret;
		}
		return null;
	}

	public boolean fallUpperContent() {
		Cell up = around[Direction.UP.ordinal()];
		if (this.isEmpty() && !up.isEmpty() && up.isMovable()) {
			this.content = up.getAndClearContent();
			grid.wasUpdated();
			if (this.hasFloor()) {
				grid.tryRemove(this);
				return true;
			} else {
				Cell down = around[Direction.DOWN.ordinal()];
				return down.fallUpperContent();
			}
		} 
		return false;
	}

	public boolean hasColor() {
		return backgroundColor != null;
	}

	public Color getColor(){
		if(hasColor())
			return backgroundColor;
		return null;
	}

	public void setColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor ;
	}

	public void setContent(Element content) {
		this.content = content;
	}

}
