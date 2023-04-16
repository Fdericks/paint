package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Line class is responsible for drawing a line to the canvas 
 * based on the user's press and release of the mouse.
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge 
 *
 */
public class Line extends Shape {

	public Line() {
	}

	public Line(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, initialX, initialY, color);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(getInitialX(), getInitialY(), getNewX(), getNewY());
	}

}
