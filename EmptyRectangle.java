package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * EmptyRectangle class is responsible for drawing a hollow rectangle to the canvas
 * based on the user's press and release of the mouse.
 * EmptyRectangle inherits from Shape. 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class EmptyRectangle extends Shape {

	public EmptyRectangle() {
	}

	public EmptyRectangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(getX(), getY(), getWidth(), getHeight());

	}
}
